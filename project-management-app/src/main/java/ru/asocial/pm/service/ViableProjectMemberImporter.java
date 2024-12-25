package ru.asocial.pm.service;

import java.time.LocalDateTime;

import org.openapitools.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;
import ru.asocial.pm.model.entity.ProjectMemberEntity;
import ru.asocial.pm.repo.ProjectMemberRepository;

@Profile("viable")
@Component
public class ViableProjectMemberImporter {
    
    private static final Logger log = LoggerFactory.getLogger(ViableProjectMemberImporter.class);
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private ProjectMemberRepository projectMemberRepository;
    
    long current = 0;
    
    long target = 0;
    
    long batchSize = 1000;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    private record SignalMessage(long offset, long limit) {};
       
    @PostConstruct
    public void init() {
        current = projectMemberRepository.count();
        log.info("Current number of project members: " + current);
        
        target = current + batchSize;
        
        SignalMessage cm = new SignalMessage(current, batchSize);
        String msg = null;
        try {
            msg = objectMapper.writeValueAsString(cm);
        } catch (JsonProcessingException e) {
            log.error("Failed to send signal: ", e);
        }
        log.debug("Signal sent: " + msg);
        kafkaTemplate.send("signals", msg);
    }

    @KafkaListener(topics = "demo")
    public void importMember(String message, Acknowledgment ack) {
        if ("NODATA".equals(message)) {
            log.info("No data");
            return;
        }
        //EOS = end of stream
        if ("EOS".equals(message)) {
            log.info("End of stream. Sending new signal");
            target = current + batchSize;
            SignalMessage cm = new SignalMessage(current, batchSize);
            String msg = null;
            try {
                msg = objectMapper.writeValueAsString(cm);
            } catch (JsonProcessingException e) {
                log.error("Failed to send control message: ", e);
            }
            kafkaTemplate.send("signals", msg);
            return;
        }
        
        try {
            Employee employee = objectMapper.readValue(message, Employee.class);
            ProjectMemberEntity projectMember = new ProjectMemberEntity();
            projectMember.setFirstName(employee.getFirstName());
            projectMember.setLastName(employee.getLastName());
            projectMember.setExternalId(employee.getId());
            projectMember.setSource("kafka");
            projectMember.setDateTimeCreated(LocalDateTime.now());
            ProjectMemberEntity newEntity = projectMemberRepository.save(projectMember);
            log.info("Saved project member | id = " + newEntity.getId());
            current++;
        }
        catch (Exception e) {
            log.error("Save project member failed", e);
        }       
    }
    
}

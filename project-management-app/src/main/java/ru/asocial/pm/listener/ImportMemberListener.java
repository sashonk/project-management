package ru.asocial.pm.listener;

import org.openapitools.model.Employee;
import org.openapitools.model.ProjectMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.asocial.pm.model.entity.ProjectMemberEntity;
import ru.asocial.pm.repo.ProjectMemberRepository;

@Component
public class ImportMemberListener {
    
    private static final Logger log = LoggerFactory.getLogger(ImportMemberListener.class);
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @KafkaListener(topics = "demo")
    public void importMember(String message) {
        try {
            Employee employee = objectMapper.readValue(message, Employee.class);
            ProjectMemberEntity projectMember = new ProjectMemberEntity();
            projectMember.setFirstName(employee.getFirstName());
            projectMember.setLastName(employee.getLastName());
            projectMember.setExternalId(employee.getId());
            projectMember.setSource("kafka");                     
            ProjectMemberEntity newEntity = projectMemberRepository.save(projectMember);
            log.info("Saved project member | id = " + newEntity.getId());
        }
        catch (Exception e) {
            log.error("Save project member failed", e);
        }
    }
    
}

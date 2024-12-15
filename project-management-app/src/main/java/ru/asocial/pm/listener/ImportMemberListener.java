package ru.asocial.pm.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ImportMemberListener {
    
    private static final Logger log = LoggerFactory.getLogger(ImportMemberListener.class);

    @KafkaListener(topics = "demo")
    public void importMember(String message) {
        log.info(">>> " + message);
    }
    
}

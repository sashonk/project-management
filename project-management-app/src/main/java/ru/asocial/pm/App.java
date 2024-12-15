package ru.asocial.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.asocial.pm.controller", "ru.asocial.pm.repo",
        "ru.asocial.pm.filter", "ru.asocial.pm.entity", "ru.asocial.pm.service", "ru.asocial.pm.listener"})
@EnableJpaRepositories(basePackages = "ru.asocial.pm.repo")
@EnableScheduling
@EnableKafka
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("<<<<<---- STARTING ---->>>>>");
        SpringApplication.run(App.class, args);
        System.out.println("<<<<<---- WORKING ---->>>>>");
    }
}

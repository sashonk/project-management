package ru.asocial.pm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.asocial.pm.controller", "ru.asocial.pm.repo",
        "ru.asocial.pm.filter", "ru.asocial.pm.entity", "ru.asocial.pm.service"})
@EnableJpaRepositories(basePackages = "ru.asocial.pm.repo")
@EnableScheduling
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("begin");
        SpringApplication.run(App.class, args);
        System.out.println("------- <<<<<<< STARTED >>>>>>>> ------");
    }
}

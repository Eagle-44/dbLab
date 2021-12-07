package com.alex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.alex.controller", "com.alex.service", "com.alex.exceptions", "com.alex.config"})
@EntityScan({"com.alex.models"})
@EnableJpaRepositories({"com.alex.repository"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}



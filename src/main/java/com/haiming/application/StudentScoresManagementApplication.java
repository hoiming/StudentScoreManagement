package com.haiming.application;

import com.haiming.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class StudentScoresManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentScoresManagementApplication.class, args);
    }

}

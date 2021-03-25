package com.devresearch.devresearch;

import com.devresearch.devresearch.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DevResearchApplication {

//    @Bean
//    public CommandLineRunner init(@Autowired Usuarios usuarios) {
//        return args -> {
//
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(DevResearchApplication.class, args);
    }

}

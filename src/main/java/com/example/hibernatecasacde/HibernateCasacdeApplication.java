package com.example.hibernatecasacde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class HibernateCasacdeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCasacdeApplication.class, args);
    }

}

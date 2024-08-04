package com.wohr.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CleanArchitectureMain {
    public static void main(String[] args) {
        SpringApplication.run(CleanArchitectureMain.class, args);
    }
}
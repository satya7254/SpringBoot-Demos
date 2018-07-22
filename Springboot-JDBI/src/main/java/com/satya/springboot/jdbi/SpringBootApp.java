package com.satya.springboot.jdbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootApp extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApp.class, args);
    }

}

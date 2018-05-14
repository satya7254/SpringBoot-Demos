package com.satya.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.satya.springboot.config.ServerProperties;

@SpringBootApplication
@ComponentScan(basePackages = { "com.satya.springboot"})
@EnableJpaRepositories(basePackages="com.satya.springboot")
@EntityScan(basePackages="com.satya.springboot")
@EnableConfigurationProperties({ServerProperties.class})
public class SpringBootApp {
	
    public static void main(String[] args){
    	// Spring Boot application //
        SpringApplication.run(SpringBootApp.class, args);
        System.out.println("Spring Boot application started...");
    }
}

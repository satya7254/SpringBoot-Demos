package com.satya.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.satya.controllers.EmpConsumerControllerClient;

@SpringBootApplication
public class SpringBootConsumerApp {

	public static void main(String[] args) throws RestClientException, IOException {
		
		ApplicationContext ctx = SpringApplication.run(SpringBootConsumerApp.class, args);
		
		EmpConsumerControllerClient consumerControllerClient=ctx.getBean(EmpConsumerControllerClient.class);
		consumerControllerClient.getEmployee();
		
	}
	
	@Bean
	public  EmpConsumerControllerClient  consumerControllerClient(){
		return  new EmpConsumerControllerClient();
	}
}
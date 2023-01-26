package com.example.OrderService;

import com.example.OrderService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class OrderServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


@Bean
public WebClient.Builder WebClientBuilder(){
return  WebClient.builder();

}

}


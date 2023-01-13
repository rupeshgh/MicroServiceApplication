package com.example.UserService;

import com.example.UserService.Model.Roles;
import com.example.UserService.Model.User;
import com.example.UserService.Service.RolesService;
import com.example.UserService.Service.UserService;
import org.apache.hc.core5.reactor.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserService userService, RolesService rolesService){
		return args -> {
			rolesService.saveRole(new Roles(null,"ROLE_USER"));
			rolesService.saveRole(new Roles(null,"ROLE_ADMIN"));



			userService.save(new User(null,"xyz1","xyz1@gmail.com","123",new ArrayList<>()));
			userService.save(new User(null,"xyz2","xyz2@gmail.com","123",new ArrayList<>()));
			userService.save(new User(null,"xyz3","xyz3@gmail.com","123",new ArrayList<>()));
			userService.save(new User(null,"xyz4","xyz4@gmail.com","123",new ArrayList<>()));
			userService.save(new User(null,"xyz5","xyz5@gmail.com","123",new ArrayList<>()));


			userService.addRoleToUser("xyz1@gmail.com","ROLE_ADMIN");
			userService.addRoleToUser("xyz2@gmail.com","ROLE_USER");
			userService.addRoleToUser("xyz3@gmail.com","ROLE_USER");
			userService.addRoleToUser("xyz4@gmail.com","ROLE_USER");
			userService.addRoleToUser("xyz5@gmail.com","ROLE_USER");
		};

	}
}

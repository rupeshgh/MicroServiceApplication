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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserService userService, RolesService rolesService){
		return args -> {

//
//
			Roles userRole=new Roles();
			userRole.setName("ROLE_USER");

			Roles adminRole=new Roles();
			adminRole.setName("ROLE_ADMIN");
//

			Roles userRole1=new Roles();
			userRole1.setName("ROLE_USER");





			User ub=new User();
			ub.setEmail("asdasdada");
			ub.setPassword("asdasda");
			ub.setUsername("ub");

			ub.addRoles(userRole);

			userService.save(ub);
//
//
//
			User uc=new User();
			uc.setEmail("asdasdadaasdas");
			uc.setPassword("asdasda");
			uc.setUsername("uc");
			uc.addRoles(userRole1);
			userService.save(uc);
//
//
//
///





		};

	}
}

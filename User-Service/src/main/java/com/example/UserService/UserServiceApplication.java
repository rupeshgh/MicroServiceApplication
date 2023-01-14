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


			Set<Roles> UserRole=new HashSet<>();
			UserRole.add(new Roles(null,"ROLE_USER",null));
//
			Set<Roles>MixedRole=new HashSet<>();

			MixedRole.add(new Roles(null,"ROLE_USER",null));
			MixedRole.add(new Roles(null,"ROLE_ADMIN",null));
//
			User u1=new User(null,"xyz1","xyz1@gmail.com","123",MixedRole);
			userService.save(u1);

			User u2=new User(null,"xyz2","xyz2@gmail.com","123",MixedRole);
			userService.save(u2);

			User u3=new User(null,"xyz3","xyz3@gmail.com","123",MixedRole);
			userService.save(u3);
			User u4=new User(null,"xyz4","xyz4@gmail.com","123",MixedRole);
			userService.save(u4);



		};

	}
}

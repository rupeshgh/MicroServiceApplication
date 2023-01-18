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


			User u1 =new User();
			u1.setEmail("asdasdadaasdas");
			u1.setPassword("asdasda");
			u1.setUsername("uc");


			User u2 = new User();
			u2.setEmail("asdasdadaasdaasdasds");
			u2.setPassword("asdasdaasdasd");
			u2.setUsername("uc");


			User u3 = new User();
			u3.setEmail("assds");
			u3.setPassword("asdasdaasdasd");
			u3.setUsername("uc");



			Roles r1 =new Roles("user_role");
			Roles r2= new Roles("admin_role");
			Roles r3=new Roles("ok_role");

//			u2.setUserRoles(new ArrayList<>());
			u1.addRoles(r1);
			u1.addRoles(r2);



//			u2.setUserRoles(new ArrayList<>());
			u2.addRoles(r1);
			u2.addRoles(r3);

			u3.addRoles(r1);



			r1.addUser(u1);
			r1.addUser(u2);
			r2.addUser(u1);
			r3.addUser(u2);
			r1.addUser(u3);


			userService.save(u1);
			userService.save(u2);



		};

	}
}

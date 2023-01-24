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

			//Many-to-many bidirectional association


			Roles r1 =new Roles("user_role");
			Roles r2= new Roles("admin_role");
			Roles r3=new Roles("ok_role");

			User u1 =new User();
			u1.setEmail("john@gmail.com");
			u1.setPassword("123");
			u1.setUsername("john");

			u1.addRoles(r1);
			u1.addRoles(r2);
			r1.addUser(u1);
			r2.addUser(u1);




			User u2 = new User();
			u2.setEmail("ben@gmail.com");
			u2.setPassword("123");
			u2.setUsername("ben");

			u2.addRoles(r1);
			u2.addRoles(r3);
			r1.addUser(u2);
			r3.addUser(u2);




			User u3 = new User();
			u3.setEmail("harry");
			u3.setPassword("123");
			u3.setUsername("harry");

			u3.addRoles(r1);
			r1.addUser(u3);



			rolesService.saveRole(r1);
			rolesService.saveRole(r2);
			rolesService.saveRole(r3);

			userService.save(u1);
			userService.save(u2);
			userService.save(u3);




			userService.createAndSaveNewUserWithRole();

//			userService.deleteUser(2);


		};

	}
}

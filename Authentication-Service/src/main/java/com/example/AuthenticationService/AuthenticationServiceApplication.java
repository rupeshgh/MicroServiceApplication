package com.example.AuthenticationService;

import com.example.AuthenticationService.Model.Roles;
import com.example.AuthenticationService.Model.User;
import com.example.AuthenticationService.service.RolesService;
import com.example.AuthenticationService.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(UserService userService, RolesService rolesService){
		return args -> {

			//Many-to-many bidirectional association


			Roles r1 =new Roles("ROLE_USER");
			Roles r2= new Roles("ROLE_ADMIN");
			Roles r3= new Roles("ROLE_MANAGER");

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

			r1.addUser(u2);




			User u3 = new User();
			u3.setEmail("harry");
			u3.setPassword("123");
			u3.setUsername("harry");

			u3.addRoles(r3);
			r3.addUser(u3);



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

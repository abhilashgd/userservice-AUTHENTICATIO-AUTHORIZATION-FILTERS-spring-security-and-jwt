package io.gateways.userservice;
/*
 * @author Abhilash GD
 * @Version 1.0
 * since 23/12/2021
 */
import io.gateways.userservice.domain.Role;
import io.gateways.userservice.domain.User;
import io.gateways.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return arg ->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"abhilash gubbi",
					"abhilashgd", "1234",new ArrayList<>()));
			userService.saveUser(new User(null,"user two",
					"user2", "1234",new ArrayList<>()));
			userService.saveUser(new User(null,"user three",
					"user3", "1234",new ArrayList<>()));
			userService.saveUser(new User(null,"user four",
					"user4", "1234",new ArrayList<>()));

			userService.addRoleToUser("user2", "ROLE_USER");
			userService.addRoleToUser("user2", "ROLE_MANAGER");
			userService.addRoleToUser("user3", "ROLE_ADMIN");
			userService.addRoleToUser("user3", "ROLE_MANAGER");
			userService.addRoleToUser("abhilashgd", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("abhilashgd", "ROLE_MANAGER");
			userService.addRoleToUser("user4", "ROLE_USER");

		};
	}
}

package com.mongodb.springbootmongodb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import repository.UserRepository;

@EnableMongoRepositories(basePackageClasses  = UserRepository.class)
@SpringBootApplication
//@ComponentScan(basePackages="document")
@ComponentScan(basePackages="resource")
@ComponentScan(basePackages="repository")
@ComponentScan(basePackages="service")
public class SpringbootMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
	}
	
	
//	CommandLineRunner commandLineRunner(UserRepository userRepository) {
//		return strings -> {
//			userRepository.save(new Users("101", "Neelesh", 162));
//			userRepository.save(new Users("102", "User2", 170));
//			userRepository.save(new Users("103", "User5", 168));
//			userRepository.save(new Users("104", "User4", 164));
//			
//		};
//	}
}

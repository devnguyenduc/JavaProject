package com.initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

			for (int i = 0; i < 5; i++) {
				Person user = personRepository.save(new Person("" + i, "Test", String.valueOf(i + 12)));

				System.out.println("<<<<<<<<<<<<<Adding User >>>>>>>>>>>>>>");
				System.out.println("***" + user.toString() + "***");
			}

			System.out.println("<<<<<<<<<<<<<Get All  User >>>>>>>>>>>>>>");
			List<Person> alluser = personRepository.findAll();
			alluser.forEach(item -> System.out.println(item));

			alluser.clear();

			System.out.println("<<<<<<<<<<<<<Find User By Name >>>>>>>>>>>>>>");
			alluser = personRepository.findByLastName("Test");
			alluser.forEach(item -> System.out.println(item));

			System.out.println("Executed");

		};
	}
}
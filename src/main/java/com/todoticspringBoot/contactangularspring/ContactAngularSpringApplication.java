package com.todoticspringBoot.contactangularspring;

import com.todoticspringBoot.contactangularspring.entity.Contact;
import com.todoticspringBoot.contactangularspring.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactAngularSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactAngularSpringApplication.class, args);



		}
		@Bean
       CommandLineRunner runner(ContactRepository contactRepository){
		return args -> {//con funciones landa
			//@Override
			//public void run(String... args) throws Exception
			{
				List<Contact> contacts = Arrays.asList(
						new Contact(),
						new Contact("calr", "dede@gmail.com", LocalDateTime.now()),
						new Contact("shon", "dede@gmail.com", LocalDateTime.now()),
						new Contact("mike", "dede@gmail.com", LocalDateTime.now()),
						new Contact("big", "dede@gmail.com", LocalDateTime.now())
				);
				contactRepository.saveAll(contacts);
			}

		};


	   }
//ver min 43
	}



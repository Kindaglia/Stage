package com.example.demo;
import com.example.demo.Utente;
import com.example.demo.repository.UtenteRepo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//repo utente
	@Bean
	CommandLineRunner commandLineRunner(UtenteRepo utenteRepo){
		return args -> {

			//create
			Utente peter = new Utente (2,"cf_test", "cogn","nom","userna");
			utenteRepo.save(peter);

		};
	}
}

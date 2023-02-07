package com.example.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.AziendaRepo;
import com.example.demo.repository.DocRepo;
import com.example.demo.repository.UtenteRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//repo utente
	@Bean
	CommandLineRunner commandLineRunner(UtenteRepo utenteRepo,AziendaRepo aziendaRepo,DocRepo docRepo ){
		return args -> {

			//create
			Utente peter = new Utente (2,"cf_test", "cogn","nom","userna");
			utenteRepo.save(peter);
			Azienda tesla = new Azienda (2,"rosso", "55555");
			aziendaRepo.save(tesla);
			Doc docc = new Doc (2584);
			docRepo.save(docc);
		};
	}
}

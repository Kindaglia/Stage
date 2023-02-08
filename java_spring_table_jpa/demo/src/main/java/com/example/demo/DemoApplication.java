package com.example.demo;



import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.repository.AziendaRepo;
import com.example.demo.repository.CaricoRepo;
import com.example.demo.repository.DocRepo;
import com.example.demo.repository.Tipo_docRepo;
import com.example.demo.repository.UtenteRepo;
import com.example.demo.repository.Utente_aziendaRepo;  

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//repo utente
	@Bean
	CommandLineRunner commandLineRunner(UtenteRepo utenteRepo,AziendaRepo aziendaRepo,
								DocRepo docRepo,Utente_aziendaRepo utente_aziendaRepo,
								CaricoRepo caricoRepo, Tipo_docRepo tipo_docRepo ){
		return args -> {

			//create
			Utente peter = new Utente (3,"cf_test", "cogn","nom","userna");
			utenteRepo.save(peter);
			Azienda tesla = new Azienda (3,"rosso", "55555");
			aziendaRepo.save(tesla);
			
			Utente_azienda utaz = new Utente_azienda(1,peter,tesla);
			utente_aziendaRepo.save(utaz);


			String sDate1="1998-2-12";  
			Date date1  = Date.valueOf(sDate1);
			String sDate2="2050-6-14";  
			Date date2  = Date.valueOf(sDate2);

			Carico crrepo = new Carico(1,date1,10L,date2,"stato",5,5);
			caricoRepo.save(crrepo);

			Tipo_doc tdoc = new Tipo_doc(10,"testmome","descrizione bella");
			tipo_docRepo.save(tdoc);


			Doc docc = new Doc (10,crrepo,tdoc);
			docRepo.save(docc);
			
			Utente ted = new Utente (3,"cf_test", "cogn","nom","userna");
			Azienda ford = new Azienda (3,"rosso", "55555");
			Utente_azienda ut_az = new Utente_azienda(1,ted,ford);
			
			Doc docc2 = new Doc (3,ut_az,crrepo,tdoc);
			docRepo.save(docc2);


		};
	}
	

}

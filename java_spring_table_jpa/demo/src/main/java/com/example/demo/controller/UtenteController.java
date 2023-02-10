package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.command.utente.UtenteComGet;
import com.example.demo.entities.Utente;
import com.example.demo.repository.UtenteRepo;
import com.example.demo.response.UtenteResponse;
import com.example.demo.service.UtenteService;


@RestController
public class UtenteController {
    
    @Autowired 
    private BeanFactory beanFactory;
    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteResponse utenteResponse;


    

    // chiamaete get, tutti gli utenti
    @GetMapping(value="/utenti",produces = "application/json")
    public UtenteResponse  getUtenti(){
        UtenteComGet utenteComGet = beanFactory.getBean(UtenteComGet.class); //, variabili
        utenteResponse =  utenteComGet.Execute();  
        System.out.println(utenteResponse);  
        return utenteResponse; //body di risposta
        
        
    }




    //il path in {} non è a caso 
    @GetMapping("/utente/{UtenteId}")
    public Utente getUtente(@PathVariable Integer UtenteId){
        return utenteRepo.findById(UtenteId).orElseThrow();
      
    }

    /// chiamate post 
    @PostMapping("/utenti")
    public Utente createUtente(@RequestBody Utente newUtente){
        return utenteRepo.save(newUtente);
    }

    //put, update utenti
    @PutMapping("/utente/{id}")
    Utente replaceEmployee(@RequestBody Utente newUtente, @PathVariable Integer id) {

        return utenteRepo.findById(id)
            .map(utente -> {
                utente.setCf(newUtente.getCf());
                utente.setCognome(newUtente.getCognome());
                utente.setNome(newUtente.getNome());
                utente.setUsername(newUtente.getUsername());
                return utenteRepo.save(utente);
            })
            .orElseGet(() -> {
                return utenteRepo.save(newUtente);
            });
    }

    @DeleteMapping("/utente/{UtenteId}")
    public Utente deleteById(@PathVariable  Integer UtenteId) {
        Optional<Utente> verifyPresent = utenteRepo.findById(UtenteId);
        if (!verifyPresent.isPresent()) {
            Utente UtenteNull = new Utente(UtenteId);
            return UtenteNull;
        }else{
            Utente utenteDeleted = utenteRepo.findById(UtenteId).get();
            utenteRepo.deleteById(UtenteId);
            return utenteDeleted;
        }
        
    }

    

}

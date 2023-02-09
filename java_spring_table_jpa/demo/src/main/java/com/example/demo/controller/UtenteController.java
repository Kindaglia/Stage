package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Utente;
import com.example.demo.repository.UtenteRepo;


@RestController
public class UtenteController {
    
    @Autowired
    private UtenteRepo utenteRepo;

    // chiamaete get, tutti gli utenti
    @GetMapping("/utenti")
    public List<Utente> getUtenti(){
        return utenteRepo.findAll();
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
        Utente pippo = utenteRepo.findById(UtenteId).get();
        utenteRepo.deleteById(UtenteId);
        return pippo;
    }

    

}

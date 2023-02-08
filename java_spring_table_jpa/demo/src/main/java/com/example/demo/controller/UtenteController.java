package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Utente;
import com.example.demo.repository.UtenteRepo;


@RestController
public class UtenteController {
    
    @Autowired
    private UtenteRepo utenteRepo;
     

    // chiamaete get
    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/utenti")
    public List<Utente> getUtenti(){
        return utenteRepo.findAll();
    }


    /* @GetMapping("/utente/{id}")
    public Utente getUtente(){
        Optional<Utente> lu = utenteRepo.findById(3);
      
    } */

    /// chiamate post 
    @PostMapping("/utenti")
    public Utente createUtente(@RequestBody Utente newUtente){
        return utenteRepo.save(newUtente);
    }


}

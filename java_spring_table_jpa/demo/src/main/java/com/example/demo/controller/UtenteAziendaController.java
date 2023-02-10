package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Utente_azienda;
import com.example.demo.repository.Utente_aziendaRepo;

@RestController
public class UtenteAziendaController {

    @Autowired
    private Utente_aziendaRepo utente_aziendaRepo;

    // chiamaete get, tutti gli utenti
    @GetMapping("/utentiAziende")
    public List<Utente_azienda> getUtentiAziende(){
        return utente_aziendaRepo.findAll();
    }

    //il path in {} non è a caso 
    @GetMapping("/utentiAzienda/{UtenteAziendaId}")
    public Utente_azienda getUtenteAzienda(@PathVariable Integer UtenteAziendaId){
        return utente_aziendaRepo.findById(UtenteAziendaId).orElseThrow();
      
    }

    /// chiamate post 
    @PostMapping("/utentiAziende")
    public Utente_azienda createUtentiAzienda(@RequestBody Utente_azienda newUtentiAzienda){
        return utente_aziendaRepo.save(newUtentiAzienda);
    }
}

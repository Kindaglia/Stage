package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Azienda;
import com.example.demo.repository.AziendaRepo;

@RestController
public class AziendaController {
    @Autowired
    private AziendaRepo aziendaRepo;

    // chiamaete get, tutti gli utenti
    @GetMapping("/aziende")
    public List<Azienda> getAziende(){
        return aziendaRepo.findAll();
    }

    //il path in {} non è a caso 
    @GetMapping("/azienda/{AziendaId}")
    public Azienda getAzienda(@PathVariable Integer AziendaId){
        return aziendaRepo.findById(AziendaId).orElseThrow();
      
    }

    /// chiamate post 
    @PostMapping("/aziende")
    public Azienda createAzienda(@RequestBody Azienda newAzienda){
        return aziendaRepo.save(newAzienda);
    }

    
}

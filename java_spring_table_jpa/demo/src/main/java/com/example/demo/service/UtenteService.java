package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Utente;
import com.example.demo.repository.UtenteRepo;
import com.example.demo.service.UtenteService;


@Service
public class UtenteService {
    @Autowired
    private UtenteRepo utenteRepo; 
    
    public UtenteService(UtenteRepo utenteRepo) {
        this.utenteRepo = utenteRepo;
    }

    public Utente createUtente(Utente utente) {
        return utenteRepo.save(utente);
    }

    public Utente updateUtente(Utente utente) {
        return utenteRepo.save(utente);
    }

    public Utente getUtenteById(Integer id) {
        Optional<Utente> utente = utenteRepo.findById(id);
        return utente.orElse(null);
    }

    public List<Utente> getAllUtenti() {
        return utenteRepo.findAll();
    }

    public void deleteUtente(Integer id) {
        utenteRepo.deleteById(id);
    }

    public UtenteService(){}

    
}

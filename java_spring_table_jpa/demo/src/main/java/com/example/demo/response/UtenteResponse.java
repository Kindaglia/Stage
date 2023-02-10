package com.example.demo.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Utente;

import lombok.Generated;

@Component
public class UtenteResponse {
    private Utente utente;
    private List<Utente> utenti;
    private String message;

    public UtenteResponse(){}


    public void setUtente(Utente utente) {
        this.utente = utente;
    }


    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    


}

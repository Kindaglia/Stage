package com.example.demo.response;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Utente;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Generated;

@Component
@ResponseBody
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


    public Utente getUtente() {
        return utente;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }


    public String getMessage() {
        return message;
    }


    @Override
    public String toString() {
        return "UtenteResponse [utente=" + utente + ", utenti=" + utenti + ", message=" + message + "]";
    }

    
    


}

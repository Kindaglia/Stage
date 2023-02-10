package com.example.demo.command.utente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Utente;
import com.example.demo.response.UtenteResponse;
import com.example.demo.service.UtenteService;
import java.lang.Integer;

@Component
@Scope("prototype")
public class UtenteCommandGetById {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteResponse utenteResponse;

    private Integer IdUtente;


    public UtenteCommandGetById(Integer IdUtente) {
        super();
        this.IdUtente = IdUtente;
    }

    public Boolean CanExecute(){
        return true;
    }
    
    public UtenteResponse DoExecute(){
        Utente utenteById = utenteService.getUtenteById(IdUtente);
        utenteResponse.setUtente(utenteById);
        return utenteResponse;
    }

    public UtenteResponse Execute(){
        if(!CanExecute()){
            String messaggioErrorre = "non puoi farlo";
            utenteResponse.setMessage(messaggioErrorre);
            return utenteResponse;
        }
        return DoExecute();
    }



    
}

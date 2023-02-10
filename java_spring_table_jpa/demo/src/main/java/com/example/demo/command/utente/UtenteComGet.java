package com.example.demo.command.utente;

import java.lang.reflect.Executable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.UtenteService;
import com.example.demo.entities.Utente;
import com.example.demo.response.UtenteResponse;

@Component
public class UtenteComGet {
    @Autowired
    private UtenteService utenteService;

    @Autowired
    private UtenteResponse utenteResponse;

    public UtenteComGet() {

    }
    public Boolean CanExecute(){
            return true;
    }

    public UtenteResponse DoExecute(){
        List<Utente> listaUteni = utenteService.getAllUtenti();
        utenteResponse.setUtenti(listaUteni);
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
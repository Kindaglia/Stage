

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Carico;
import com.example.demo.repository.CaricoRepo;




@RestController
public class CaricoController {
    
    @Autowired
    private CaricoRepo caricoRepo;

    // chiamaete get, tutti gli utenti
    @GetMapping("/carichi")
    public List<Carico> getCarichi(){
        return caricoRepo.findAll();
    }


    //il path in {} non è a caso 
    @GetMapping("/carichi/{CaricoId}")
    public Carico getUtente(@PathVariable Integer CaricoId){
        return caricoRepo.findById(CaricoId).orElseThrow();
      
    }

    /// chiamate post 
    @PostMapping("/carichi")
    public Carico createUtente(@RequestBody Carico newCarico){
        return caricoRepo.save(newCarico);
    }


}

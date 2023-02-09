
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Tipo_doc;
import com.example.demo.repository.Tipo_docRepo;


@RestController
public class TipoDocController {
    
    @Autowired
    private Tipo_docRepo tipo_docRepo;

    // chiamaete get, tutti gli utenti
    @GetMapping("/tipDocs")
    public List<Tipo_doc> getCarichi(){
        return tipo_docRepo.findAll();
    }


    //il path in {} non è a caso 
    @GetMapping("/tipDocs/{TipDocsId}")
    public Tipo_doc gettipDocs(@PathVariable Integer TipDocsId){
        return tipo_docRepo.findById(TipDocsId).orElseThrow();
      
    }

    /// chiamate post 
    @PostMapping("/tipDocs")
    public Tipo_doc createtipDocs(@RequestBody Tipo_doc newtipDocs){
        return tipo_docRepo.save(newtipDocs);
    }


}

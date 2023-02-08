package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Doc;
import com.example.demo.repository.DocRepo;

@RestController
public class DocCotnroller {
    @Autowired
    private DocRepo docRepo;

    // chiamaete get, tutti gli utenti
    @GetMapping("/docs")
    public List<Doc> getDocs(){
        return docRepo.findAll();
    }

    //il path in {} non è a caso 
    @GetMapping("/doc/{DocId}")
    public Doc getDoc(@PathVariable Integer DocId){
        return docRepo.findById(DocId).orElseThrow();
      
    }

    /// chiamate post 
    @PostMapping("/docs")
    public Doc createDoc(@RequestBody Doc newDoc){
        return docRepo.save(newDoc);
    }
}

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Utente;

@Repository
public interface UtenteRepo
 extends CrudRepository<Utente, Integer>, JpaSpecificationExecutor<Utente> {

    

}

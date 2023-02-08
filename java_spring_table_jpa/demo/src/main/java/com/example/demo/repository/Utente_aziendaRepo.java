package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Doc;
import com.example.demo.Utente_azienda;

@Repository
public interface Utente_aziendaRepo  extends JpaRepository<Utente_azienda, Integer> {

}

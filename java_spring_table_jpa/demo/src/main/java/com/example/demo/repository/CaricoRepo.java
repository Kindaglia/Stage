package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Carico;

@Repository
public interface CaricoRepo
 extends CrudRepository<Carico, Integer>, JpaSpecificationExecutor<Carico> {

    

}



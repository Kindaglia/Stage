package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Tipo_doc;


@Repository
public interface Tipo_docRepo
 extends CrudRepository<Tipo_doc, Integer>, JpaSpecificationExecutor<Tipo_doc> {

    

}
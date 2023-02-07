package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Doc;

@Repository
public interface DocRepo
 extends CrudRepository<Doc, Integer>, JpaSpecificationExecutor<Doc> {

}

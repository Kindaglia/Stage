    package com.example.demo.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

import com.example.demo.entities.Azienda;

    @Repository
    public interface AziendaRepo  extends JpaRepository<Azienda, Integer>{


    }



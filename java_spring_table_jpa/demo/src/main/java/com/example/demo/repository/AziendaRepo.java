    package com.example.demo.repository;

    import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;

    import com.example.demo.Azienda;

    @Repository
    public interface AziendaRepo
    extends CrudRepository<Azienda, Integer>, JpaSpecificationExecutor<Azienda> {


    }



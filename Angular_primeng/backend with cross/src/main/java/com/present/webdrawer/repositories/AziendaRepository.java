package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.Azienda;

@Repository
public interface AziendaRepository extends BaseRepository<Azienda, Long>, BaseRepositoryCustom<Azienda, Long> {

    Iterable<Azienda> findByRagSocialeContaining(String ragSociale);

}

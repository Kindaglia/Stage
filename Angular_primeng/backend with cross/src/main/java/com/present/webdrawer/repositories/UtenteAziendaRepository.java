package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.UtenteAzienda;

@Repository
public interface UtenteAziendaRepository extends BaseRepository<UtenteAzienda, Long>, BaseRepositoryCustom<UtenteAzienda, Long> {

}

package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.UtenteAziendaProfilo;

@Repository
public interface UtenteAziendaProfiloRepository extends BaseRepository<UtenteAziendaProfilo, Long>, BaseRepositoryCustom<UtenteAziendaProfilo, Long> {

}

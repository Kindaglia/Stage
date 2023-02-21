package com.present.webdrawer.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.Utente;

@Repository
public interface UtenteRepository extends BaseRepository<Utente, Long>, BaseRepositoryCustom<Utente, Long> {

    @Query("SELECT u FROM Utente u WHERE u.nome LIKE %:filtro% OR u.cognome LIKE %:filtro%")
    Iterable<Utente> findByNomeOrCognome(String filtro);

}

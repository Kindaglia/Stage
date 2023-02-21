package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.Carico;

@Repository
public interface CaricoRepository extends BaseRepository<Carico, Long>, BaseRepositoryCustom<Carico, Long> {

}

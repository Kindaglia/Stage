package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.TipoCarico;

@Repository
public interface TipoCaricoRepository extends BaseRepository<TipoCarico, Long>, BaseRepositoryCustom<TipoCarico, Long> {

}

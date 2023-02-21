package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.TipoDoc;

@Repository
public interface TipoDocRepository extends BaseRepository<TipoDoc, Long>, BaseRepositoryCustom<TipoDoc, Long> {

}

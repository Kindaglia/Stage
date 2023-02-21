package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.Permessi;

@Repository
public interface PermessiRepository extends BaseRepository<Permessi, Long>, BaseRepositoryCustom<Permessi, Long> {

}

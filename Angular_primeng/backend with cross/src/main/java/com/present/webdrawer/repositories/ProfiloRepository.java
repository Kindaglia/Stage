package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.Profilo;

@Repository
public interface ProfiloRepository extends BaseRepository<Profilo, Long>, BaseRepositoryCustom<Profilo, Long> {

}

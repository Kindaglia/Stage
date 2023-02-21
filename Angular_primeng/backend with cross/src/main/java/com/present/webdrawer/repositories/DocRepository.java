package com.present.webdrawer.repositories;

import org.springframework.stereotype.Repository;

import com.present.webdrawer.entities.Doc;

@Repository
public interface DocRepository extends BaseRepository<Doc, Long>, BaseRepositoryCustom<Doc, Long> {

}

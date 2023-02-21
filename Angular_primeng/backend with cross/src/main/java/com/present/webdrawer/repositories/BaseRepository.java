package com.present.webdrawer.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {

  @Override
  @Query("select e from #{#entityName} e where e.deleted=false")
  List<T> findAll();

  @Override
  @Query("select e from #{#entityName} e where e.deleted=false and e.id=?1")
  Optional<T> findById(ID id);

  @Query("select e from #{#entityName} e where e.id=?1")
  Optional<T> findByIdIncludingDeleted(ID id);

  @Override
  <S extends T> S save(S entity);

}
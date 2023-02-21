package com.present.webdrawer.repositories;

import java.util.List;

interface BaseRepositoryCustom<T, ID> {

  public <S extends T> Object softDelete(ID id, T entity);

  public List<Number> retrieveRevisionIds(T entity, ID id);

  public <T> Object getEntityAtRevisionId(Class<?> entityClass, ID id);

}
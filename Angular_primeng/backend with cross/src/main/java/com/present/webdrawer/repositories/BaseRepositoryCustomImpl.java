package com.present.webdrawer.repositories;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.present.webdrawer.helpers.BaseEntity;

@NoRepositoryBean
public class BaseRepositoryCustomImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements BaseRepositoryCustom<T, ID> {

    public BaseRepositoryCustomImpl(JpaEntityInformation<T, ID> entityInformation,
            EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    private EntityManager entityManager;

    @Override
    public <S extends T> Object softDelete(ID id, T entity) {

        ((BaseEntity) entity).setDeleted(true);

        return entity;
    }

    @Override
    public List<Number> retrieveRevisionIds(T entity, ID id) {
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        List<Number> revisions = auditReader.getRevisions(entity.getClass(), id);

        return revisions;
    }

    public <T> Object getEntityAtRevisionId(Class<?> entityClass, ID id) {
        // Example 680. Getting the Customer entity at a given revision: Ref:
        // https://docs.jboss.org/hibernate/orm/5.6/userguide/html_single/Hibernate_User_Guide.html#envers-queries
        T entity = (T) AuditReaderFactory
                .get(entityManager)
                .createQuery()
                .forEntitiesAtRevision(entityClass, (Number) id)
                .getSingleResult();

        return entity;
    }

}

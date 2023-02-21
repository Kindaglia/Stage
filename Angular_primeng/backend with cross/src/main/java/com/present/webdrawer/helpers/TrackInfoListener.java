package com.present.webdrawer.helpers;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.hibernate.envers.EntityTrackingRevisionListener;
import org.hibernate.envers.RevisionType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.repository.support.Repositories;

import com.present.webdrawer.repositories.BaseRepository;

import lombok.Data;

@Data
public class TrackInfoListener implements EntityTrackingRevisionListener, ApplicationContextAware {

    private BaseRepository repo;
    private static ApplicationContext appContext;

    Repositories repositories;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    public BaseRepository getRepository(AbstractPersistable entity) {
        return (BaseRepository) repositories.getRepositoryFor(entity.getClass()).get();
    }

    // private retrieveRepositoryByEntityName

    /*
     * Metodo chiamato a seguito alla modifica di una Entity (a seguito di:
     * inserimento, aggiornamento, cancellazione)
     * 
     * @see
     * org.hibernate.envers.EntityTrackingRevisionListener#entityChanged(java.lang.
     * Class, java.lang.String, java.io.Serializable,
     * org.hibernate.envers.RevisionType, java.lang.Object)
     */
    @Override
    public void entityChanged(Class entityClass, String entityName, Serializable entityId, RevisionType revisionType,
            Object revisionEntity) {

        Repositories repositories = new Repositories(this.appContext);
        this.repo = (BaseRepository) repositories.getRepositoryFor(entityClass).get();

        Optional<BaseEntity> entity = this.repo.findByIdIncludingDeleted(entityId);

        Date timestamp = new Date(((TrackInfo) revisionEntity).getTimestamp());

        if ((entity.get()).getDeleted() && revisionType.equals(RevisionType.MOD)) {
            auditActionDel(entityClass, revisionEntity, timestamp);

        } else {
            switch (revisionType) {
                case ADD -> auditActionAdd(entityClass, revisionEntity, timestamp);
                case DEL -> auditActionDel(entityClass, revisionEntity, timestamp);
                case MOD -> auditActionMod(entityClass, revisionEntity, timestamp);

            }

        }

    }

    /**
     * Gestione dell'Audit a seguito dell'aggiunta di una Entity
     * 
     * @param entityClass    La classe dell'entità inserita
     * @param revisionEntity La RevisionEntity di riferimento (TrackInfo)
     * @param timestamp
     * @return
     */
    private Object auditActionMod(Class entityClass, Object revisionEntity, Date timestamp) {
        ((TrackInfo) revisionEntity).setWhoUpd("developer");
        ((TrackInfo) revisionEntity).setDataUpd(timestamp);
        return revisionEntity;
    }

    /**
     * Gestione dell'Audit a seguito della cancellazione di una Entity
     * 
     * @param entityClass    La classe dell'entità cancellata
     * @param revisionEntity La RevisionEntity di riferimento (TrackInfo)
     * @param timestamp
     * @return
     */
    private Object auditActionDel(Object entityClass, Object revisionEntity, Date timestamp) {
        ((TrackInfo) revisionEntity).setWhoDel("developer");
        ((TrackInfo) revisionEntity).setDataDel(timestamp);
        return revisionEntity;
    }

    /**
     * Gestione dell'Audit a seguito della modifica di una Entity
     * 
     * @param entityClass    La classe dell'entità modificata
     * @param revisionEntity La RevisionEntity di riferimento (TrackInfo)
     * @param timestamp
     * @return
     */
    private Object auditActionAdd(Object entityClass, Object revisionEntity, Date timestamp) {
        ((TrackInfo) revisionEntity).setWhoIns("developer");
        ((TrackInfo) revisionEntity).setDataIns(timestamp);
        return revisionEntity;
    }

    /*
     * @see org.hibernate.envers.RevisionListener#newRevision(java.lang.Object)
     */
    @Override
    public void newRevision(Object entity) {
    }

}
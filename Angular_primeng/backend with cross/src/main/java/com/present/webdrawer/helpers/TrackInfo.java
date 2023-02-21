package com.present.webdrawer.helpers;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * TrackInfo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "track_info_revs")
@EqualsAndHashCode
@RevisionEntity(TrackInfoListener.class)
public class TrackInfo implements Serializable {

    @Id
    @GeneratedValue
    @RevisionNumber
    protected Long id;

    @RevisionTimestamp
    protected long timestamp;

    // TODO dev mocked string, uncomment and replace

    // @ManyToOne(cascade = {CascadeType.ALL})
    // @JoinColumn(name = "whoIns")
    // @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    // protected Utente whoIns;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected String whoIns;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataIns;

    // TODO dev mocked string, uncomment and replace

    // @ManyToOne(cascade = {CascadeType.ALL})
    // @JoinColumn(name = "whoUpd")
    // @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    // protected Utente whoUpd;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected String whoUpd;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataUpd;

    // TODO dev mocked string, uncomment and replac

    // @ManyToOne(cascade = {CascadeType.ALL})
    // @JoinColumn(name = "whoDel")
    // @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    // protected Utente whoDel;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    protected String whoDel;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataDel;

}
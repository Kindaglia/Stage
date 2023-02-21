package com.present.webdrawer.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.present.webdrawer.helpers.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Doc (File)
 */
@Entity
@Table(name = "doc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class Doc extends BaseEntity {

    // RELATIONSHIPS

    /**
     * Relationship with Carico entity
     */
    @ManyToOne
    @JoinColumn(name = "idCarico")
    private Carico idCarico;

    /**
     * Relationship with UtenteAzienda entity
     */
    @ManyToOne
    @JoinColumn(name = "idUtenteDest")
    private UtenteAzienda idUtenteDest;

    /**
     * Relationship with TipoDoc entity
     */
    @OneToOne
    @JoinColumn(name = "idTipoDoc")
    private TipoDoc idTipoDoc;

}

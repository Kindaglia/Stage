package com.present.webdrawer.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.present.webdrawer.helpers.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ProfiloPermessi
 */
@Entity
@Table(name = "profilo_permessi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class ProfiloPermessi extends BaseEntity {

    // RELATIONSHIPS

    /**
     * Relationship with UtenteAziendaProfilo entity
     */
    @ManyToOne
    @JoinColumn(name = "idProfilo")
    private Profilo idProfilo;

    @ManyToOne
    @JoinColumn(name = "idPermessi")
    private Permessi idPermessi;

}

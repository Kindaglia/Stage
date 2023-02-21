package com.present.webdrawer.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.present.webdrawer.helpers.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Azienda
 */
@Entity
@Table(name = "azienda")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class Azienda extends BaseEntity {

    @Column(length = 200)
    private String nome;

    @Column(length = 200)
    private String pIva;

    @Column(length = 200)
    private String ragSociale;

    @Column(length = 200)
    private String logo;

    // RELATIONSHIPS

    /**
     * Relationship with UtenteAzienda entity
     */
    @OneToMany(mappedBy = "idAzienda", fetch = FetchType.EAGER)
    private List<UtenteAzienda> utenteAzienda;

}

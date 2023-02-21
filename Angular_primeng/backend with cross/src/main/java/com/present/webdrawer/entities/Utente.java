package com.present.webdrawer.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.present.webdrawer.helpers.BaseEntity;
import com.present.webdrawer.helpers.TrackInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Utente
 */
@Entity
@Table(name = "utente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class Utente extends BaseEntity {

    @Column(length = 200)
    private String username;

    @Column(length = 200)
    private String nome;

    @Column(length = 200)
    private String cognome;

    @Column(length = 200)
    private String codiceFiscale;

    @Column(length = 200)
    private String pass;

    @OneToMany(mappedBy = "idUtente", fetch = FetchType.EAGER)
    private List<UtenteAzienda> utenteAzienda;

    /**
     * Relationships with TrackInfo
     */
    @OneToMany(mappedBy = "whoIns")
    private List<TrackInfo> listaUtentiIns;

    @OneToMany(mappedBy = "whoUpd")
    private List<TrackInfo> listaUtentiUpd;

    @OneToMany(mappedBy = "whoDel")
    private List<TrackInfo> listaUtentiDel;

}
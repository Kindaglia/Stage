package com.present.webdrawer.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.present.webdrawer.helpers.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * UtenteAzienda
 */
@Entity
@Table(name = "utente_azienda")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class UtenteAzienda extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "idUtente")
    private Utente idUtente;

    @ManyToOne
    @JoinColumn(name = "idAzienda")
    private Azienda idAzienda;

    /**
     * Relationship with UtenteAziendaProfilo entity
     */

    @OneToMany(mappedBy = "idUtenteAzienda")
    private List<UtenteAziendaProfilo> listaUtenteAziendaProfilo;

    /**
     * Relationship with Carico entity
     */

    @OneToMany(mappedBy = "idUploader")
    private List<Carico> listaCarichi;

    @OneToMany(mappedBy = "idUtenteDest")
    private List<Doc> listaDoc;

}
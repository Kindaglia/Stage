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
 * UtenteAziendaProfilo
 */
@Entity
@Table(name = "utente_azienda_profilo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class UtenteAziendaProfilo extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "idUtenteAzienda")
    private UtenteAzienda idUtenteAzienda;

    @ManyToOne
    @JoinColumn(name = "idProfilo")
    private Profilo idProfilo;

}

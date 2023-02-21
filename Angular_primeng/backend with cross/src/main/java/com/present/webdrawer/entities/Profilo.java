package com.present.webdrawer.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.present.webdrawer.helpers.NomeDescrizione;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Profilo
 */
@Entity
@Table(name = "profilo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class Profilo extends NomeDescrizione {

    // RELATIONSHIPS

    /**
     * Relationship with UtenteAziendaProfilo entity
     */
    @OneToMany(mappedBy = "idProfilo")
    private List<UtenteAziendaProfilo> listaUtenteAziendaProfilo;

    /**
     * Relationship with ProfiloPermessi entity
     */
    @OneToMany(mappedBy = "idProfilo")
    private List<ProfiloPermessi> listaProfiloPermessi;

}
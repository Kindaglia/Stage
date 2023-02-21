package com.present.webdrawer.entities;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * Permessi
 */

@Entity
@Table(name = "permessi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class Permessi extends BaseEntity {

    @Lob
    private Blob pem;

    // RELATIONSHIPS

    /**
     * Relationship with TipoDoc entity
     */
    @ManyToOne
    @JoinColumn(name = "idTipoDoc")
    private TipoDoc idTipoDoc;

    /**
     * Relationship with TipoCarico entity
     */
    @ManyToOne
    @JoinColumn(name = "idTipoCarico")
    private TipoCarico idTipoCarico;

    /**
     * Relationship with ProfiloPermessi entity
     */
    @OneToMany(mappedBy = "idPermessi")
    private List<ProfiloPermessi> listaIdProfiloPermessi;

}
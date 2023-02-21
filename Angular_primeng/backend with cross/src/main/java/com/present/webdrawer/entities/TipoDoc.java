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
 * TipoDoc
 */
@Entity
@Table(name = "tipo_doc")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class TipoDoc extends NomeDescrizione {

    // RELATIONSHIPS

    /**
     * Relationship with Doc entity
     */
    @OneToMany(mappedBy = "idTipoDoc")
    private List<Doc> listaDocs;

    /**
     * Relationship with Permessi entity
     */
    @OneToMany(mappedBy = "idTipoDoc")
    private List<Permessi> listaPermessi;

}

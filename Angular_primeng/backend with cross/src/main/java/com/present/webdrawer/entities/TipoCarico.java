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
 * TipoCarico
 */
@Entity
@Table(name = "tipo_carico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class TipoCarico extends NomeDescrizione {

     // RELATIONSHIPS

     /**
      * Relationship with Permessi entity
      */
     @OneToMany(mappedBy = "idTipoCarico")
     private List<Permessi> listaPermessi;

}

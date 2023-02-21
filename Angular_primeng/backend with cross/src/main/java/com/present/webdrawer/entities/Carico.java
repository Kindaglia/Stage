package com.present.webdrawer.entities;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
 * Carico
 */

@Entity
@Table(name = "carico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Audited
public class Carico extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "idTipoCarico")
    private TipoCarico idTipoCarico;

    @Column(length = 200)
    private String stato;

    @Column
    private Date start;

    @Column
    private Date end;

    @Column
    @Lob
    private Blob log;

    // RELATIONSHIPS

    /**
     * Relationship with UtenteAzienda entity
     */
    @ManyToOne
    @JoinColumn(name = "idUploader")
    private UtenteAzienda idUploader;

    /**
     * Relationship with Doc entity
     */
    @OneToMany(mappedBy = "idCarico")
    private List<Doc> listaDocs;

}

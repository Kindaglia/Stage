package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Doc {
    @Id //set id in primary key
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name="id_utente_dest")
    private Utente_azienda id_utente_dest;

    @ManyToOne
    @JoinColumn(name="idc")
    private Carico idc;

    @ManyToOne
    @JoinColumn(name="id_tipo_doc")
    private Tipo_doc id_tipo_doc;

    public Doc(Integer id, Carico idc, Tipo_doc id_tipo_doc) {
        this.id = id;
        this.idc = idc;
        this.id_tipo_doc = id_tipo_doc;
    }

    public Doc(Integer id, Utente_azienda id_utente_dest, Carico idc, Tipo_doc id_tipo_doc) {
        this.id = id;
        this.id_utente_dest = id_utente_dest;
        this.idc = idc;
        this.id_tipo_doc = id_tipo_doc;
    }

   
    

   




    
    
}

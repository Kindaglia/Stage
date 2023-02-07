package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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


    
}

package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utente_azienda {
    @Id //set id in primary key
    private Integer id;

    @ManyToOne
    @JoinColumn(name="idu")
    private Utente utente_idu;

    @ManyToOne
    @JoinColumn(name="ida")
    private Azienda azienda_ida;

    @OneToMany(mappedBy = "id_utente_dest",fetch = FetchType.EAGER)
    private Set<Doc> id_utente_dest;
    
    
}

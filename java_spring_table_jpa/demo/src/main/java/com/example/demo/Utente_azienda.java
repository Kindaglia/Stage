package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    
    


    public Utente getUtente_idu() {
        return utente_idu;
    }
    public void setUtente_idu(Utente utente_idu) {
        this.utente_idu = utente_idu;
    }
    public Azienda getUtente_ida() {
        return azienda_ida;
    }
    public void setUtente_ida(Utente utente_ida) {
        this.azienda_ida = azienda_ida;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    
}

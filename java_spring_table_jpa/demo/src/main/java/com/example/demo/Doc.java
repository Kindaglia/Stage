package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doc {
    @Id //set id in primary key
    private Integer id;
    private Integer id_utente_dest;
    private Integer id_tipo_doc;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_utente_dest() {
        return id_utente_dest;
    }
    public void setId_utente_dest(Integer id_utente_dest) {
        this.id_utente_dest = id_utente_dest;
    }
    public Integer getId_tipo_doc() {
        return id_tipo_doc;
    }
    public void setId_tipo_doc(Integer id_tipo_doc) {
        this.id_tipo_doc = id_tipo_doc;
    }
    
}

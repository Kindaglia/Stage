package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder.In;
import com.example.demo.Utente_azienda;

import antlr.collections.List;

@Entity
public class Utente {
    // campi che ci serviranno
    @Id //set id in primary key
    private Integer id;
    private String cf;
    private String cognome;
    private String nome;
    private String username;


    @OneToMany(mappedBy = "utente_idu",fetch = FetchType.EAGER)
    private Set<Utente_azienda> idu_fk;


    public Set<Utente_azienda> getIud_fk() {
        return idu_fk;
    }
    public void setIud_fk(Set<Utente_azienda> iud_fk) {
        this.idu_fk = iud_fk;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCf() {
        return cf;
    }
    public void setCf(String cf) {
        this.cf = cf;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    
}

package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Utente {
    // campi che ci serviranno
    @Id //set id in primary key
    private Integer id;
    private String cf;
    private String cognome;
    private String nome;
    private String username;


    @OneToMany(mappedBy = "idu",fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Set<Utente_azienda> idu;

    

    public Utente(Integer id, String cf, String cognome, String nome, String username) {
        this.id = id;
        this.cf = cf;
        this.cognome = cognome;
        this.nome = nome;
        this.username = username;
    }

    
}

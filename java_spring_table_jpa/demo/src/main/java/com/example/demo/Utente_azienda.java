package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
public class Utente_azienda {
    @Id //set id in primary key
    private Integer id;


    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="idu")
    private Utente idu;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="ida")
    private Azienda ida;

    @OneToMany(mappedBy = "id_utente_dest",fetch = FetchType.EAGER)
    private Set<Doc> id_utente_dest;

    public Utente_azienda(Integer id, Utente idu, Azienda ida) {
        this.id = id;
        this.idu = idu;
        this.ida = ida;
    }

    
    
    
    
    
}

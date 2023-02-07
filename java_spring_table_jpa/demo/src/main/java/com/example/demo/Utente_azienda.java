package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    @ManyToOne
    @JoinColumn(name="idu")
    private Utente utente_idu;

    @ManyToOne
    @JoinColumn(name="ida")
    private Azienda azienda_ida;

    @OneToMany(mappedBy = "id_utente_dest",fetch = FetchType.EAGER)
    private Set<Doc> id_utente_dest;

    public Utente_azienda(Integer id, Utente utente_idu, Azienda azienda_ida) {
        this.id = id;
        this.utente_idu = utente_idu;
        this.azienda_ida = azienda_ida;
    }

    
    
    
}

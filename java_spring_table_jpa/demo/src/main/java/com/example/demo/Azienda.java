package com.example.demo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
public class Azienda {
    @Id //set id in primary key
    private Integer id;
    private String logo;
    private String piva;


    @OneToMany(mappedBy = "ida",fetch = FetchType.EAGER)
    private Set<Utente_azienda> ida;

    //contructors
    public Azienda(Integer id, String logo, String piva) {
        this.id = id;
        this.logo = logo;
        this.piva = piva;
    }

}

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


    @OneToMany(mappedBy = "azienda_ida",fetch = FetchType.EAGER)
    private Set<Utente_azienda> ida_fk;

    //contructors
    public Azienda(Integer id, String logo, String piva) {
        this.id = id;
        this.logo = logo;
        this.piva = piva;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogo() {
        return logo;
    }
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public String getPiva() {
        return piva;
    }
    public void setPiva(String piva) {
        this.piva = piva;
    }
    public Set<Utente_azienda> getIda_fk() {
        return ida_fk;
    }
    public void setIda_fk(Set<Utente_azienda> ida_fk) {
        this.ida_fk = ida_fk;
    }
}

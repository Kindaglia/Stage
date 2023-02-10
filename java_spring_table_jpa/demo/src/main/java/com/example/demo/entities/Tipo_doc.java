package com.example.demo.entities;

import java.util.Set;

import javax.persistence.Column;
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
public class Tipo_doc {
    @Id
    private Integer id;
    private String descrizione;
    private String nome;

    @OneToMany(mappedBy = "id_tipo_doc",fetch = FetchType.EAGER)
    private Set<Doc> id_tipo_doc;

    public Tipo_doc(Integer id, String descrizione, String nome) {
        this.id = id;
        this.descrizione = descrizione;
        this.nome = nome;
    }




}

package com.present.webdrawer.helpers;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public abstract class NomeDescrizione extends BaseEntity {

    @Column(length = 200)
    private String nome;

    @Column(length = 200)
    private String descrizione;

}

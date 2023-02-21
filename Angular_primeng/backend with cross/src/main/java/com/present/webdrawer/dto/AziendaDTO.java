package com.present.webdrawer.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AziendaDTO {

    private Long Id;

    private String nome;

    private String pIva;

    private String ragSociale;

    private String logo;

}

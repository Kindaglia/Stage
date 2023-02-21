package com.present.webdrawer.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UtenteDTO {
    private String username;

    private String nome;

    private String cognome;

    private String codiceFiscale;

    private String pem;

}

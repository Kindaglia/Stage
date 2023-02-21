package com.present.webdrawer.services.interfaces;

public interface UtenteService<T,ID> extends ApiService<T,ID> {
    public abstract Object ricercaUtenteConNomeCognome(String filtro);
    
}

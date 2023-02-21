package com.present.webdrawer.services.interfaces;


public interface AziendaService<T,ID> extends ApiService<T,ID> {
    public abstract Object ricercaAziendaConRagSociale(String ragSociale);
}
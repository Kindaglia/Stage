package com.present.webdrawer.services.interfaces;

public interface ApiService<T, ID> {

    public abstract Object ricercaElemento(ID id);

    public abstract Object elencoElementi();

    public abstract <S extends T> Object inserisciElemento(T elemento);

    public abstract <S extends T> Object aggiornaElemento(T elemento);

    public abstract Boolean eliminaElemento(Long id);

    public void softDelete(Long id, T elemento);

    public abstract T merge(T source, T target);

}

package com.present.webdrawer.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.present.webdrawer.entities.Utente;
import com.present.webdrawer.repositories.UtenteRepository;
import com.present.webdrawer.services.interfaces.UtenteService;

@Service
public class UtenteServiceImpl<T, ID> implements UtenteService<T, ID> {

    @Autowired
    private UtenteRepository utenteRepository;

    public Iterable<Utente> ricercaUtenteConNomeCognome(String filtro) {
        Iterable<Utente> utenti = utenteRepository.findByNomeOrCognome(filtro);
        return utenti;
    }

    @Override
    public <S extends T> Utente inserisciElemento(T elemento) {
        return utenteRepository.save((Utente) elemento);
    }

    @Override
    public <S extends T> Utente aggiornaElemento(T elemento) {
        return utenteRepository.save((Utente) elemento);
    }

    @Override
    public Boolean eliminaElemento(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Utente ricercaElemento(ID id) {
        Optional<Utente> utente = utenteRepository.findById((Long) id);
        return utente.get();
    }

    @Override
    public Iterable<Utente> elencoElementi() {
        Iterable<Utente> utenti = utenteRepository.findAll();
        return utenti;
    }

    @Override
    public void softDelete(Long id, T elemento) {
        Utente utenteEliminato = (Utente) utenteRepository.softDelete(id, (Utente) elemento);
        utenteRepository.save(utenteEliminato);
    }


    public T merge(T source, T target) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(source, target);
        return target;
    }

}

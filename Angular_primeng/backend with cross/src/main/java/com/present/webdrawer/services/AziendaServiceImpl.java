package com.present.webdrawer.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.present.webdrawer.entities.Azienda;
import com.present.webdrawer.repositories.AziendaRepository;
import com.present.webdrawer.services.interfaces.AziendaService;

// TODO add extended class to include common methods like merge()
@Service
public class AziendaServiceImpl<T, ID> implements AziendaService<T, Long>{

    @Autowired
    private AziendaRepository aziendaRepository;

    @Override
    public Iterable<Azienda> ricercaAziendaConRagSociale(String ragSociale) {
        Iterable<Azienda> aziende;
        aziende = aziendaRepository.findByRagSocialeContaining(ragSociale);
        return aziende;
    }

    @Override
    public Azienda ricercaElemento(Long id) {
        Optional<Azienda> azienda = aziendaRepository.findById((Long) id);
        return azienda.get();
    }

    @Override
    public <S extends T> Azienda inserisciElemento(T elemento) {
        return aziendaRepository.save((Azienda) elemento);

    }

    @Override
    public <S extends T> Azienda aggiornaElemento(T elemento) {
        return aziendaRepository.save((Azienda) elemento);
    }

    @Override
    public Boolean eliminaElemento(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Azienda> elencoElementi() {
        Iterable<Azienda> aziende = aziendaRepository.findAll();
        return aziende;
    }

    @Override
    public void softDelete(Long id, T elemento) {
        Azienda aziendaEliminata = (Azienda) aziendaRepository.softDelete(id, (Azienda) elemento);
        aziendaRepository.save(aziendaEliminata);
    }

    @Override
    public T merge(T source, T target) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(source, target);
        return target;
    }

}

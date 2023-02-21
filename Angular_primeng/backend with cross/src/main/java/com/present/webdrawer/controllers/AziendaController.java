package com.present.webdrawer.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.present.webdrawer.dto.AziendaDTO;
import com.present.webdrawer.entities.Azienda;
import com.present.webdrawer.exceptions.NotFoundException;
import com.present.webdrawer.services.AziendaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/azienda")
@CrossOrigin(origins = {"http://localhost:4200"})
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "API Azienda", description = "Mock e Test per API dell'entità Azienda")
public class AziendaController {
    @Autowired
    private AziendaServiceImpl<Azienda, Long> aziendaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    @Operation(summary = "Acquisizione dei dati delle aziende", description = "Se chiamata senza ragSociale tira fuori tutte le aziende, diversamente filtra like %ragSociale%")
    public ResponseEntity<List<AziendaDTO>> getAzienda(
            @RequestParam(value = "ragSociale", required = false) Optional<String> ragSociale) {
        Iterable<Azienda> aziende;
        if (!ragSociale.isEmpty())
            aziende = aziendaService.ricercaAziendaConRagSociale(ragSociale.get());
        else
            aziende = aziendaService.elencoElementi();

        List<AziendaDTO> listaRes = new ArrayList<>();
        for (Azienda u : aziende) {
            listaRes.add(modelMapper.map(u, AziendaDTO.class));
        }
        return new ResponseEntity<>(listaRes, HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Inserimento di una nuova azienda", description = "Per la creazione con inserimento della nuova azienda su DB. Dopo aver avuto il successo ritorna la entity completa valorizzata con anche l'ID ")
    public ResponseEntity<AziendaDTO> postAzienda(@RequestBody AziendaDTO azienda) {

        Azienda nuovaAzienda = modelMapper.map(azienda, Azienda.class);

        nuovaAzienda = (Azienda) aziendaService.inserisciElemento(nuovaAzienda);
        return new ResponseEntity<>(modelMapper.map(nuovaAzienda, AziendaDTO.class), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aggiornamento dei dati di un'azienda esistente ", description = "Per le modifica dell'oggetto con ID espresso da path parameter")
    public ResponseEntity<AziendaDTO> putAzienda(@PathVariable("id") @NotNull @DecimalMin("0") Long id,
            @RequestBody AziendaDTO aggiornamentiAzienda) throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        // TODO: improve code here with springboot best practices
        Azienda aziendaToUpdate = null;

        try {
            aziendaToUpdate = aziendaService.ricercaElemento(id);
            aziendaToUpdate = aziendaService.merge(modelMapper.map(aggiornamentiAzienda, Azienda.class),
                    aziendaToUpdate);
            aziendaToUpdate = aziendaService.aggiornaElemento(aziendaToUpdate);
        } catch (NoSuchElementException e) {
            throw new NotFoundException(
                    "Azienda not found, id: " + Long.toString(id));
        }

        return new ResponseEntity<>(modelMapper.map(aziendaToUpdate, AziendaDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Rimozione di un'azienda", description = "Per la cancellazione dell'oggetto con ID espresso da path parameter")
    public ResponseEntity<AziendaDTO> delAzienda(@PathVariable("id") @NotNull @DecimalMin("0") Long id) {
        Azienda azienda = null;

        try {
            azienda = aziendaService.ricercaElemento(id);
            if (!azienda.getDeleted()) {
                aziendaService.softDelete(id, azienda);
            }
        } catch (NoSuchElementException e) {
            throw new NotFoundException(
                    "Azienda not found, id: " + Long.toString(id));
        }

        // TODO error handling guardando al numero di record aggiornati
        return new ResponseEntity<>(modelMapper.map(azienda, AziendaDTO.class), HttpStatus.OK);

    }
}

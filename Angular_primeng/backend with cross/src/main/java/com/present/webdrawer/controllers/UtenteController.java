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

import com.present.webdrawer.dto.UtenteDTO;
import com.present.webdrawer.entities.Utente;
import com.present.webdrawer.exceptions.NotFoundException;
import com.present.webdrawer.services.UtenteServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/utente")
@CrossOrigin(origins = {"http://localhost:4200"})
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "API Utente", description = "Mock e Test per API dell'entità Utente")
public class UtenteController {

    @Autowired
    private UtenteServiceImpl<Utente, Long> utenteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    @Operation(summary = "Acquisizione dei dati degli utenti", description = "Se chiamata senza ragSociale tira fuori tutte le aziende, diversamente filtra nome+cognome like %filtro% ")
    public ResponseEntity<List<UtenteDTO>> getUtente(
            @RequestParam(value = "filtro", required = false) Optional<String> filtro) {
        Iterable<Utente> utenti;

        if (!filtro.isEmpty())
            utenti = utenteService.ricercaUtenteConNomeCognome(filtro.get());
        else
            utenti = utenteService.elencoElementi();

        List<UtenteDTO> listaRes = new ArrayList<>();
        for (Utente u : utenti) {
            listaRes.add(modelMapper.map(u, UtenteDTO.class));
        }
        return new ResponseEntity<>(listaRes, HttpStatus.OK);
    }

    @PostMapping()
    @Operation(summary = "Inserimento di un nuovo utente", description = "Per la creazione con inserimento di un nuovo utente su DB. Dopo aver avuto il successo ritorna la entity completa valorizzata con anche l'ID ")
    public ResponseEntity<UtenteDTO> postUtente(@RequestBody UtenteDTO utente) {
        Utente nuovoUtente = modelMapper.map(utente, Utente.class);
        return new ResponseEntity<>(modelMapper.map(utenteService.inserisciElemento(nuovoUtente), UtenteDTO.class),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aggiornamento dei dati di un utente esistente ", description = "Per le modifica dell'oggetto con ID espresso da path parameter")
    public ResponseEntity<UtenteDTO> putUtente(@PathVariable("id") @NotNull @DecimalMin("0") Long id,
            @RequestBody UtenteDTO aggiornamentiUtente) throws ClassNotFoundException, NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        // TODO: improve code here with springboot best practices

        Utente utenteToUpdate = null;

        try {
            utenteToUpdate = utenteService.ricercaElemento(id);
            utenteToUpdate = utenteService.merge(modelMapper.map(aggiornamentiUtente, Utente.class),
                    utenteToUpdate);
            utenteToUpdate = utenteService.aggiornaElemento(utenteToUpdate);
        } catch (NoSuchElementException e) {
            throw new NotFoundException(
                    "Utente not found, id: " + Long.toString(id));
        }

        return new ResponseEntity<>(modelMapper.map(utenteToUpdate, UtenteDTO.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Rimozione di un utente", description = "Per la cancellazione dell'oggetto con ID espresso da path parameter")
    public ResponseEntity<UtenteDTO> delUtente(@PathVariable("id") @NotNull @DecimalMin("0") Long id) {
        Utente utente = null;

        try {
            utente = utenteService.ricercaElemento(id);
            if (!utente.getDeleted()) {
                utenteService.softDelete(id, utente);
            }
        } catch (NoSuchElementException e) {
            throw new NotFoundException(
                    "Utente not found, id: " + Long.toString(id));
        }

        // TODO error handling guardando al numero di record aggiornati
        return new ResponseEntity<>(modelMapper.map(utente, UtenteDTO.class), HttpStatus.OK);
    }
}

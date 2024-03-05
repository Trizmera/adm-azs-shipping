package com.example.application;

import com.example.domain.model.Pacote;
import com.example.domain.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacotes")
public class PacoteController {
    @Autowired
    private PacoteService pacoteService;

    public PacoteController(PacoteService pacoteService) {
        this.pacoteService = pacoteService;
    }

    @GetMapping
    public ResponseEntity<Page<Pacote>> getAllPacotes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Pacote> pacotes = pacoteService.getAllPacotes(pageRequest);

        return new ResponseEntity<>(pacotes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pacote> getPacoteById(@PathVariable Long id) {
        Pacote pacote = pacoteService.getPacoteById(id);
        return new ResponseEntity<>(pacote, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pacote> createPacote(@RequestBody Pacote pacote) {
        Pacote createdPacote = pacoteService.createPacote(pacote);
        return new ResponseEntity<>(createdPacote, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pacote> updatePacote(@PathVariable Long id, @RequestBody Pacote pacote) {
        Pacote updatedPacote = pacoteService.updatePacote(id, pacote);
        return new ResponseEntity<>(updatedPacote, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacote(@PathVariable Long id) {
        pacoteService.deletePacote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

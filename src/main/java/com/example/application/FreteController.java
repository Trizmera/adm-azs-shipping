package com.example.application;

import com.example.domain.model.Frete;
import com.example.domain.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fretes")
public class FreteController {

    private final FreteService freteService;

    @Autowired
    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @GetMapping
    public ResponseEntity<Page<Frete>> getAllFretes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Frete> fretes = freteService.getAllFretes(pageRequest);
        return new ResponseEntity<>(fretes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frete> getFreteById(@PathVariable Long id) {
        Frete frete = freteService.getFreteById(id);
        return new ResponseEntity<>(frete, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Frete> createFrete(@RequestBody Frete frete) {
        Frete createdFrete = freteService.createFrete(frete);
        return new ResponseEntity<>(createdFrete, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Frete> updateFrete(@PathVariable Long id, @RequestBody Frete frete) {
        Frete updatedFrete = freteService.updateFrete(id, frete);
        return new ResponseEntity<>(updatedFrete, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrete(@PathVariable Long id) {
        freteService.deleteFrete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

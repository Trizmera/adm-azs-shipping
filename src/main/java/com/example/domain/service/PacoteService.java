package com.example.domain.service;

import com.example.domain.model.Pacote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacoteService {
    List<Pacote> getAllPacotes();
    Pacote getPacoteById(Long id);
    Pacote createPacote(Pacote pacote);
    Pacote updatePacote(Long id, Pacote pacote);
    void deletePacote(Long id);
}

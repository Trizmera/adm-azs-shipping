package com.example.domain.port;

import com.example.domain.model.Pacote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PacoteRepositoryPort {
    List<Pacote> findAll();
    Page<Pacote> findAll(Pageable pageable);
    Optional<Pacote> findById(Long id);
    Pacote save(Pacote pacote);
    void deleteById(Long id);
}

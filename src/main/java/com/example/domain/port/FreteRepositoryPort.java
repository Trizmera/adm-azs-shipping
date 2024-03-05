package com.example.domain.port;

import com.example.domain.model.Frete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FreteRepositoryPort {
    List<Frete> findAll();
    Page<Frete> findAll(Pageable pageable);
    Optional<Frete> findById(Long id);
    Frete save(Frete frete);
    void deleteById(Long id);
}

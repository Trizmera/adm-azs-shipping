package com.example.infrastructure;

import com.example.domain.model.Pacote;
import com.example.domain.port.PacoteRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PacoteRepositoryImpl implements PacoteRepositoryPort {
    private final PacoteRepositoryPort pacoteRepository;

    public PacoteRepositoryImpl(PacoteRepositoryPort pacoteRepository) {
        this.pacoteRepository = pacoteRepository;
    }

    @Override
    public List<Pacote> findAll() {
        return pacoteRepository.findAll();
    }

    @Override
    public Page<Pacote> findAll(Pageable pageable) {
        return pacoteRepository.findAll(pageable);
    }

    @Override
    public Optional<Pacote> findById(Long id) {
        return pacoteRepository.findById(id);
    }

    @Override
    public Pacote save(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    @Override
    public void deleteById(Long id) {
        pacoteRepository.deleteById(id);
    }
}

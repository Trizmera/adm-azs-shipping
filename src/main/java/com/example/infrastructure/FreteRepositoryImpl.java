package com.example.infrastructure;

import com.example.domain.model.Frete;
import com.example.domain.port.FreteRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FreteRepositoryImpl implements FreteRepositoryPort {
    private final FreteRepositoryPort freteRepository;

    public FreteRepositoryImpl(FreteRepositoryPort freteRepository) {
        this.freteRepository = freteRepository;
    }

    @Override
    public List<Frete> findAll() {
        return freteRepository.findAll();
    }

    @Override
    public Page<Frete> findAll(Pageable pageable) {
        return freteRepository.findAll(pageable);
    }

    @Override
    public Optional<Frete> findById(Long id) {
        return freteRepository.findById(id);
    }

    @Override
    public Frete save(Frete frete) {
        return freteRepository.save(frete);
    }

    @Override
    public void deleteById(Long id) {
        freteRepository.deleteById(id);
    }
}

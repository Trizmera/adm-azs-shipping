package com.example.domain.service;

import com.example.domain.model.Frete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FreteService {
    List<Frete> getAllFretes();
    Page<Frete> getAllFretes(Pageable pageable);
    Frete getFreteById(Long id);
    Frete createFrete(Frete frete);
    Frete updateFrete(Long id, Frete frete);
    void deleteFrete(Long id);
}

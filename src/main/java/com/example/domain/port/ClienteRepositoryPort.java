package com.example.domain.port;

import com.example.domain.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {
    List<Cliente> findAll();
    Page<Cliente> findAll(Pageable pageable);
    Optional<Cliente> findById(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);

    interface ClienteRepository extends JpaRepository<Cliente, Long> {

    }
}

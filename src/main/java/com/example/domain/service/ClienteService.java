package com.example.domain.service;

import com.example.domain.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClienteService {

    List<Cliente> getAllClientes();
    Page<Cliente> getAllClientes(Pageable pageable);
    Cliente getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
}

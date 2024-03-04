package com.example.domain.service;

import com.example.domain.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClienteService {

    List<Cliente> getAllClientes();
    Cliente getClienteById(Long id);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long id, Cliente cliente);
    void deleteCliente(Long id);
}

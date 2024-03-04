package com.example;

import com.example.application.ClienteController;
import com.example.domain.model.Cliente;
import com.example.domain.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllClientes() {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1L, "Joao Souza", "123 Rua", "123-456-7890"));
        clientes.add(new Cliente(2L, "Maria Silva", "456 Avenida", "987-654-3210"));


        when(clienteService.getAllClientes()).thenReturn(clientes);


        ResponseEntity<List<Cliente>> responseEntity = clienteController.getAllClientes();


        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());


        List<Cliente> returnedClientes = responseEntity.getBody();
        assertEquals(clientes.size(), returnedClientes.size());
        assertEquals(clientes.get(0).getId(), returnedClientes.get(0).getId());
        assertEquals(clientes.get(0).getNome(), returnedClientes.get(0).getNome());
        assertEquals(clientes.get(0).getEndereco(), returnedClientes.get(0).getEndereco());
        assertEquals(clientes.get(0).getTelefone(), returnedClientes.get(0).getTelefone());
    }

    @Test
    public void testUpdateCliente() {

        Long id = 1L;
        Cliente clienteToUpdate = new Cliente(id, "John Doe", "Address 1", "123456789");
        when(clienteService.updateCliente(eq(id), any(Cliente.class))).thenReturn(clienteToUpdate);


        Cliente updatedCliente = clienteController.updateCliente(id, clienteToUpdate);


        assertEquals(clienteToUpdate, updatedCliente);
    }

    @Test
    public void testDeleteCliente() {

        Long id = 1L;


        clienteController.deleteCliente(id);

        verify(clienteService).deleteCliente(id);
    }
}


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
        // Mock data
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1L, "John Doe", "123 Street", "123-456-7890"));
        clientes.add(new Cliente(2L, "Jane Doe", "456 Avenue", "987-654-3210"));

        // Mock service method to return mock data
        when(clienteService.getAllClientes()).thenReturn(clientes);

        // Call controller method
        ResponseEntity<List<Cliente>> responseEntity = clienteController.getAllClientes();

        // Verify response status
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verify returned data
        List<Cliente> returnedClientes = responseEntity.getBody();
        assertEquals(clientes.size(), returnedClientes.size());
        assertEquals(clientes.get(0).getId(), returnedClientes.get(0).getId());
        assertEquals(clientes.get(0).getNome(), returnedClientes.get(0).getNome());
        assertEquals(clientes.get(0).getEndereco(), returnedClientes.get(0).getEndereco());
        assertEquals(clientes.get(0).getTelefone(), returnedClientes.get(0).getTelefone());
    }

    @Test
    public void testUpdateCliente() {
        // Mocking data
        Long id = 1L;
        Cliente clienteToUpdate = new Cliente(id, "John Doe", "Address 1", "123456789");
        when(clienteService.updateCliente(eq(id), any(Cliente.class))).thenReturn(clienteToUpdate);

        // Call the method under test
        Cliente updatedCliente = clienteController.updateCliente(id, clienteToUpdate);

        // Verify the response
        assertEquals(clienteToUpdate, updatedCliente);
    }

    @Test
    public void testDeleteCliente() {
        // Mocking data
        Long id = 1L;

        // Call the method under test
        clienteController.deleteCliente(id);

        // Verify that deleteCliente method of clienteService is called with the correct parameter
        verify(clienteService).deleteCliente(id);
    }
}


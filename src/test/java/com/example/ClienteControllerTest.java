package com.example;

import com.example.application.ClienteController;
import com.example.domain.model.Cliente;
import com.example.domain.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {
    private ClienteService clienteService = mock(ClienteService.class);
    private ClienteController clienteController = new ClienteController(clienteService);

    @Test
    public void testGetAllClientes() {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1L, "Joao Souza", "123 Rua", "1234567890"));
        clientes.add(new Cliente(2L, "Maria Silva", "456 Avenida", "9876543210"));

        Page<Cliente> pageClientes = new PageImpl<>(clientes);

        when(clienteService.getAllClientes(PageRequest.of(0, 10))).thenReturn(pageClientes);

        ResponseEntity<Page<Cliente>> responseEntity = clienteController.getAllClientes(0, 10);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Page<Cliente> returnedPageClientes = responseEntity.getBody();
        assertEquals(clientes.size(), returnedPageClientes.getContent().size());

        Cliente firstReturnedCliente = returnedPageClientes.getContent().get(0);
        assertEquals(clientes.get(0).getId(), firstReturnedCliente.getId());
        assertEquals(clientes.get(0).getNome(), firstReturnedCliente.getNome());
        assertEquals(clientes.get(0).getEndereco(), firstReturnedCliente.getEndereco());
        assertEquals(clientes.get(0).getTelefone(), firstReturnedCliente.getTelefone());
    }

    @Test
    public void testUpdateCliente() {

        Long id = 1L;
        Cliente clienteToUpdate = new Cliente(id, "Jorge Santos", "Avenida 1", "123456789");
        when(clienteService.updateCliente(eq(id), any(Cliente.class))).thenReturn(clienteToUpdate);


        Cliente updatedCliente = clienteController.updateCliente(id, clienteToUpdate).getBody();


        assertEquals(clienteToUpdate, updatedCliente);
    }

    @Test
    public void testDeleteCliente() {

        Long id = 1L;


        clienteController.deleteCliente(id);

        verify(clienteService).deleteCliente(id);
    }
}


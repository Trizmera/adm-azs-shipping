package com.example;

import com.example.application.FreteController;
import com.example.domain.model.Cliente;
import com.example.domain.model.Frete;
import com.example.domain.model.Pacote;
import com.example.domain.service.FreteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class FreteControllerTest {

    @Mock
    private FreteService freteService;

    @InjectMocks
    private FreteController freteController;

    @Test
    public void testGetAllFretes() {
        List<Frete> fretes = new ArrayList<>();
        fretes.add(new Frete(1L, new Cliente(), new Pacote(), "Frete Um", 50.0, 100.0));
        fretes.add(new Frete(2L, new Cliente(), new Pacote(), "Frete Dois", 70.0, 150.0));
        Page<Frete> page = new PageImpl<>(fretes);

        when(freteService.getAllFretes(any(PageRequest.class))).thenReturn(page);

        ResponseEntity<Page<Frete>> responseEntity = freteController.getAllFretes(0, 10);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
    }

    @Test
    public void testGetFreteById() {
        Long id = 1L;
        Frete frete = new Frete(id, null, null, "Frete para produto Um", 50.0, 100.0);

        when(freteService.getFreteById(id)).thenReturn(frete);

        ResponseEntity<Frete> responseEntity = freteController.getFreteById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(frete, responseEntity.getBody());
    }

    @Test
    public void testCreateFrete() {
        Cliente cliente = new Cliente();
        Pacote pacote = new Pacote();
        Frete frete = new Frete(1L, cliente, pacote, "Frete para produto Dois", 50.0, 100.0);

        when(freteService.createFrete(any(Frete.class))).thenReturn(frete);

        ResponseEntity<Frete> responseEntity = freteController.createFrete(frete);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(frete, responseEntity.getBody());
    }

    @Test
    public void testUpdateFrete() {
        Long id = 1L;
        Frete frete = new Frete(id, null, null, "Frete Atualizado", 60.0, 110.0);

        when(freteService.updateFrete(id, frete)).thenReturn(frete);

        ResponseEntity<Frete> responseEntity = freteController.updateFrete(id, frete);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(frete, responseEntity.getBody());
    }

    @Test
    public void testDeleteFrete() {
        Long id = 1L;

        ResponseEntity<Void> responseEntity = freteController.deleteFrete(id);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(freteService, times(1)).deleteFrete(id);
    }
}

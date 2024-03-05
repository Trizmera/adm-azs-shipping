package com.example;

import com.example.application.PacoteController;
import com.example.domain.model.Pacote;
import com.example.domain.service.PacoteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class PacoteControllerTest {

    @Mock
    private PacoteService pacoteService;

    @InjectMocks
    private PacoteController pacoteController;

    @Test
    public void testGetAllPacotes() {
        List<Pacote> pacotes = new ArrayList<>();
        pacotes.add(new Pacote(1L, "PackFragil", 25.0, 12.0, 8.0, 3.0));
        pacotes.add(new Pacote(2L, "Papeis", 2.0, 2.0, 2.0, 2.0));
        Page<Pacote> page = new PageImpl<>(pacotes);

        when(pacoteService.getAllPacotes(any(Pageable.class))).thenReturn(page);

        ResponseEntity<Page<Pacote>> responseEntity = pacoteController.getAllPacotes(0, 10);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(page, responseEntity.getBody());
    }

    @Test
    public void testGetPacoteById() {
        Long id = 1L;
        Pacote pacote = new Pacote(id, "Pacote 1", 19.0, 10.0, 23.0, 10.0);

        when(pacoteService.getPacoteById(id)).thenReturn(pacote);

        ResponseEntity<Pacote> responseEntity = pacoteController.getPacoteById(id);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(pacote, responseEntity.getBody());
    }

    @Test
    public void testDeletePacote() {
        Long id = 1L;

        pacoteController.deletePacote(id);

        verify(pacoteService).deletePacote(id);
    }

}

package com.example;

import com.example.domain.model.Frete;
import com.example.domain.model.Pacote;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FreteTest {

    @Test
    public void testCalculaReco() {
        Pacote pacote = new Pacote();
        pacote.setPeso(10.0);
        pacote.setComprimento(5.0);
        pacote.setLargura(3.0);
        pacote.setAltura(2.0);

        Frete frete = new Frete();
        frete.setPacote(pacote);
        frete.setDistancia(100.0);

        frete.calculaPreco();

        assertEquals(0.5 + 0.1 * pacote.getPeso() + 0.05 * frete.getDistancia(), frete.getPreco());
    }
}

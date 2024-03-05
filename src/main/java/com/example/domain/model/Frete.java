package com.example.domain.model;

import jakarta.persistence.*;

@Entity
public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clienteId", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "pacoteId", referencedColumnName = "id")
    private Pacote pacote;
    private String descricao;
    private double preco;
    private double distancia;


    public Frete(Long id, Cliente cliente, Pacote pacote, String descricao, double preco, double distancia) {
        this.id = id;
        this.cliente = cliente;
        this.pacote = pacote;
        this.descricao = descricao;
        this.preco = preco;
        this.distancia = distancia;

    }

    public Frete() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void calculaPreco() {
        this.preco = 0.5 + 0.1 * pacote.getPeso() + 0.05 * distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double kms) {
        this.distancia = distancia;
    }
}

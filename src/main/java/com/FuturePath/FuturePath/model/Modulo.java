package com.FuturePath.FuturePath.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @Positive
    private int capitulo;// Episódio na sequência (1,2,3)
    @NotBlank
    private String tipo;         // video, leitura, quiz
    @ManyToOne
    @JsonBackReference
    private Trilha trilha;

    //construtor
    public Modulo(String titulo, String descricao, int capitulo, String tipo, Trilha trilha) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.capitulo = capitulo;
        this.tipo = tipo;
        this.trilha = trilha;
    }

    //construtor default
    public Modulo() {
    }

    //getters e setters
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCapitulo() {
        return capitulo;
    }
    public void setCapitulo(int capitulo) {
        this.capitulo = capitulo;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Trilha getTrilha() {
        return trilha;
    }
    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }
}

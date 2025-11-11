package com.FuturePath.FuturePath.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Trilha trilha;
    private LocalDate dataInscricao = LocalDate.now();
    private String status;   // INSCRITO, EM_PROGRESSO, CONCLUIDO, CANCELADO
    private Integer progresso = 0; // porcentagem (0-100)

    //construtor
    public Inscricao(Usuario user, Trilha trilha, LocalDate dataInscricao, String status, Integer progresso) {
        this.usuario = user;
        this.trilha = trilha;
        this.dataInscricao = dataInscricao;
        this.status = status;
        this.progresso = progresso;
    }

    //getters e setters
    public Long getId() {
        return id;
    }
    public Usuario getUser() {
        return usuario;
    }
    public void setUser(Usuario user) {
        this.usuario = user;
    }
    public Trilha getTrilha() {
        return trilha;
    }
    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }
    public LocalDate getDataInscricao() {
        return dataInscricao;
    }
    public void setDataInscricao(LocalDate dataInscricao) {
        this.dataInscricao = dataInscricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getProgresso() {
        return progresso;
    }
    public void setProgresso(Integer progresso) {
        this.progresso = progresso;
    }
}

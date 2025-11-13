package com.FuturePath.FuturePath.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne
    private Usuario usuario;
    @NotNull
    @ManyToOne
    private Trilha trilha;
    private LocalDate dataInscricao = LocalDate.now();
    @Pattern(
            regexp = "INSCRITO|EM_PROGRESSO|CONCLUIDO|CANCELADO",
            message = "Status deve ser INSCRITO, EM_PROGRESSO, CONCLUIDO ou CANCELADO"
    )
    private String status;   // INSCRITO, EM_PROGRESSO, CONCLUIDO, CANCELADO
    @PositiveOrZero
    private Integer progresso = 0; // porcentagem (0-100)

    //construtor default
    public Inscricao() {
    }

    //construtor
    public Inscricao(Usuario usuario, Trilha trilha, LocalDate dataInscricao, String status, Integer progresso) {
        this.usuario = usuario;
        this.trilha = trilha;
        this.dataInscricao = dataInscricao;
        this.status = status;
        this.progresso = progresso;
    }

    //getters e setters
    public Long getId() {
        return id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

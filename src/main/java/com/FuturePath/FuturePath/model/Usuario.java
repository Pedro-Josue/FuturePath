package com.FuturePath.FuturePath.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;
    @NotBlank
    private String ocupacaoAtual;

    //construtor
    public Usuario(String login, String senha, String ocupacaoAtual) {
        this.login = login;
        this.senha = senha;
        this.ocupacaoAtual = ocupacaoAtual;
    }

    //getters e setters
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getOcupacaoAtual() {
        return ocupacaoAtual;
    }
    public void setOcupacaoAtual(String ocupacaoAtual) {
        this.ocupacaoAtual = ocupacaoAtual;
    }
}

package com.FuturePath.FuturePath.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Trilha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotBlank
    private String area;
    @NotNull
    private Integer cargaHoraria;
    @OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL)
    private List<Modulo> modulos;

    //construtor
    public Trilha(String titulo, String descricao, String area, Integer cargaHoraria, List<Modulo> modulos) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.area = area;
        this.cargaHoraria = cargaHoraria;
        this.modulos = modulos;
    }

    //construtor default
    public Trilha() {
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
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public Integer getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public List<Modulo> getModulos() {
        return modulos;
    }
    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
}

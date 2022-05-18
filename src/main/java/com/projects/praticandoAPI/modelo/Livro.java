package com.projects.praticandoAPI.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer custo;
    private Boolean animacaoRealidadeAumentada;

    public Livro() {
    }

    public Livro(String nome, Integer custo, Boolean animacaoRealidadeAumentada) {
        this.nome = nome;
        this.custo = custo;
        this.animacaoRealidadeAumentada = animacaoRealidadeAumentada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    public Boolean getAnimacaoRealidadeAumentada() {
        return animacaoRealidadeAumentada;
    }

    public void setAnimacaoRealidadeAumentada(Boolean animacaoRealidadeAumentada) {
        this.animacaoRealidadeAumentada = animacaoRealidadeAumentada;
    }

}

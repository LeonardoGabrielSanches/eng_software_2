package com.projects.praticandoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.Livro;

public class LivroDto {
    private Long id;
    private String nome;
    private Integer custo;
    private Boolean animacaoRealidadeAumentada;

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.custo = livro.getCusto();
        this.animacaoRealidadeAumentada = livro.getAnimacaoRealidadeAumentada();
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

    public static List<LivroDto> converter(List<Livro> livros) {
        return livros.stream().map(LivroDto::new).collect(Collectors.toList());
    }
}

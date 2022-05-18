package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Livro;
import com.projects.praticandoAPI.repository.LivroRepository;

public class LivroForm {
    private String nome;
    private Integer custo;
    private Boolean animacaoRealidadeAumentada;

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

    public Livro converter(LivroRepository livroRepository) {

        return new Livro(nome, custo, animacaoRealidadeAumentada);
    }
}

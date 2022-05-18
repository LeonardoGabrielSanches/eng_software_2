package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.TipoPlano;
import com.projects.praticandoAPI.modelo.Usuario;
import com.projects.praticandoAPI.repository.UsuarioRepository;

public class UsuarioForm {

	private String nome;
	private String email;
	private String senha;
	private TipoPlano tipoPlano;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public Usuario converter(UsuarioRepository usuarioRepository) {

		return new Usuario(nome, email, senha, tipoPlano);
	}
}

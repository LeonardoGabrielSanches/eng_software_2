package com.projects.praticandoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.TipoPlano;
import com.projects.praticandoAPI.modelo.Usuario;

public class UsuarioDto {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Integer moedas;
	private TipoPlano tipoPlano;
	private Boolean direitoAGamificacaoEDesafios;

	public UsuarioDto(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.tipoPlano = usuario.getTipoPlano();
		this.moedas = usuario.getMoedas();
		this.direitoAGamificacaoEDesafios = TipoPlano.VIP == usuario.getTipoPlano();
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

	public Integer getMoedas() {
		return moedas;
	}

	public void setMoedas(Integer moedas) {
		this.moedas = moedas;
	}

	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public Boolean getDireitoAGamificacaoEDesafios() {
		return direitoAGamificacaoEDesafios;
	}

	public void setDireitoAGamificacaoEDesafios(Boolean direitoAGamificacaoEDesafios) {
		this.direitoAGamificacaoEDesafios = direitoAGamificacaoEDesafios;
	}

	public static List<UsuarioDto> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}

}

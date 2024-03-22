package br.ufal.aracomp.jdbc.model;

import java.util.List;

public class Cliente {
	private String login;
	private String nome;
	private List<Locacao> locacoes;

	public Cliente(String login, String nome) {
		super();
		this.login = login;
		this.nome = nome;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
package br.ufal.aracomp.jdbc.model;

import java.util.List;

public class Filme {
	private int codigo;
	private String nome;
	private List<Unidade> unidades;

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Filme(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

}

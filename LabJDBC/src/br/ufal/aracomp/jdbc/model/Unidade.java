package br.ufal.aracomp.jdbc.model;

import java.util.List;

public class Unidade {
	private int codigo;
	private double preco;
	private List<Locacao> locacoes;
	private List<Idioma> idiomas;
	private List<Idioma> legendas;
	private Filme filme;
	
	

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public List<Idioma> getLegendas() {
		return legendas;
	}

	public void setLegendas(List<Idioma> legendas) {
		this.legendas = legendas;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Unidade(int codigo, double preco) {
		this.codigo = codigo;
		this.preco = preco;
	}

}

package br.ufal.aracomp.jdbc.model;



public class Idioma {
	private int codigo;
	private String nome;


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

	public Idioma(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

}

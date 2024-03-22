package br.ufal.aracomp.jdbc.model;

import java.util.Date;

public class Locacao {
	private Date data_locacao;
	private Date data_devolucao;
	private Cliente cliente;
	private Unidade unidade;
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Date getData_locacao() {
		return data_locacao;
	}

	public void setData_locacao(Date data_locacao) {
		this.data_locacao = data_locacao;
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public Locacao(Date data_locacao, Date data_devolucao) {
		super();
		this.data_locacao = data_locacao;
		this.data_devolucao = data_devolucao;
	}

}

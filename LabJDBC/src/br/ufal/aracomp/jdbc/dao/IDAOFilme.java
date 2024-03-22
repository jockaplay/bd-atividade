package br.ufal.aracomp.jdbc.dao;

import java.util.List;

import br.ufal.aracomp.jdbc.model.Filme;

public interface IDAOFilme {
	public void adicionar(Filme Filme);
	public void remover(int Codigo);
	public void alterar(int CodigoAntigo, Filme dadosNovos);
	/**
	 * Instancia um Filme a partir do BD
	 * @param Codigo - Codigo do Filme a ser recuperado do BD
	 * @return - a instancia do Filme desejado ou NULL, caso nao haja Filme com o Codigo informado
	 */
	public Filme consultar(int Codigo);
	public List<Filme> consultarPorNome(String parteNome);
	public List<Filme> obterTodosFilmes();
}

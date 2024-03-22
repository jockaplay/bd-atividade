package br.ufal.aracomp.jdbc.dao;

import java.util.List;

import br.ufal.aracomp.jdbc.model.Cliente;

public interface IDAOCliente {
	public void adicionar(Cliente cliente);
	public void remover(String login);
	public void alterar(String loginAntigo, Cliente dadosNovos);
	/**
	 * Instancia um cliente a partir do BD
	 * @param login - login do cliente a ser recuperado do BD
	 * @return - a instancia do cliente desejado ou NULL, caso nao haja cliente com o login informado
	 */
	public Cliente consultar(String login);
	public List<Cliente> consultarPorNome(String parteNome);
	public List<Cliente> obterTodosClientes();
}

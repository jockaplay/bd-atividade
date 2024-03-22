package br.ufal.aracomp.jdbc.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ufal.aracomp.jdbc.dataSource.IDataSource;
import br.ufal.aracomp.jdbc.model.Cliente;

public class DAOCliente implements IDAOCliente {
	private IDataSource dataSource;

	public DAOCliente(IDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void adicionar(Cliente cliente) {
		Cliente cTeste = this.consultar(cliente.getLogin());
		if(cTeste == null) {
			String sql = "INSERT INTO Cliente(login, nome) VALUES('"+cliente.getLogin()+"','"+cliente.getNome()+"')";
			try {
			dataSource.executarQueryGeral(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.err.println("LOGIN JA EXISTENTE!");
		}
	}

	@Override
	public void remover(String login) {
		String sql = "DELETE FROM Cliente WHERE login ='" + login +"'";
		try {
		dataSource.executarQueryGeral(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void alterar(String loginAntigo, Cliente dadosNovos) {
		Cliente cTeste = this.consultar(dadosNovos.getLogin());
		if(cTeste == null) {
			String sql = "update cliente set nome = '"+dadosNovos.getNome()+"', set login = '"+dadosNovos.getLogin()+"' where login = '"+loginAntigo+"'";
			try {
			dataSource.executarQueryGeral(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.err.println("ERRO NA ALTERACAO! LOGIN NOVO JA EXISTE!");
		}
	}

	@Override
	public Cliente consultar(String login) {
		String sql = "SELECT nome FROM cliente WHERE login = '" + login + "'";
		try {
			ResultSet rs = this.dataSource.executarSelect(sql);
			if(rs.next()) {
				return new Cliente(login, rs.getString("nome"));
			}
		} catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}
  
	@Override
	public List<Cliente> consultarPorNome(String parteNome) {
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "select * from cliente where nome like '%" + parteNome + "%'";
		
		try {
			ResultSet rs = this.dataSource.executarSelect(sql);
		
			while(rs.next()) {
				clientes.add(new Cliente(rs.getString("login"), rs.getString("nome")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

	@Override
	public List<Cliente> obterTodosClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		String sql = "select * from cliente";
		
		try {
			ResultSet rs = this.dataSource.executarSelect(sql);
		
			while(rs.next()) {
				Cliente c = new Cliente(rs.getString("login"), rs.getString("nome"));
				clientes.add(c);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

}

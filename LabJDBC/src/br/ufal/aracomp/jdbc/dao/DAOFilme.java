package br.ufal.aracomp.jdbc.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.ufal.aracomp.jdbc.dataSource.IDataSource;
import br.ufal.aracomp.jdbc.model.Filme;

public class DAOFilme implements IDAOFilme {
	private IDataSource dataSource;

	public DAOFilme(IDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void adicionar(Filme Filme) {
		Filme cTeste = this.consultar(Filme.getCodigo());
		if(cTeste == null) {
			String sql = "INSERT INTO Filme(codigo, nome) VALUES('"+Filme.getCodigo()+"','"+Filme.getNome()+"')";
			try {
			dataSource.executarQueryGeral(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.err.println("CODIGO JA EXISTENTE!");
		}
	}

	@Override
	public void remover(int Codigo) {
		String sql = "DELETE FROM Filme WHERE Codigo ='" + Codigo +"'";
		try {
		dataSource.executarQueryGeral(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void alterar(int CodigoAntigo, Filme dadosNovos) {
		Filme cTeste = this.consultar(dadosNovos.getCodigo());
		if(cTeste == null) {
			String sql = "update Filme set nome = '"+dadosNovos.getNome()+"', set codigo = '"+dadosNovos.getCodigo()+"' where codigo = '"+CodigoAntigo+"'";
			try {
			dataSource.executarQueryGeral(sql);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.err.println("ERRO NA ALTERACAO! CODIGO NOVO JA EXISTE!");
		}
	}

	@Override
	public Filme consultar(int Codigo) {
		String sql = "SELECT nome FROM Filme WHERE Codigo = '" + Codigo + "'";
		try {
			ResultSet rs = this.dataSource.executarSelect(sql);
			if(rs.next()) {
				return new Filme(Codigo, rs.getString("nome"));
			}
		} catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}
  
	@Override
	public List<Filme> consultarPorNome(String parteNome) {
		ArrayList<Filme> Filmes = new ArrayList<>();
		String sql = "select * from Filme where nome like '%" + parteNome + "%'";
		
		try {
			ResultSet rs = this.dataSource.executarSelect(sql);
		
			while(rs.next()) {
				Filmes.add(new Filme(rs.getInt("codigo"), rs.getString("nome")));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Filmes;
	}

	@Override
	public List<Filme> obterTodosFilmes() {
		ArrayList<Filme> Filmes = new ArrayList<>();
		String sql = "select * from Filme";
		
		try {
			ResultSet rs = this.dataSource.executarSelect(sql);
		
			while(rs.next()) {
				Filme c = new Filme(rs.getInt("codigo"), rs.getString("nome"));
				Filmes.add(c);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return Filmes;
	}

}

package br.ufal.aracomp.jdbc.businessObject;

import java.util.List;

import br.ufal.aracomp.jdbc.dao.DAOFilme;
import br.ufal.aracomp.jdbc.dataSource.HSQLDataSource;
import br.ufal.aracomp.jdbc.model.Filme;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		HSQLDataSource hsql = new HSQLDataSource();
		DAOFilme f1 = new DAOFilme(hsql);
		List<Filme> filmes = f1.obterTodosFilmes();
		for (int i = 0; i < filmes.size(); i++){
			System.out.println(filmes.get(i).getNome());
		}
	}
}

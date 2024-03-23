package br.ufal.aracomp.jdbc.businessObject;

import java.util.List;

import br.ufal.aracomp.jdbc.dao.DAOFilme;
import br.ufal.aracomp.jdbc.dataSource.HSQLDataSource;
import br.ufal.aracomp.jdbc.model.Filme;

public class Principal {

	static String linha = "===========================================================";
	
	public static void main(String[] args) throws Exception {
		System.out.println(linha + "\nTODOS OS FILMES");
		HSQLDataSource hsql = new HSQLDataSource();
		DAOFilme f1 = new DAOFilme(hsql);
		showFilmes(f1);


		System.out.println(linha + "\nADICIONAR STAR WAR");
		Filme novoFilme =  new Filme(5151, "Star Wars III");
		f1.adicionar(novoFilme);
		showFilmes(f1);


		System.out.println(linha + "\nALTERAR STAR WAR");
		Filme outroFilme =  new Filme(5150, "Star Wars IV");
		f1.alterar(5151, outroFilme);
		showFilmes(f1);
		
		
		System.out.println(linha + "\nBUSCAR POR NOME\n"+linha);
		List<Filme> filme1 = f1.consultarPorNome("im");
		for (int i = 0; i < filme1.size(); i++){
			System.out.println(filme1.get(i).getNome());
		}


		System.out.println(linha + "\nBUSCAR POR CODIGO");
		Filme filme2 = f1.consultar(5150);
		System.out.println(linha + "\nCódigo de " + filme2.getNome() + ": " + filme2.getCodigo());


		System.out.println(linha + "\nREMOVER STAR WAR");
		f1.remover(5150);
		showFilmes(f1);
	}

	public static void showFilmes (DAOFilme lista) {
		System.out.println(linha);
		List<Filme> filmes = lista.obterTodosFilmes();
		for (int i = 0; i < filmes.size(); i++){
			System.out.println(filmes.get(i).getNome());
		}
	}
}

package br.ufal.aracomp.jdbc.dataSource;

import java.sql.ResultSet;

public interface IDataSource {
	public ResultSet executarSelect(String sql) throws Exception;
	public int executarQueryGeral(String sql) throws Exception;
	public void abrirConexao() throws Exception;
	public void fecharConexao() throws Exception;
}

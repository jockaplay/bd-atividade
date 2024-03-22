package br.ufal.aracomp.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {
	
	public static void main(String[] args) {
		String user = "SA";
		String url = "jdbc:hsqldb:../bd/locadora";
		String driverUrl = "org.hsqldb.jdbcDriver";
		
		Connection sgbdConn = null;
		Statement sqlInterpreter = null;
		try {
			Class.forName(driverUrl);
			sgbdConn = DriverManager.getConnection(url, user, "");
			sqlInterpreter = sgbdConn.createStatement();
			String sql = "SELECT DISTINCT c.nome as client, f.nome as movie FROM cliente c JOIN locar l ON c.login = l.login_clientefk" +
						" JOIN unidade u ON u.codigo = l.codigo_unidadefk JOIN filme f ON f.codigo = u.codigo_filmefk";
			ResultSet resultado = sqlInterpreter.executeQuery(sql);
			System.out.println("NOME DOS CLIENTES E FILME QUE ESSES ALUGARAM (SEM REPETIÇÕES):");
			while(resultado.next()) {
				System.out.println(resultado.getString("client") + " ---- " + resultado.getString("movie"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(sqlInterpreter != null)
					sqlInterpreter.close();
				if(sgbdConn != null)
					sgbdConn.close();
				}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

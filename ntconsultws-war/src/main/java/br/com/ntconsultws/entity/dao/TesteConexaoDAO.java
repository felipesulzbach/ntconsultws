package br.com.ntconsultws.entity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.ntconsultws.bean.TesteConexaoBean;

public abstract class TesteConexaoDAO {

	private static Connection conn = null;
	// private String connectionUrl =
	// "jdbc:postgresql://localhost:5432;databaseName=AdventureWorks;user=postgres;password=amin";

	public static void main(String[] args) {
		testarConexaoPostgreSQL();
		// testarConexaoOracle();
	}

	private static void testarConexaoPostgreSQL() {
		abrirConexao(TesteConexaoBean.create().withDriver("org.postgresql.Driver")
				.withUrl("jdbc:postgresql://localhost:5432/ntconsultwsdb").withUser("postgres").withSenha("admin"));
		fecharConexao();
	}

	private static void testarConexaoOracle() {
		abrirConexao(TesteConexaoBean.create().withDriver("oracle.jdbc.OracleDriver")
				.withUrl("jdbc:oracle:thin:@localhost:1521:ntconsultwsdb").withUser("admin").withSenha("admin"));
		fecharConexao();
	}

	public static Connection abrirConexao(final TesteConexaoBean bean) {
		try {
			Class.forName(bean.getDriver());
			conn = DriverManager.getConnection(bean.getUrl(), bean.getUser(), bean.getSenha());
			System.out.println("Conexão OK!");
		} catch (ClassNotFoundException ex) {
			System.out.println("Problemas no Driver de Conexão: " + ex);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}

	public static void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
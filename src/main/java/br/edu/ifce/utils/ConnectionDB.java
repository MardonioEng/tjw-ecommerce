package br.edu.ifce.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifce.utils.exceptions.DBException;

public class ConnectionDB {
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/ecommercetjw?useTimezone=true&serverTimezone=UTC";
	private final static String USUARIO = "admin";
	private final static String SENHA = "admin";

	private static Connection conn = null;

	/*
	 * Estabelece uma conexão com o BD
	 */
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USUARIO, SENHA);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	/*
	 * Fecha a conexão com o BD
	 */
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	/*
	 * Fecha um Statement
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

	/*
	 * Fecha um ResultSet
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DBException(e.getMessage());
			}
		}
	}

}
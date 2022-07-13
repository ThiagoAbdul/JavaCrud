package br.com.formulario.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = eConnection.PASSWORD.getValue();
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/formulario";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conn;
	}

}

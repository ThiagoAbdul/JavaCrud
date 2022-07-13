package br.com.formulario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DAO {
	protected Connection conn;
	protected PreparedStatement pstm;
	
	public DAO() {
		conn = null;
		pstm = null;
	}
	
	protected void prepareStatement(String SQL) throws ClassNotFoundException, SQLException {
		startConnection();
		pstm = conn.prepareStatement(SQL);
	}
	
	protected void startConnection() throws ClassNotFoundException, SQLException {
		conn = ConnectionDAO.getConnection();
	}

	protected void safeCloseConnection() {
		try {
			if (conn != null){
				conn.close();
			}
			if (pstm != null) {
				pstm.close();
			}	
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão " + e.getMessage());;
		}
	}

}

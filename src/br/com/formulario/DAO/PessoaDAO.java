package br.com.formulario.DAO;

import java.sql.Date;
import java.text.SimpleDateFormat;

import br.com.formulario.DTO.Pessoa;

public class PessoaDAO extends DAO{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	
	public void save(Pessoa pessoa) {
		String SQL = "INSERT INTO pessoa(cpf, nome, sexo, data_nascimento) VALUES(?, ?, ?, ?)";
		try {
			prepareStatement(SQL);
			pstm.setString(1, pessoa.getCpf());
			pstm.setString(2, pessoa.getNome());
			pstm.setString(3, Character.toString(pessoa.getSexo()));
			pstm.setString(4, sdf.format(pessoa.getDataNascimento()));
			pstm.execute();
		}
		catch (Exception e) {
			System.out.println("Erro ao salvar os dados da pessoa " + e.getMessage());
		}
		finally {
			safeCloseConnection();
		}
	}
	
}

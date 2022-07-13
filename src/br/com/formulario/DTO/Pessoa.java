package br.com.formulario.DTO;

import java.util.Date;

public class Pessoa {
	private int idPessoa;
	private String cpf;
	private String nome;
	private char sexo;
	private Date dataNascimento;
	
	public Pessoa() {}
	
	public Pessoa(String cpf, String nome, char sexo, Date dataNascimento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	
}

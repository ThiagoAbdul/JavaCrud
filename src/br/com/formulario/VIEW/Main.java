package br.com.formulario.VIEW;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;

import br.com.formulario.DAO.PessoaDAO;
import br.com.formulario.DTO.Pessoa;

public class Main extends JFrame{
	
	public static void main(String [] args) throws ParseException {
		PessoaDAO pdao = new PessoaDAO();
		Pessoa jorge = new Pessoa("48154912857", "Jorge Amado", 'M', new Date());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		// pdao.save(jorge);
		String teste = "@";
		String teste2 = "thia fdd pdflwe";
		System.out.println(sdf.parse("01/09/2000"));
		
	}
	
	
	
	
}

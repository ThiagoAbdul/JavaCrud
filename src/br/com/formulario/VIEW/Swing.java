package br.com.formulario.VIEW;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.com.formulario.DAO.PessoaDAO;
import br.com.formulario.DTO.Pessoa;


public class Swing {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtSexo;
	private JTextField txtDataNascimento;
	private JLabel lblAlert;
	SimpleDateFormat sdf;
	private JLabel lblCpf;
	private JTextField txtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(28, 20, 202, 15);
		frame.getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(28, 35, 202, 19);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(28, 65, 202, 15);
		frame.getContentPane().add(lblCpf);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(28, 80, 202, 19);
		frame.getContentPane().add(txtCPF);
		txtCPF.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(28, 110, 202, 15);
		frame.getContentPane().add(lblSexo);

		txtSexo = new JTextField();
		txtSexo.setBounds(28, 125, 202, 19);
		frame.getContentPane().add(txtSexo);
		txtSexo.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(28, 155, 202, 15);
		frame.getContentPane().add(lblDataDeNascimento);

		txtDataNascimento = new JTextField();
		txtDataNascimento.setBounds(28, 170, 202, 19);
		frame.getContentPane().add(txtDataNascimento);
		txtDataNascimento.setColumns(10);


		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputNome = txtNome.getText();
				String inputCpf = txtCPF.getText();
				String inputSexo = txtSexo.getText();
				String inputDataNascimento = txtDataNascimento.getText();

				if (Validation.haveOnlyLetters(inputNome) && 
					Validation.isCPF(inputCpf) &&
					Validation.haveOneChar(inputSexo) && 
					Validation.isDate(inputDataNascimento)) {
						String nome = inputNome.toLowerCase();
						String cpf = inputCpf;
						char sexo = inputSexo.charAt(0);
						Date dataNascimento;
						sdf = new SimpleDateFormat("dd/MM/yyyy");
						try {
							dataNascimento = sdf.parse(inputDataNascimento);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							alertError("Formatação de nome inválida");
							return;
						}
						Pessoa pessoa = new Pessoa(cpf, nome, sexo, dataNascimento);
						PessoaDAO dao = new PessoaDAO();
						dao.save(pessoa);
				}
				else {
					alertError("Formatação de nome inválida");
				}




			}
		});
		btnSalvar.setBounds(28, 195, 117, 25);
		frame.getContentPane().add(btnSalvar);

		lblAlert = new JLabel("");
		lblAlert.setBounds(28, 225, 250, 15);
		frame.getContentPane().add(lblAlert);
		
		
	}

	public void alertError(String text) {
		lblAlert.setText(text);
	}


}

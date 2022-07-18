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
import static br.com.formulario.validations.Validation.*;

import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;


public class Swing {

	private JFrame frame;
	private JTextField txtNome;
	private JRadioButton btnMale;
	private JRadioButton btnFemale;
	private JTextField txtDataNascimento;
	private JLabel lblAlert;
	SimpleDateFormat sdf;
	private JLabel lblCpf;
	private JTextField txtCPF;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		btnMale = new JRadioButton("M", false);
		buttonGroup.add(btnMale);
		btnMale.setBounds(28, 125, 50, 19);
		frame.getContentPane().add(btnMale);
		
		btnFemale = new JRadioButton("F", false);
		buttonGroup.add(btnFemale);
		btnFemale.setBounds(78, 125, 50, 19);;
		frame.getContentPane().add(btnFemale);

		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(28, 155, 202, 15);
		frame.getContentPane().add(lblDataDeNascimento);

		txtDataNascimento = new JTextField("0/0/0000");
		txtDataNascimento.setBounds(28, 170, 202, 19);
		frame.getContentPane().add(txtDataNascimento);
		txtDataNascimento.setColumns(10);


		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputNome = txtNome.getText();
				String inputCpf = txtCPF.getText();
				String inputSexo = getValueSelected();
				String inputDataNascimento = txtDataNascimento.getText();
				if (haveOnlyLetters(inputNome) && 
					isCPF(inputCpf) &&
					isFiled(inputSexo) &&
					isDate(inputDataNascimento)) {
						String nome = inputNome.toLowerCase();
						String cpf = inputCpf;
						char sexo = inputSexo.charAt(0);
						Date dataNascimento;
						sdf = new SimpleDateFormat("dd/MM/yyyy");
						try {
							dataNascimento = sdf.parse(inputDataNascimento);
						} catch (ParseException ex) {
							ex.printStackTrace();
							alert("Formatação de data inválida");
							return;
						}
						Pessoa pessoa = new Pessoa(cpf, nome, sexo, dataNascimento);
						PessoaDAO dao = new PessoaDAO();
						dao.save(pessoa);
						alert("Enviado com sucesso!");
				}
				else {
					alert("Erro no preenchimento dos dados");
				}
			}
		});
		btnSalvar.setBounds(28, 195, 117, 25);
		frame.getContentPane().add(btnSalvar);

		lblAlert = new JLabel("");
		lblAlert.setBounds(28, 225, 250, 15);
		frame.getContentPane().add(lblAlert);
		
		
		
		
	}

	public void alert(String text) {
		lblAlert.setText(text);
	}
	public String getValueSelected() {
		if (btnMale.isSelected()) {
			return btnMale.getText();
		}
		else if (btnFemale.isSelected()){
			return btnFemale.getText();
		}
		return "";
	}
	
}

package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Cliente;
import dao.ClienteDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		
		setExtendedState(MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Index index = new Index();
				index.setVisible(true);
			}
		});
		btnNewButton.setBounds(1240, 630, 120, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblCadastroClientes = new JLabel("Cadastro Clientes");
		lblCadastroClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroClientes.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCadastroClientes.setBounds(550, 20, 270, 52);
		contentPane.add(lblCadastroClientes);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(631, 133, 102, 25);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(631, 160, 102, 30);
		contentPane.add(textField);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				Cliente c = new Cliente(nome);
				ClienteDAO cDAO = new ClienteDAO();
				int inseriu = cDAO.inserir(c);
				if (inseriu > 0) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(631, 232, 102, 30);
		contentPane.add(btnNewButton_1);
	}
}

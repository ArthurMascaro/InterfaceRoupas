package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Calca;
import bean.Camiseta;
import bean.Roupa;
import bean.Vestido;
import dao.CalcaDAO;
import dao.CamisetaDAO;
import dao.RoupaDAO;
import dao.VestidoDAO;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
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
		
		JLabel lblNewLabel = new JLabel("Cadastro Produtos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(545, 31, 280, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(634, 133, 102, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(634, 333, 102, 25);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(634, 360, 102, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel calcaLabel = new JLabel("Numero");
		calcaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		calcaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		calcaLabel.setBounds(634, 433, 102, 25);
		contentPane.add(calcaLabel);
		
		JLabel camisetaLabel = new JLabel("Tamanho");
		camisetaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		camisetaLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		camisetaLabel.setBounds(634, 433, 102, 25);
		contentPane.add(camisetaLabel);
		
		String s2[] = { "36", "38", "40", "42", "44", "46" };
		JComboBox calcaComboBox = new JComboBox(s2);
		calcaComboBox.setBounds(634, 460, 102, 22);
		contentPane.add(calcaComboBox);
		
		String s3[] = {"P", "M", "G"};
		JComboBox camisetaComboBox = new JComboBox(s3);
		camisetaComboBox.setBounds(634, 460, 102, 22);
		contentPane.add(camisetaComboBox);
		
		JLabel vestidoLabel = new JLabel("Estampa");
		vestidoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vestidoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		vestidoLabel.setBounds(634, 433, 102, 25);
		contentPane.add(vestidoLabel);
		
		String s4[] = {"lisa", "listrada", "florida"};
		JComboBox vestidoComboBox = new JComboBox(s4);
		vestidoComboBox.setBounds(634, 460, 102, 22);
		contentPane.add(vestidoComboBox);
		
		String s1[] = { "Calça", "Vestido", "Camiseta" };
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedIndex() == 0) {
					camisetaComboBox.setVisible(false);
					camisetaLabel.setVisible(false);
					vestidoComboBox.setVisible(false);
					vestidoLabel.setVisible(false);
					
					calcaComboBox.setVisible(true);
					calcaLabel.setVisible(true);
				} else if (comboBox.getSelectedIndex() == 1) {
					calcaComboBox.setVisible(false);
					calcaLabel.setVisible(false);
					camisetaComboBox.setVisible(false);
					camisetaLabel.setVisible(false);
					
					vestidoComboBox.setVisible(true);
					vestidoLabel.setVisible(true);
				} else {
					vestidoComboBox.setVisible(false);
					vestidoLabel.setVisible(false);
					calcaComboBox.setVisible(false);
					calcaLabel.setVisible(false);
					
					camisetaComboBox.setVisible(true);
					camisetaLabel.setVisible(true);
				}
				
			}
		});
		comboBox.setBounds(634, 160, 102, 40);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(textField_1.getText());
				double preco = Double.parseDouble(textField.getText());
				Roupa r = new Roupa(codigo, preco);
				RoupaDAO rDAO = new RoupaDAO();
				int inseriuR = rDAO.inserir(r);
				if (inseriuR > 0) {
					if (comboBox.getSelectedIndex() == 0) {
						int numero = Integer.parseInt((String) calcaComboBox.getSelectedItem());
						Calca c = new Calca(r.getCodigo(), r.getPreco(), numero);
						CalcaDAO cDAO = new CalcaDAO();
						int inseriu = cDAO.inserir(c);
						if (inseriu > 0) {
							JOptionPane.showMessageDialog(null, "Calça cadastrada com Sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
						}
					} else if (comboBox.getSelectedIndex() == 1) {
						String estampa = ((String) vestidoComboBox.getSelectedItem());
						Vestido v = new Vestido(r.getCodigo(), r.getPreco(), estampa);
						VestidoDAO vDAO = new VestidoDAO();
						int inseriu = vDAO.inserir(v);
						if (inseriu > 0) {
							JOptionPane.showMessageDialog(null, "Vestido cadastrado com Sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
						}
					} else {
						String t = (String) camisetaComboBox.getSelectedItem();
						char tamanho = t.charAt(0);
						Camiseta c = new Camiseta (r.getCodigo(), r.getPreco(), tamanho);
						CamisetaDAO cDAO = new CamisetaDAO();
						int inseriu = cDAO.inserir(c);
						if (inseriu > 0) {
							JOptionPane.showMessageDialog(null, "Camiseta cadastrada com Sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(634, 533, 102, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Codigo");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(634, 233, 102, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(634, 260, 102, 30);
		contentPane.add(textField_1);
		
		vestidoComboBox.setVisible(false);
		vestidoLabel.setVisible(false);
		camisetaComboBox.setVisible(false);
		camisetaLabel.setVisible(false);
		calcaLabel.setVisible(false);
		calcaComboBox.setVisible(false);
	}
}

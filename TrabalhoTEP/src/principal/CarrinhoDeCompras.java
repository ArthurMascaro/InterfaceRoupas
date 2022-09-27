package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Calca;
import bean.Camiseta;
import bean.Vestido;
import dao.CalcaDAO;
import dao.CamisetaDAO;
import dao.ClienteDAO;
import dao.CompraDAO;
import dao.VestidoDAO;

public class CarrinhoDeCompras extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_2_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrinhoDeCompras frame = new CarrinhoDeCompras();
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
	public CarrinhoDeCompras() {
		
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
		
		JLabel lblProdutosCadastrados = new JLabel("Carrinho de Compras");
		lblProdutosCadastrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutosCadastrados.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProdutosCadastrados.setBounds(519, 45, 331, 40);
		contentPane.add(lblProdutosCadastrados);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Pre\u00E7o", "Tamanho"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Pre\u00E7o", "Estampa"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Pre\u00E7o", "Tamanho"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Double.class, Short.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 200, 600, 400);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codigo", "pre\u00E7o", "numero"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Double.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(385, 200, 600, 400);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codigo", "pre\u00E7o", "estampa"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(385, 200, 600, 400);
		contentPane.add(scrollPane_2);
		
		table_2_1 = new JTable();
		table_2_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codigo", "pre\u00E7o", "tamanho"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Codigo Roupa");
		lblNewLabel_1_2.setBounds(585, 630, 152, 14);
		contentPane.add(lblNewLabel_1_2);
		
		ClienteDAO cDAO = new ClienteDAO();
		ArrayList<String >nomes = cDAO.getListaNome();
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(385, 642, 152, 30);
		if (nomes != null) {
			for (String n : nomes) {
				comboBox_1.addItem(n);
			}
		}
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cliente");
		lblNewLabel_1_1_1_1.setBounds(385, 630, 152, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(585, 642, 152, 30);
		contentPane.add(comboBox_1_1);
		
		ArrayList<String> RoupaCodigos = new ArrayList();
		
		String s1[] = {"Calça", "Vestido", "Camiseta"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RoupaCodigos.clear();
				
				if (comboBox.getSelectedIndex() == 0) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					((DefaultTableModel)table.getModel()).setRowCount(0);
					CalcaDAO cDAO = new CalcaDAO();
					ArrayList<Calca> calcas = cDAO.GetLista();
					((DefaultTableModel)table.getModel()).setRowCount(0);
					for (Calca c : calcas) {
						model.addRow(new Object[] {c.getCodigo(), c.getPreco(), c.getNumero()});
						RoupaCodigos.add(Integer.toString(c.getCodigo()));
					}
					scrollPane_1.setVisible(false);
					scrollPane_2.setVisible(false);
					scrollPane.setVisible(true);
				} else if (comboBox.getSelectedIndex() == 1) {
					DefaultTableModel model = (DefaultTableModel)table_1.getModel();
					((DefaultTableModel)table_1.getModel()).setRowCount(0);
					VestidoDAO vDAO = new VestidoDAO();
					ArrayList<Vestido> vestidos = vDAO.GetLista();
					for (Vestido v : vestidos) {
						model.addRow(new Object[] {v.getCodigo(), v.getPreco(), v.getEstampa()});
						RoupaCodigos.add(Integer.toString(v.getCodigo()));
					}
					
					scrollPane_1.setVisible(true);
					scrollPane_2.setVisible(false);
					scrollPane.setVisible(false);
				} else {
					DefaultTableModel model = (DefaultTableModel)table_2_1.getModel();
					((DefaultTableModel)table_2_1.getModel()).setRowCount(0);
					CamisetaDAO cDAO = new CamisetaDAO();
					ArrayList<Camiseta> camisetas = cDAO.GetLista();
					for (Camiseta c : camisetas) {
						model.addRow(new Object[] {c.getCodigo(), c.getPreco(), c.getTamanho()});
						RoupaCodigos.add(Integer.toString(c.getCodigo()));
					}
					scrollPane_1.setVisible(false);
					scrollPane_2.setVisible(true);
					scrollPane.setVisible(false);
				}
				
				comboBox_1_1.removeAllItems();
				if (RoupaCodigos != null) {
					for (String c : RoupaCodigos) {
						comboBox_1_1.addItem(c);
					}
				}
			}
		});
		comboBox.setBounds(609, 121, 152, 30);
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeCliente = comboBox_1.getSelectedItem().toString(); 
				String codigoRoupaString = comboBox_1_1.getSelectedItem().toString();
				int codigoRoupa = Integer.parseInt(codigoRoupaString);
				CompraDAO cDAO = new CompraDAO();
				int inseriu = cDAO.inserir(nomeCliente, codigoRoupa);
				if (inseriu > 0) {
					JOptionPane.showMessageDialog(null, "Compra cadastrada com Sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
				}
			}
		});
		btnNewButton_1.setBounds(840, 642, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

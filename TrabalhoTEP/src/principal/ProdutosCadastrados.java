package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Calca;
import bean.Camiseta;
import bean.Vestido;
import dao.CalcaDAO;
import dao.CamisetaDAO;
import dao.VestidoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class ProdutosCadastrados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosCadastrados frame = new ProdutosCadastrados();
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
	public ProdutosCadastrados() {
		
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
		
		JLabel lblProdutosCadastrados = new JLabel("Produtos Cadastrados");
		lblProdutosCadastrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutosCadastrados.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProdutosCadastrados.setBounds(519, 45, 331, 40);
		contentPane.add(lblProdutosCadastrados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(335, 200, 700, 500);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Pre\u00E7o", "Numero"
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
		scrollPane_1.setBounds(335, 200, 700, 500);
		contentPane.add(scrollPane_1);
		
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
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(335, 200, 700, 500);
		contentPane.add(scrollPane_2);
		
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
		scrollPane_2.setViewportView(table_2);
		
		scrollPane.setVisible(false);
		scrollPane_1.setVisible(false);
		scrollPane_2.setVisible(false);
		
		String s1[] = {"Calça", "Vestido", "Camiseta"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (comboBox.getSelectedIndex() == 0) {
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					((DefaultTableModel)table.getModel()).setRowCount(0);
					CalcaDAO cDAO = new CalcaDAO();
					ArrayList<Calca> calcas = cDAO.GetLista();
					((DefaultTableModel)table.getModel()).setRowCount(0);
					for (Calca c : calcas) {
						model.addRow(new Object[] {c.getCodigo(), c.getPreco(), c.getNumero()});
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
					}
					scrollPane_1.setVisible(true);
					scrollPane_2.setVisible(false);
					scrollPane.setVisible(false);
				} else {
					DefaultTableModel model = (DefaultTableModel)table_2.getModel();
					((DefaultTableModel)table_2.getModel()).setRowCount(0);
					CamisetaDAO cDAO = new CamisetaDAO();
					ArrayList<Camiseta> camisetas = cDAO.GetLista();
					for (Camiseta c : camisetas) {
						model.addRow(new Object[] {c.getCodigo(), c.getPreco(), c.getTamanho()});
					}
					scrollPane_1.setVisible(false);
					scrollPane_2.setVisible(true);
					scrollPane.setVisible(false);
				}
			}
		});
		comboBox.setBounds(625, 121, 120, 30);
		contentPane.add(comboBox);
	}
	
}

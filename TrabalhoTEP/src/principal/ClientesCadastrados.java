package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.Calca;
import bean.Cliente;
import dao.CalcaDAO;
import dao.ClienteDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClientesCadastrados extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientesCadastrados frame = new ClientesCadastrados();
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
	public ClientesCadastrados() {
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(335, 110, 700, 600);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblProdutosCadastrados = new JLabel("Produtos Cadastrados");
		lblProdutosCadastrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutosCadastrados.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProdutosCadastrados.setBounds(519, 45, 331, 40);
		contentPane.add(lblProdutosCadastrados);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		((DefaultTableModel)table.getModel()).setRowCount(0);
		ClienteDAO cDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = cDAO.getLista();
		for (Cliente c : clientes) {
			model.addRow(new Object[] {c.getNome()});
		}
		
	}
}

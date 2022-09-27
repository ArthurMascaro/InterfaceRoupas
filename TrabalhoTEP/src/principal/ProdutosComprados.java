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

import dao.CompraDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import bean.Compra;

public class ProdutosComprados extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosComprados frame = new ProdutosComprados();
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
	public ProdutosComprados() {
		
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
		
		JLabel lblProdutoscomprados = new JLabel("Produtos Comprados");
		lblProdutoscomprados.setHorizontalAlignment(SwingConstants.CENTER);
		lblProdutoscomprados.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblProdutoscomprados.setBounds(519, 45, 331, 40);
		contentPane.add(lblProdutoscomprados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(335, 110, 700, 500);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cliente", "CodigoRoupa", "Tipo", "Pre\u00E7o", "Data", "Horario"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, Double.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		((DefaultTableModel)table.getModel()).setRowCount(0);
		CompraDAO cDAO = new CompraDAO();
		ArrayList<Compra> compras = cDAO.Listar();
		ArrayList<String> tipos = new ArrayList<>();
		ArrayList<Double> precos = new ArrayList<>();
		Pair<ArrayList<String>, ArrayList<Double>> resultado = cDAO.Tipos(compras);
		tipos = resultado.left;
		precos = resultado.right;
		for (int i=0; i < compras.size(); i++) {
			model.addRow(new Object[] {compras.get(i).getNomeCliente(), compras.get(i).getCodigoRoupa(), tipos.get(i), precos.get(i), compras.get(i).getData(), compras.get(i).getHorario()});
		}
	}

}

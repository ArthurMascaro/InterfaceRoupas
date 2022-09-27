package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
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
	public Index() {
		
		setExtendedState(MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seja bem-vindo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(564, 20, 242, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar Produto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastroProduto cadastroProduto = new CadastroProduto();
				cadastroProduto.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(564, 120, 242, 57);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CadastroCliente cadastroCliente = new CadastroCliente();
				cadastroCliente.setVisible(true);
			}
		});
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCadastrarCliente.setBounds(564, 220, 242, 57);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnListagemCadastros = new JButton("Cliente Cadastrados");
		btnListagemCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ClientesCadastrados clientesCadastrados = new ClientesCadastrados();
				clientesCadastrados.setVisible(true);
			}
		});
		btnListagemCadastros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnListagemCadastros.setBounds(564, 320, 242, 57);
		contentPane.add(btnListagemCadastros);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinho de Compras");
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
				carrinhoDeCompras.setVisible(true);
			}
		});
		btnCarrinhoDeCompras.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCarrinhoDeCompras.setBounds(564, 520, 242, 57);
		contentPane.add(btnCarrinhoDeCompras);
		
		JButton btnProdutosCadastrados = new JButton("Produtos Cadastrados");
		btnProdutosCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProdutosCadastrados produtosCadastrados = new ProdutosCadastrados();
				produtosCadastrados.setVisible(true);
			}
		});
		btnProdutosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnProdutosCadastrados.setBounds(564, 420, 242, 57);
		contentPane.add(btnProdutosCadastrados);
		
		JButton btnProdutosComprados = new JButton("Produtos Comprados");
		btnProdutosComprados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ProdutosComprados produtosComprados = new ProdutosComprados();
				produtosComprados.setVisible(true);
			}
		});
		btnProdutosComprados.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnProdutosComprados.setBounds(564, 620, 242, 57);
		contentPane.add(btnProdutosComprados);
	}
}

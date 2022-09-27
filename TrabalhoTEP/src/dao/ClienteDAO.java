package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Calca;
import bean.Cliente;
import bean.Roupa;
import bean.Vestido;

public class ClienteDAO {
		
		private Connection connection;
		
		public ClienteDAO() {
			connection = new FabricaConexoes().getConnection();
		}
		
		public int inserir(Cliente c) {
			int inseriu = 0;
			String sql = "INSERT INTO cliente values (?);";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setString(1, c.getNome());
				inseriu = stmt.executeUpdate();
				stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return inseriu;
		}

		public ArrayList<Roupa> GetListaCompras(){
			int inseriu = 0;
			String sql = "Select co.codigoRoupa from cliente c inner join compra co on co.nomeCliente=c.nome";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				ArrayList <Roupa> roupas = new ArrayList<>();
				while(rs.next()) {
					Roupa r = new Roupa();
					r.setCodigo(rs.getInt("codigoRoupa"));
					roupas.add(r);
				}
				rs.close();
				stmt.close();
				return roupas;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			
		}
		
		public ArrayList<Cliente> getLista(){
			String sql = "select nome from cliente;";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				ArrayList <Cliente> clientes = new ArrayList<>();
				while(rs.next()) {
					Cliente c = new Cliente();
					c.setNome(rs.getString("nome"));
					clientes.add(c);
				}
				rs.close();
				stmt.close();
				return clientes;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public ArrayList<String> getListaNome(){
			String sql = "select nome from cliente;";
			PreparedStatement stmt;
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				ArrayList <String> nomes = new ArrayList<>();
				while(rs.next()) {
					nomes.add(rs.getString("nome"));
				}
				rs.close();
				stmt.close();
				return nomes;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}

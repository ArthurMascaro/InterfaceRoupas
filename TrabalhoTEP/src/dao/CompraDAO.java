package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import bean.Compra;


public class CompraDAO {
	
	private Connection connection;
	
	public CompraDAO(){
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(String nomeCliente, int codigoRoupa) {
		int inseriu = 0;
		String sql = "INSERT INTO compra(nomeCliente, codigoRoupa, data, horario) values (?, ?, ?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, nomeCliente);
			stmt.setInt(2, codigoRoupa);
			String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
			String hourStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
			stmt.setString(3, timeStamp);
			stmt.setString(4, hourStamp);
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Compra> Listar() {
		String sql = "Select * from compra";
		PreparedStatement stmt;
		ArrayList<Compra> compras = new ArrayList<>();
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Compra c = new Compra();
				c.setNomeCliente(rs.getString("nomeCliente"));
				c.setCodigoRoupa(rs.getInt("codigoRoupa"));
				c.setData(rs.getString("data"));
				c.setHorario(rs.getString("horario"));
				compras.add(c);
				
		} 
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return compras;
	}

	public Pair<ArrayList<String>, ArrayList<Double>> Tipos(ArrayList<Compra> compras){
		ArrayList<String> tipos = new ArrayList<>();
		ArrayList<Double> precos = new ArrayList<>();
		PreparedStatement stmt;
		for (Compra c : compras ) {
			String sql = "Select r.preco from camiseta c inner join roupa r on r.codigo=c.codigoRoupa where codigoRoupa = ?";			
			try {
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, c.getCodigoRoupa());
				ResultSet rs = stmt.executeQuery();
				if(!rs.next()) {
					String sql1 = "Select r.preco from vestido v inner join roupa r on r.codigo=v.codigoRoupa where codigoRoupa = ?";
					stmt = (PreparedStatement) connection.prepareStatement(sql1);
					stmt.setInt(1, c.getCodigoRoupa());
					ResultSet rs1 = stmt.executeQuery();
					if(!rs1.next()) {
						String sql2 = "Select r.preco from calca c inner join roupa r on r.codigo=c.codigoRoupa where codigoRoupa = ?";
						stmt = (PreparedStatement) connection.prepareStatement(sql2);
						stmt.setInt(1, c.getCodigoRoupa());
						ResultSet rs2 = stmt.executeQuery();
						rs2.next();
						precos.add(rs2.getDouble("preco"));
						String tipo = "Calça";
						tipos.add(tipo);
					} else {
						precos.add(rs1.getDouble("preco"));
						String tipo = "Vestido";
						tipos.add(tipo);
					}
				} else {
					precos.add(rs.getDouble("preco"));
					String tipo = "Camiseta";
					tipos.add(tipo);
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		}
		return new Pair<ArrayList<String>, ArrayList<Double>>(tipos, precos);
		}
	
}

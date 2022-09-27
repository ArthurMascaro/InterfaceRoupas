package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Vestido;

public class VestidoDAO {
	
private Connection connection;
	
	public VestidoDAO(){
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Vestido v) {
		int inseriu = 0;
		String sql = "INSERT INTO vestido(codigoRoupa, estampa) values (?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, v.getCodigo());
			stmt.setString(2, v.getEstampa());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}
	
	public ArrayList<Vestido> GetLista(){
		String sql = "select r.codigo as codigo, r.preco as preco, v.estampa as estampa from roupa r inner join vestido v on v.codigoRoupa = r.codigo;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Vestido> vestidos = new ArrayList<>();
			while(rs.next()) {
				Vestido v = new Vestido();
				v.setCodigo(rs.getInt("codigo"));
				v.setPreco(rs.getDouble("preco"));
				v.setEstampa(rs.getString("estampa"));
				vestidos.add(v);
			}
			rs.close();
			stmt.close();
			return vestidos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

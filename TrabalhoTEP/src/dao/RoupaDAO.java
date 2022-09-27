package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Roupa;

public class RoupaDAO {
	
	private Connection connection;
	
	public RoupaDAO(){
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Roupa r) {
		int inseriu = 0;
		String sql = "INSERT INTO roupa(codigo, preco) values (?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, r.getCodigo());
			stmt.setDouble(2, r.getPreco());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}

}

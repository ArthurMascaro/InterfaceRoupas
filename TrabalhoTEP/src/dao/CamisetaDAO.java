package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Camiseta;
import bean.Vestido;


public class CamisetaDAO {
	
private Connection connection;
	
	public CamisetaDAO(){
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Camiseta c) {
		int inseriu = 0;
		String sql = "INSERT INTO camiseta(codigoRoupa, tamanho) values (?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getCodigo());
			String tamanho =  Character.toString(c.getTamanho());
			stmt.setString(2, tamanho);
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}

	public ArrayList<Camiseta> GetLista(){
		String sql = "select r.codigo as codigo, r.preco as preco, c.tamanho as tamanho from roupa r inner join camiseta c on c.codigoRoupa = r.codigo;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Camiseta> camisetas = new ArrayList<>();
			while(rs.next()) {
				Camiseta c = new Camiseta();
				c.setCodigo(rs.getInt("codigo"));
				c.setPreco(rs.getDouble("preco"));
				String ch = rs.getString("tamanho");
				c.setTamanho(ch.charAt(0));
				camisetas.add(c);
			}
			rs.close();
			stmt.close();
			return camisetas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
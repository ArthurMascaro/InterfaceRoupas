package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Calca;

public class CalcaDAO {
	
private Connection connection;
	
	public CalcaDAO(){
		connection = new FabricaConexoes().getConnection();
	}
	
	public int inserir(Calca c) {
		int inseriu = 0;
		String sql = "INSERT INTO calca(codigoRoupa, tamanho) values (?, ?);";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, c.getCodigo());
			stmt.setInt(2, c.getNumero());
			inseriu = stmt.executeUpdate();
			stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return inseriu;
	}

	public ArrayList<Calca> GetLista(){
		String sql = "select r.codigo as codigo, r.preco as preco, c.tamanho as tamanho from roupa r inner join calca c on c.codigoRoupa = r.codigo;";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList <Calca> calcas = new ArrayList<>();
			while(rs.next()) {
				Calca c = new Calca();
				c.setCodigo(rs.getInt("codigo"));
				c.setPreco(rs.getDouble("preco"));
				c.setNumero(rs.getInt("tamanho"));
				calcas.add(c);
			}
			rs.close();
			stmt.close();
			return calcas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

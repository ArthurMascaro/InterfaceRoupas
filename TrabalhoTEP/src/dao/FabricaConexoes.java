package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/trabalho_tep?allowPublicKeyRetrieval=true&useSSL=false", "root", "Art31102005*");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

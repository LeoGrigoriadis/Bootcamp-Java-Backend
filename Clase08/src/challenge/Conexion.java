package challenge;
import java.sql.*;

public class Conexion {
	public Connection conexionDB() {
		String urlServer="jdbc:mysql://localhost:3306/Comercio";
		String userDb="root";
		String passDb="";
		Connection conectar=null;
		try {
			System.out.println("Conectado correctamente.");
			conectar=DriverManager.getConnection(urlServer, userDb, passDb);
			return conectar;
		} catch (SQLException e) { 
			e.printStackTrace(); 
			System.out.println("ERROR en la conexión.");
			return null;
		}
	}
}
import java.sql.*;

public class Conexion {
	public Connection conexionDB() {
		String urlServer="jdbc:mysql://localhost:3306/mydb";
		String userDb="root";
		String passDb="";
		Connection conectar=null;
		try {
			System.out.println("Conectado correctamente.");
			return conectar=DriverManager.getConnection(urlServer, userDb, passDb);
		} catch (SQLException e) { 
			e.printStackTrace(); 
			System.out.println("ERROR en la conexión.");
			return null;
		}
	}
	public static void main(String[] args) {
		Conexion conectar = new Conexion();
		Connection conectado=null;
		conectado=conectar.conexionDB();
		
		String script="SELECT * from album";
		try {
			Statement st=conectado.createStatement();
			ResultSet rs=st.executeQuery(script);
			while(rs.next()) {
				int idalbum= rs.getInt("idalbum");
				String nombre=rs.getString("nombre");
//				System.out.println(idalbum+" "+nombre);
				System.out.format("%s, %s\n", idalbum,nombre);
			}
		}catch (SQLException e) { e.printStackTrace(); }
	}	
}
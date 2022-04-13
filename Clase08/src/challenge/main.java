package challenge;
import java.sql.*;

public class main {

	public static void main(String[] args) {
		Conexion conectar = new Conexion();
		Connection conectado=null;
		conectado=conectar.conexionDB();
		SelectClass sel=new SelectClass(conectado);
		sel.Select();
	}
}
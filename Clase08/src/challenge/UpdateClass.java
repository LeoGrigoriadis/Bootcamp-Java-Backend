package challenge;
import java.sql.*;

public class UpdateClass extends Model{
	
	public UpdateClass(Connection conectado) {super(conectado);}
	public void Update() {
		setScript("UPDATE Cliente SET id=?, nombre=?, apellido=?, dni=?, direccion=?, fechaNacimiento=?,vendedor_id=? where id=?");
		System.out.println(getScript());
		try {
		st=conectado.createStatement();
		}catch (SQLException e) { e.printStackTrace(); System.out.println("Tabla no encontrada."); }
	}
}

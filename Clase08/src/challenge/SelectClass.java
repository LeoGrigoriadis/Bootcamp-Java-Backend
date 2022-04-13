package challenge;
import java.sql.*;
public class SelectClass extends Model{
	public SelectClass(Connection conectado) { super(conectado); }
	public void Select() {				
		System.out.format("%s, %s, %s, %s, %s, %s, %s\n", getId(),getNombre(),getApellido(),getDni(),getDireccion(),getFechaNacimiento(),getVendedor_id());
	}
}
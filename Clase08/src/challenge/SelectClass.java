package challenge;
import java.sql.*;

public class SelectClass extends Model{
	
	public SelectClass(Connection conectado) { super(conectado); }
	public void Select(){
		setScript("SELECT * from Cliente");
		System.out.println(getScript());
		try {
			st=conectado.createStatement();
			rs=st.executeQuery(getScript());
			while(rs.next()) {
				setId(rs.getInt("id"));
				setNombre(rs.getString("nombre"));
				setApellido(rs.getString("apellido"));
				setDni(rs.getInt("dni"));
				setDireccion(rs.getString("direccion"));
				setFechaNacimiento(rs.getDate("fechaNacimiento"));
				setVendedor_id(rs.getInt("vendedor_id"));
				System.out.format("%s, %s, %s, %s, %s, %s, %s", getId(),getNombre(),getApellido(), getDni(),getDireccion(),getFechaNacimiento(), getVendedor_id());
			}
		}catch (SQLException e) { e.printStackTrace(); System.out.println("Tabla no encontrada."); }
	}		
}

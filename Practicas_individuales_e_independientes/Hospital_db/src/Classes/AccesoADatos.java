package Classes;

public class AccesoADatos{
	private Conexion conexion;
	//constructor
	public AccesoADatos(Conexion conexion) { this.conexion=conexion; }
	//metodos
	public void altaUser(Usuario u) { this.conexion.altaUser(u); }
	public void bajaUser(Usuario u) { this.conexion.bajaUser(u); }
	public void getUsers() { this.conexion.getUsers(); }
	public boolean UserRegistrado(Usuario u) { return this.conexion.UserRegistrado(u); }
}
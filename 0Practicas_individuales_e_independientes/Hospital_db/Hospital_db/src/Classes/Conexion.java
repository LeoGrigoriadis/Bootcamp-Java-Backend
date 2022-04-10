package Classes;

public interface Conexion{
	public void altaUser(Usuario u);
	public void bajaUser(Usuario u);
	public void getUsers();
	public boolean UserRegistrado(Usuario u);
}
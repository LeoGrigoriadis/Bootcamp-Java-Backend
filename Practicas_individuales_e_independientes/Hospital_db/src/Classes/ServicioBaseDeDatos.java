package Classes;
import java.util.ArrayList;

public class ServicioBaseDeDatos implements Conexion{
	private ArrayList<Usuario>user=new ArrayList<Usuario>();
	@Override
	public void altaUser(Usuario u) { user.add(u); }
	@Override
	public void bajaUser(Usuario u) { user.remove(u); }
	@Override
	public void getUsers() { for(Usuario u:user) System.out.println("nombre: '"+u.getNombreUser()+"', contraseña: '"+u.getContraUser()+"', es cliente: "+u.getEsCliente()); }
	@Override
	public boolean UserRegistrado(Usuario u) {
		boolean ret=false;
		for(Usuario aux:user) { 
			if(aux.getId()==u.getId()) ret=true;
			else ret=false;
			}
		return ret;
	}
}
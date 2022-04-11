
public class PersonalServicio extends Empleado{
	private String seccion;
	//constructor
	public PersonalServicio(String nombre, String apellido, String estadoCivil, int id, int a�oIncorporacion,
			int numDespacho, String seccion) {
		super(nombre, apellido, estadoCivil, id, a�oIncorporacion, numDespacho);
		this.seccion=seccion;
	}//metodos
	public void setSeccion(String s)  {seccion=s; }
	public void imprimir() {
		System.out.println("nombre: "+getNombre()+", apellido: "+getApellido()+", estado civil: "
		+getEstadoCivil()+", identificaci�n: "+getId()+", a�o de incorporaci�n: "+getA�oIncorporacion()
		+", n�mero de despacho: "+getNumDespacho()+", seccion: "+seccion);
	}
}
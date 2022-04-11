
public class PersonalServicio extends Empleado{
	private String seccion;
	//constructor
	public PersonalServicio(String nombre, String apellido, String estadoCivil, int id, int añoIncorporacion,
			int numDespacho, String seccion) {
		super(nombre, apellido, estadoCivil, id, añoIncorporacion, numDespacho);
		this.seccion=seccion;
	}//metodos
	public void setSeccion(String s)  {seccion=s; }
	public void imprimir() {
		System.out.println("nombre: "+getNombre()+", apellido: "+getApellido()+", estado civil: "
		+getEstadoCivil()+", identificación: "+getId()+", año de incorporación: "+getAñoIncorporacion()
		+", número de despacho: "+getNumDespacho()+", seccion: "+seccion);
	}
}
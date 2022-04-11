
public class Profesor extends Empleado{
	private String departamento;
	//constructor
	public Profesor(String nombre, String apellido, String estadoCivil, int id, int a�oIncorporacion, int numDespacho, String departamento) {
		super(nombre, apellido, estadoCivil, id, a�oIncorporacion, numDespacho);
		this.departamento=departamento;
	}//metodos
	public void setDepartamento(String d) { departamento=d; } 
	public void imprimir() {
		System.out.println("nombre: "+getNombre()+", apellido: "+getApellido()+", estado civil: "
		+getEstadoCivil()+", identificaci�n: "+getId()+", a�o de incorporaci�n: "+getA�oIncorporacion()
		+", n�mero de despacho: "+getNumDespacho()+", departamento: "+departamento);
	}
}
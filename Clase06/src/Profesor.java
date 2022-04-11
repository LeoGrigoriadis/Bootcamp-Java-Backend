
public class Profesor extends Empleado{
	private String departamento;
	//constructor
	public Profesor(String nombre, String apellido, String estadoCivil, int id, int añoIncorporacion, int numDespacho, String departamento) {
		super(nombre, apellido, estadoCivil, id, añoIncorporacion, numDespacho);
		this.departamento=departamento;
	}//metodos
	public void setDepartamento(String d) { departamento=d; } 
	public void imprimir() {
		System.out.println("nombre: "+getNombre()+", apellido: "+getApellido()+", estado civil: "
		+getEstadoCivil()+", identificación: "+getId()+", año de incorporación: "+getAñoIncorporacion()
		+", número de despacho: "+getNumDespacho()+", departamento: "+departamento);
	}
}
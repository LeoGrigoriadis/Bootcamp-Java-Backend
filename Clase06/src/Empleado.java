
public class Empleado extends Persona{
	private int a�oIncorporacion, numDespacho;
	//constructor
	public Empleado(String nombre, String apellido, String estadoCivil, int id, int a�oIncorporacion, int numDespacho) {
		super(nombre, apellido, estadoCivil, id);
		this.a�oIncorporacion = a�oIncorporacion;
		this.numDespacho = numDespacho;
	}//getters
	public int getA�oIncorporacion() { return a�oIncorporacion; } 
	public int getNumDespacho() { return numDespacho; } 
	//metodos
	public void setNumDespacho(int d) { numDespacho=d; }
}
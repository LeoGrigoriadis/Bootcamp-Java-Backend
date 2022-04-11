
public class Empleado extends Persona{
	private int añoIncorporacion, numDespacho;
	//constructor
	public Empleado(String nombre, String apellido, String estadoCivil, int id, int añoIncorporacion, int numDespacho) {
		super(nombre, apellido, estadoCivil, id);
		this.añoIncorporacion = añoIncorporacion;
		this.numDespacho = numDespacho;
	}//getters
	public int getAñoIncorporacion() { return añoIncorporacion; } 
	public int getNumDespacho() { return numDespacho; } 
	//metodos
	public void setNumDespacho(int d) { numDespacho=d; }
}
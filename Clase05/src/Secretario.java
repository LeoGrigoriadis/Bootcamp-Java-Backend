
public class Secretario extends Empleado implements imprimirDatos{
	private String despacho, numFax ,puesto="secretario";
	//constructor
	public Secretario(String nombre, String apellido, String dni, String direccion, String telefono, double salario) {
		super(nombre, apellido, dni, direccion, telefono, salario);
		this.icrementarSalario(salario+=(salario*0.05));
	}
	//setters y getters de datos no inicializados o secundarios
	public void setDespacho(String despacho) { this.despacho = despacho; }
	public void setNumFax(String numFax) { this.numFax = numFax; }
	
	public String getDespacho() { return despacho; }
	public String getNumFax() {	return numFax; }
	
	//imprimir datos
	@Override
	public void imprimir() { super.imprimir(); System.out.print(", puesto: "+puesto+"\n"); }
}
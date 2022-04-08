
public class Empleado implements imprimirDatos{
	private String nombre, apellido, dni, direccion, telefono;
	private double salario;
	private int antiguedad;
	private Empleado supervisor;
	
	//constructor
	public Empleado(String nombre, String apellido, String dni, String direccion, String telefono, double salario) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.telefono=telefono;
		this.salario=salario;
	}
	//setters de datos no inicializados
	public void setAntig(int antiguedad) { this.antiguedad = antiguedad; }
	
	//metodos
	public void cambiarSupervisor(Empleado s) { this.supervisor=s; }
	public void icrementarSalario(double aux) { this.salario+=aux; }
	
	//imprimir datos
	@Override
	public void imprimir() {
		System.out.print("nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", direccion=" + direccion
		+ ", telefono=" + telefono + ", antiguedad=" + antiguedad + ", salario=" + salario + ", supervisor="+ supervisor);
	}
}
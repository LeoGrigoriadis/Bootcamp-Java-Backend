package Challenge;

import java.util.Scanner;

public class Model {
	private String nombre, apellido, direccion;
	private Integer dni;
	protected Scanner teclado = new Scanner(System.in);
	
	public Model() {}

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }

	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }

	public Integer getDni() { return dni; }
	public void setDni(Integer dni) { this.dni =dni; }
}
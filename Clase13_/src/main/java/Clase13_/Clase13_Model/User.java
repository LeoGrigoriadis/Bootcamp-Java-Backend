package Clase13_.Clase13_Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class User {
	
	@Id  	//id auto insertado
	private String id;
			//atributos
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	
	//constructores
	public User(){ }
	public User(String nombre, String apellido, String direccion, int dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.dni=dni;
	}
	
	//setters y getters
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }

	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }

	public int getDni() { return dni; }
	public void setDni(int dni) { this.dni = dni; }
}
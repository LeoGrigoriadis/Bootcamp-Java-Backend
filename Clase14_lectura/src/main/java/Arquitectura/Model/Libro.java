package Arquitectura.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "libros")
public class Libro {
	
	@Id private int id;
	private String autor, nombre, editorial, fecha;
	
	//constructor
	public Libro(String nombre, String autor, String editorial, String fecha) {
		super();
		this.autor = autor;
		this.nombre = nombre;
		this.editorial = editorial;
		this.fecha = fecha;
	}
	//setters y getters
	public String getAutor() { return autor; }
	public void setAutor(String autor) { this.autor = autor; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getEditorial() { return editorial; }
	public void setEditorial(String editorial) { this.editorial = editorial; }

	public String getFecha() { return fecha; }
	public void setFecha(String fecha) { this.fecha = fecha; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
}
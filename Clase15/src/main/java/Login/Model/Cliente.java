package Login.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection="clientes")
public class Cliente {
	@Id  	//id auto insertado
	@ApiModelProperty(position=1)
	private String id;
			//atributos
	@ApiModelProperty(position=3, required=true)
	@Indexed(unique = true)
	private int dni;
	@ApiModelProperty(position=2, required=true)
	private String email;
	@ApiModelProperty(position=4, required=true)
	private String nombre;
	@ApiModelProperty(position=5)
	private String apellido;
	@ApiModelProperty(position=6)
	private String telefono;
	//constructor
	public Cliente(int dni, String email, String nombre, String apellido, String telefono) {
		this.dni = dni;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	//getters y setters
		public String getId() { return id; }
		public void setId(String id) { this.id = id; }

		public String getNombre() { return nombre; }
		public void setNombre(String nombre) { this.nombre = nombre; }

		public int getDni() { return dni; }
		public void setDni(int dni) { this.dni = dni; }

		public String getEmail() { return email; }
		public void setEmail(String email) { this.email = email; }

		public String getApellido() { return apellido; }
		public void setApellido(String apellido) { this.apellido = apellido; }
		
		public String getTelefono() { return telefono; }
		public void setTelefono(String telefono) { this.telefono = telefono; }
}
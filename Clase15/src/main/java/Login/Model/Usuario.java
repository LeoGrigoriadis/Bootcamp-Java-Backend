package Login.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "usuario")
public class Usuario {
	@Id  	//id auto insertado
	@ApiModelProperty(position=1)
	private String id;
			//atributos
	@ApiModelProperty(position=4)
	private String nombre;
	@ApiModelProperty(position=5)
	private String apellido;
	@ApiModelProperty(position=2, required=true)
	@Indexed(unique = true)
	private String email;
	@ApiModelProperty(position=3, required=true)
	private String password;
	//constructor
	public Usuario(String nombre, String apellido, String email, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
	}
	//getters y setters
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }

	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }	
}
package Login.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "productos")
public class Producto {
	@Id  	//id auto insertado
	@ApiModelProperty(position=1)
	private String id;
			//atributos
	@ApiModelProperty(position=3)
	private String nombre;
	@ApiModelProperty(position=2, required=true)
	@Indexed(unique = true)
	private String codigo;
	@ApiModelProperty(position=4, required=true)
	private int cantidad;
	@ApiModelProperty(position=5, required=true)
	private double precio;
	//constructor
	public Producto(String nombre, String codigo, int cantidad, double precio) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	//getters y setters
		public String getId() { return id; }
		public void setId(String id) { this.id = id; }

		public String getNombre() { return nombre; }
		public void setNombre(String nombre) { this.nombre = nombre; }

		public String getCodigo() { return codigo; }
		public void setCodigo(String codigo) { this.codigo = codigo; }

		public int getCantidad() { return cantidad; }
		public void setCantidad(int cantidad) { this.cantidad = cantidad; }

		public double getPrecio() { return precio; }
		public void setPrecio(double precio) { this.precio = precio; }
}
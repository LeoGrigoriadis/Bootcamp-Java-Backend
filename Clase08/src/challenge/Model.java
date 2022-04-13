package challenge;
import java.sql.*;

public class Model {
	protected Statement st;
	protected ResultSet rs;
	protected Connection conectado;
	
	private String script, nombre, apellido, direccion;
	private Date fechaNacimiento;
	private int id, dni, vendedor_id;
	
	public Model(Connection conectado) {
		this.conectado=conectado;
	}
	
	public Statement getSt() { return st; }
	public ResultSet getRs() { return rs; }
	public String getScript() { return script; }
	public void setScript(String script) { this.script = script; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public String getDireccion() { return direccion; }
	public void setDireccion(String direccion) { this.direccion = direccion; }
	public Date getFechaNacimiento() { return fechaNacimiento; }
	public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public int getDni() { return dni; }
	public void setDni(int dni) { this.dni = dni; }
	public int getVendedor_id() { return vendedor_id; }
	public void setVendedor_id(int vendedor_id) { this.vendedor_id = vendedor_id; }
}
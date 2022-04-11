
public class Persona {
	private String nombre, apellido, estadoCivil;
	private int id;
	//constructor
	public Persona(String nombre, String apellido, String estadoCivil, int id) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.estadoCivil = estadoCivil;
		this.id = id;
	}
	//getters
	public String getNombre() { return nombre; }
	public String getApellido() { return apellido; }
	public String getEstadoCivil() { return estadoCivil; }
	public int getId() { return id; }
	//metodos
	public void setEstadoCivil(String es) { estadoCivil=es; }
}
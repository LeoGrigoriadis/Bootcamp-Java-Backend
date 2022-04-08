import java.util.ArrayList;

public class Persona {
	private String nombre;
	private String apellido;
	private boolean cedula;
	private boolean licenciaDeConducir;
	private ArrayList<Multa> multas;
	//constructor
	public Persona(String nombre, String apellido, boolean cedula, boolean licenciaDeConducir) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.licenciaDeConducir = licenciaDeConducir;
		this.multas = new ArrayList<Multa>();
	}//setter y getter	
	public String getNombre() { return nombre; }
	public String getApellido() { return apellido; }
	public boolean isCedula() { return cedula; }
	public boolean isLicenciaDeConducir() { return licenciaDeConducir; }
	
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public void setCedula(boolean cedula) { this.cedula = cedula; }
	public void setLicenciaDeConducir(boolean licenciaDeConducir) { this.licenciaDeConducir = licenciaDeConducir; }
	//metodos
	public void agregarMulta(Multa multa) { multas.add(multa); }
	public boolean isHabilitado() { return this.cedula && this.licenciaDeConducir; }
}
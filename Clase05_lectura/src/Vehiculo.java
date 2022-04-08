
public abstract class Vehiculo {
	private String patente;
	private Persona	due�o;
	private double peso;
	//constructor
	public Vehiculo(String patente, Persona due�o, double peso) {
		this.patente = patente;
		this.due�o = due�o;
		this.peso = peso;
	}//setter y getter
	public String getPatente() { return patente; }
	public Persona getDue�o() { return due�o; }
	public double getPeso() { return peso; }
	
	public void setPatente(String patente) { this.patente = patente; }
	public void setDue�o(Persona due�o) { this.due�o = due�o; }
	public void setPeso(double peso) { this.peso = peso; }
	//metodos
	public abstract	boolean puedoPasar();	
}
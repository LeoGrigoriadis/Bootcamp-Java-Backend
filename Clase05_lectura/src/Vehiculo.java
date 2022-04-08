
public abstract class Vehiculo {
	private String patente;
	private Persona	dueño;
	private double peso;
	//constructor
	public Vehiculo(String patente, Persona dueño, double peso) {
		this.patente = patente;
		this.dueño = dueño;
		this.peso = peso;
	}//setter y getter
	public String getPatente() { return patente; }
	public Persona getDueño() { return dueño; }
	public double getPeso() { return peso; }
	
	public void setPatente(String patente) { this.patente = patente; }
	public void setDueño(Persona dueño) { this.dueño = dueño; }
	public void setPeso(double peso) { this.peso = peso; }
	//metodos
	public abstract	boolean puedoPasar();	
}
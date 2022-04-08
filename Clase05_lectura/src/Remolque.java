public class Remolque {
	private double peso;
	private String matricula;
	//constructor
	public Remolque(double peso, String matricula) {
		this.peso = peso;
		this.matricula = matricula;
	}//setter y getter
	public double getPeso() { return peso; }
	public String getMatricula() { return matricula; }	
}
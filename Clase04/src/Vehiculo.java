
public class Vehiculo {
	private String matricula;
	private double velocidad;
	
	public Vehiculo(String matricula) {
		this.matricula=matricula;
		this.velocidad=0;
	}
	public void setAcelerar(int velocidad) {
		this.velocidad += velocidad;
		System.out.println("Acelerando hasta "+this.velocidad+" km/h.");
	}
	public double getVelocidad() {
		return velocidad;
	}
	public String getMatricula() {
		return matricula;
	}
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", velocidad=" + velocidad + "]";
	}
}
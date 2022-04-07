
public class Vehiculo {
	private String matricula;
	private double velocidad;
	
	public Vehiculo(String matricula) {
		this.matricula=matricula;
		this.velocidad=0;
	}
	public void setAcelerar (int acelerar) throws DemasiadoRapidoException{
		velocidad += (acelerar);
		System.out.println("Acelerando hasta "+velocidad+" km/h.");
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
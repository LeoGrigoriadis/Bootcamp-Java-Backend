
public class Particular extends Vehiculo{
	private int puertas;
	
	public Particular(String matricula, int puertas) {
		super(matricula);
		this.puertas=puertas;
	}
	public int getPuertas() { return puertas; }
	@Override
	public String toString() {
		return "Particular [puertas=" + puertas + ", velocidad=" + getVelocidad() + ", matricula="
				+ getMatricula() + "]";
	}
}
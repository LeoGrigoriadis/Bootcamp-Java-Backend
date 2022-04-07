
public class Carga extends Vehiculo{
	private double velocidad;
	private Remolque remolque=null;
	
	public Carga(String matricula) {
		super(matricula);
		this.velocidad=getVelocidad();
	}
	public void ponRemolque(Remolque r) { System.out.println("Remolque puesto."); remolque=r; }
	
	public void quitarRemolque() { System.out.println("Remolque quitado."); remolque=null; }
	
	@Override
	public void setAcelerar(int acelerar) throws DemasiadoRapidoException{
		if(remolque!=null && (velocidad += (acelerar))>100) { throw new DemasiadoRapidoException(); }
		velocidad += (acelerar);
		System.out.println("Acelerando hasta "+this.velocidad+" km/h.");
	}
	public String toString() {
		return "Carga [velocidad=" + velocidad + ", remolque=" + remolque + ", matricula=" + getMatricula() + "]";
	}
}
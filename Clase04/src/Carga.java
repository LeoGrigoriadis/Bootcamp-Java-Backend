
public class Carga extends Vehiculo{
	private int velocidad;
	private Remolque remolque= null;
	
	public Carga(String matricula) {
		super(matricula);
		this.velocidad=getVelocidad();
	}
	public void ponRemolque(Remolque r) { System.out.println("Remolque puesto."); remolque=r; }
	
	public void quitarRemolque() { System.out.println("Remolque quitado."); remolque=null; }
	
	public void setAcelerar(int acelerar) {
		velocidad += acelerar;
		System.out.println("Acelerando hasta "+this.velocidad+" km/h.");
		if(remolque!=null&&velocidad>100) {
			System.out.println("La velocidad es muy alta, se bajará al máximo de 100km/h.");
			velocidad=100;
		}
	}
	@Override
	public String toString() {
		return "Carga [velocidad=" + velocidad + ", remolque=" + remolque + ", matricula=" + getMatricula() + "]";
	}
}
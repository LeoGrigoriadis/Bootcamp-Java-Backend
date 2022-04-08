public class Camion extends Vehiculo {
	private Remolque remolque;
	//constructor
	public Camion(String patente, Persona dueño, double peso) {
		super(patente, dueño, peso);
		this.remolque=null;
	}//setter y getter
	public Remolque getRemolque() { return remolque; }
	//metodos
	public void agregarRemolque(Remolque remolque) { this.remolque = remolque; }
	public void sacarRemolque() { this.remolque=null; }
	@Override
	public boolean puedoPasar() {
		double pesoTotal;
		if(this.remolque!=null) pesoTotal = this.getPeso()+this.remolque.getPeso();
		else pesoTotal=this.getPeso();
		if(pesoTotal>7500) return false;
		else return true;
	}
}
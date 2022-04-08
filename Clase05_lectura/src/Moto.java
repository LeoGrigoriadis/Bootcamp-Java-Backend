
public class Moto extends Vehiculo {
	private boolean casco;
	private boolean vtv;
	//constructor
	public Moto(String patente, Persona dueño, double peso, boolean casco,boolean vtv) {
		super(patente, dueño, peso);
		this.casco = casco;
		this.vtv = vtv;
	}//setter y getter
	public boolean isCasco() { return casco; }
	public void setCasco(boolean casco) { this.casco = casco; }
	public boolean isVtv() { return vtv; }
	public void setVtv(boolean vtv) { this.vtv = vtv; }
	@Override
	public boolean puedoPasar() {
		if(this.casco && this.vtv && this.getPeso()<200) return true;
		else return false; 
	}	
}
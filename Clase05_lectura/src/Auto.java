public class Auto extends Vehiculo{
	private boolean vtv;
	//constructor
	public Auto(String patente, Persona dueño, double peso, boolean vtv) {
		super(patente, dueño, peso);
		this.vtv = vtv;
	}//setter y getter
	public boolean isVtv() { return vtv; }
	public void setVtv(boolean vtv) { this.vtv = vtv; }
	//metodos
	@Override
	public boolean puedoPasar() {
		if(this.getPeso()<500 && this.vtv) return true;
		else return false;
	}
}
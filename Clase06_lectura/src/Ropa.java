import java.util.ArrayList;

public abstract class Ropa {
	private double cantTela, tiempoDeFabricacion;
	private ArrayList<String>colores;
	public Ropa(){
		colores=new ArrayList<String>();
	}
	public double getCantTela() { return cantTela; }

	public void setCantTela(double cantTela) { this.cantTela = cantTela; }

	public double getTiempoDeFabricacion() { return tiempoDeFabricacion; }

	public void setTiempoDeFabricacion(double tiempoDeFabricacion) { this.tiempoDeFabricacion = tiempoDeFabricacion; }

	public void agregarColores(String c ) { colores.add(c); }
}
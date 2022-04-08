
public class Multa {
	private String fecha;
	private double monto;
	//constructor
	public Multa(String fecha, double monto) {
		this.fecha = fecha;
		this.monto = monto;
	}//setter y getter
	public String getFecha() { return fecha; }
	public double getMonto() { return monto; }

	public void setFecha(String fecha) { this.fecha = fecha; }
	public void setMonto(double monto) { this.monto = monto; }

	@Override
	public String toString() { return "Multa [fecha=" + fecha + ", monto=" + monto + "]"; }
}
import java.util.ArrayList;

public class Vendedor extends Empleado implements imprimirDatos{
	private String puesto="vendedor", telefonoMovil, areaVentas;
	private ArrayList<String>listaClientes=new ArrayList<String>();
	private double comisiones;
	private Coche coche;
	//constructor
	public Vendedor(String nombre, String apellido, String dni, String direccion, String telefono, double salario) {
		super(nombre, apellido, dni, direccion, telefono, salario);
		this.icrementarSalario(salario+=(salario*0.1));
	}
	
	//setters y getters de datos no inicializados o secundarios
	public String getTelefonoMovil() { return telefonoMovil; }
	public String getAreaVentas() { return areaVentas; }
	public double getComisiones() { return comisiones; }
	public Coche getCoche() { return coche; }
	
	public void setTelefonoMovil(String telefonoMovil) { this.telefonoMovil = telefonoMovil; }
	public void setAreaVentas(String areaVentas) { this.areaVentas = areaVentas; }
	public void setComisiones(double comisiones) { this.comisiones = comisiones; }

	//metodos
	public void altaCliente(String cliente) { this.listaClientes.add(cliente); }
	public void bajaCliente(String cliente) { this.listaClientes.remove(cliente); }
	public void cambiarCoche(Coche c) { this.coche=c; }
	
	//imprimir datos
	@Override
	public void imprimir() { super.imprimir(); System.out.print("puesto: "+puesto+"\n"); }
}

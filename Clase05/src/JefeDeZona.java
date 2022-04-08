import java.util.ArrayList;

public class JefeDeZona extends Empleado implements imprimirDatos{
	private String despacho, numFax ,puesto="secretario";
	private Secretario secretario;
	private ArrayList<Vendedor> listaVendedores= new ArrayList<Vendedor>();
	private Coche coche;
	//constructor
	public JefeDeZona(String nombre, String apellido, String dni, String direccion, String telefono, double salario) {
		super(nombre, apellido, dni, direccion, telefono, salario);
		this.icrementarSalario(salario+=(salario*0.2));
	}
	//getters y setters de datps no inicializados o secundarios
	public String getDespacho() { return despacho; }
	public String getNumFax() { return numFax; }
	public Secretario getSecretario() { return secretario; }
	public Coche getCoche() { return coche; }
	
	public void setDespacho(String despacho) { this.despacho = despacho; }
	public void setNumFax(String numFax) { this.numFax = numFax; }
	public void setSecretario(Secretario secretario) { this.secretario = secretario; }
	public void setCoche(Coche coche) { this.coche = coche; }
	
	//metodos
	public void cambiarSecretario(Secretario s) { this.secretario=s; }
	public void cambiarCoche(Coche c) { this.coche=c; }
	public void altaVendedor(Vendedor v) { this.listaVendedores.add(v); }
	public void bajaVendedor(Vendedor v) { this.listaVendedores.remove(v); }
	
	//imprimir datos
	@Override
	public void imprimir() { super.imprimir(); System.out.print("puesto: "+puesto+"\n"); }
}
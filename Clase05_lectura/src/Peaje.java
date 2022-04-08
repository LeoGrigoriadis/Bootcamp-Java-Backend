import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Peaje {
	private ArrayList<Vehiculo> vehiculos;
	//constructor
	public Peaje() { vehiculos = new ArrayList<Vehiculo> (); }
	//metodos
	public void llegaVehiculo(Vehiculo vehiculo) { vehiculos.add(vehiculo); }
	public void imprimePasaVehiculo() {
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
		Vehiculo vehiculo = vehiculos.remove(0);
		Persona dueño = vehiculo.getDueño();
		if(vehiculo.getDueño().isHabilitado() && vehiculo.puedoPasar()) {
			System.out.println("El vehiculo "+vehiculo.getPatente() +" paso sin problemas");
		} else {
			Multa multa = new Multa(dtf2.format(LocalDateTime.now()),500);
			dueño.agregarMulta(multa);
			System.out.println("El  vehiculo "+vehiculo.getPatente() +" no paso y la multa es: "+multa.toString());
		}
	}
}
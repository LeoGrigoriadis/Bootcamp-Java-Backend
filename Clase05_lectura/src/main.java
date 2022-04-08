public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remolque remol = new Remolque(2700,"uwheq564");
		Persona pers = new Persona("Juan Carlos","Mostro",true,true);
		Persona pers2 = new Persona("Carklos Juan","Maestro",false,true);
		Persona pers3 = new Persona("Claudio","Cosama",true,true);
		Vehiculo cam = new Camion("asd123",pers,5000);
		Vehiculo auto = new Auto("qwe789",pers2,300,true);
		Vehiculo moto= new Moto("asd456",pers3,150,true,true);
		Peaje pj = new Peaje();
		
		((Camion)cam).agregarRemolque(remol);

		pj.llegaVehiculo(cam);
		pj.llegaVehiculo(auto);
		pj.llegaVehiculo(moto);
		
		comienzaAPasar(pj);	
	}	
	public static void comienzaAPasar(Peaje pj) {
		for(int i=0;i<3;i++) pj.imprimePasaVehiculo();
	}
}
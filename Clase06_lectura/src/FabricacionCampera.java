public class FabricacionCampera implements IFabricacion{
	@Override
	public void fabricar(IFabricacion r) {
		try {
		System.out.println("Se lleva a cabo el corte de la tela seleccionada mediante el uso de moldes,siguiendo los patrones correspondientes.");
		Thread.sleep(2000);
		System.out.println("En los bordes correspondientes se lleva a cabo la colocacion de hilo elastico.");
		Thread.sleep(2000);
		System.out.println("Una maquina cose los bordes de todas las partes implicadas en la campera, mientras se unene los bolsillos en sus lugares correspondientes.");
		Thread.sleep(2000);
		System.out.println("Con un hilo grueso se ubican y cosen el cierre y su carril, tanto sea de la misma campera como de sus bolsillos.");
		Thread.sleep(2000);
		System.out.println("Se ensambla todas las partes para finalmente obtener la campera,se unen los brazos y la capucha al torso.");
		Thread.sleep(2000);
		System.out.println("Preparamos la campera para el empaquetamiento");
		Thread.sleep(2000); 
		}catch (InterruptedException e) { e.printStackTrace(); }
	}
}
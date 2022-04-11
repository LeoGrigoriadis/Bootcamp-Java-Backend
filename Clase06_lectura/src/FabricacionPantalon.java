public class FabricacionPantalon implements IFabricacion{
	@Override
	public void fabricar(IFabricacion r) {
		try {
		System.out.println("Se cortan la tela seleccionada en varias partes siguiendo los patrones correspondientes.");
		 Thread.sleep(2000);
		System.out.println("Las piezas mas pequeñas se cortan con una troqueladora que hace los bolsillos con una matriz de corte.");
		Thread.sleep(2000);
		System.out.println("Se cose el bolsillo sobre la pieza trasera del pantalon.");
		Thread.sleep(2000);
		System.out.println("Una cuchilla se encarga de la abertura de los ojales mientras otra maquina cose sus bordes.");
		Thread.sleep(2000);
		System.out.println("Se unen las dos piezas que forman el jean por la entrepierna,con una maquina encargada de coser dicha union.");
		Thread.sleep(2000);
		System.out.println("Mientras se coloca el carro y los topes,una maquina acomoda y cose la cremallera en su lugar.");
		Thread.sleep(2000);
		System.out.println("El operario realiza la colocacion de una tira de tela que es la cinturilla.");
		Thread.sleep(2000);
		System.out.println("Para finalizar se planchan al vapor por 20 segundos y se preparan para su empaquetamiento.");
		Thread.sleep(2000);
		}catch (InterruptedException e) { e.printStackTrace(); }
	}
}
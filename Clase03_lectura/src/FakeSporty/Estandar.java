package FakeSporty;
import java.util.Scanner;

public class Estandar extends Usuario{
	private String[] canciones=getCanciones();
	private String actual=getActual();
	private int saltos=getSaltos();
	
	public Estandar() {
		ActualizarDatos(actual,saltos);
	}
	public void ActualizarDatos(String actual, int saltos) {
		setActual(actual);
		setSaltos(saltos);
	}
	public void saltarCancion() {
		saltos++;
		actual=canciones[saltos];
		ActualizarDatos(actual,saltos);
		if(saltos%3==0) {
			System.out.println("Estas escuchando un anuncio...");
			PausarConsole();
		}
		System.out.println("Se está reproduciendo la canción "+getActual());
	}
	public static void main(String[] args) {
		int op;
		Scanner teclado = new Scanner(System.in);
		boolean flag=false;
		System.out.println("---------Spotify---------");
		System.out.println("-------------------------");
		System.out.println("1_ Canción actual.-------");
		System.out.println("2_ Siguiente canción.----");
		System.out.println("3_ Reproducir aleatorio.-");
		System.out.println("4_ Descargar.------------");
		System.out.println("5_ Cerrar.---------------");
		System.out.print("_");
		op=teclado.nextInt();
		Estandar u=new Estandar();

		while(!flag) {
			u.ActualizarDatos(u.getActual(),u.getSaltos());
			u.setActual(u.getCanciones()[u.getSaltos()]);
			switch(op) {			
				case 1: System.out.println("Se está reproduciendo: "+u.getActual());
				u.PausarConsole(); break;
				case 2: u.saltarCancion(); u.PausarConsole();  break;
				case 3: u.repAleatorio(); u.PausarConsole();  break;
				case 4: System.out.println("Función no disponible para usuarios estándar."); u.PausarConsole();  break;
				case 5: System.out.println("Estas saliendo de la aplicación.");flag=true; u.PausarConsole();  break;
				default: System.out.println("Esta opción no es válida."); u.PausarConsole();  break;
			}
			if(!flag) {
			System.out.println("---------Spotify---------");
			System.out.println("-------------------------");
			System.out.println("1_ Canción actual.-------");
			System.out.println("2_ Siguiente canción.----");
			System.out.println("3_ Reproducir aleatorio.-");
			System.out.println("4_ Descargar.------------");
			System.out.println("5_ Cerrar.---------------");
			System.out.print("_");
			op=teclado.nextInt();
			}
			else System.out.println("Aplicación cerrada.");
		}	
	}
}

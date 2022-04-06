package FakeSporty;
import java.util.Random;
import java.util.Scanner;

public class Usuario {
	private String[] canciones= {"canción1", "canción2", "canción3", "canción4", "canción5", "canción6"};
	private int saltos=0, op;
	private String actual=canciones[saltos];
	private Scanner teclado = new Scanner(System.in);
	public Usuario() {	
		System.out.println("---------Spotify---------");
		System.out.println("-------------------------");
		System.out.println("1_ Canción actual.-------");
		System.out.println("2_ Siguiente canción.----");
		System.out.println("3_ Reproducir aleatorio.-");
		System.out.println("4_ Descargar.------------");
		System.out.println("5_ Cerrar.---------------");
		System.out.print("_");
		this.op=teclado.nextInt();
		Opciones(op);		
	}
	public void Opciones(int op) {
		boolean flag=false;
		while(flag) {
			switch(op) {
				case 1: System.out.println(cancionActual()); break;
				case 2: saltarCancion(); break;
				case 3: repAleatorio(); break;
				case 4: System.out.println("Esta función no está disponible"); break;
				case 5: System.out.println("Estas saliendo de la aplicación");flag=true; break;
			default: System.out.println("No es posible usar esta opción"); break;
		}
		}
	}
	public void repAleatorio() {
		Random random = new Random();
		int aleatorio=random.nextInt();
		actual=canciones[aleatorio];
	}
	public void saltarCancion() {
		saltos++;
		System.out.println("Se está reproduciendo la canción "+cancionActual());
	}
	public String cancionActual() {
		return this.actual;
	}
	public static void main(String[] args) {
		Usuario u=new Usuario();
	}
}

package FakeSporty;
import java.util.Scanner;

public class Premium extends Usuario{
	private String[] canciones= {"canción1", "canción2", "canción3", "canción4", "canción5", "canción6"}, 
			descargadas= {"","","","","",""};
	private int saltos=0, index=0;
	private String actual=canciones[saltos];
	
	public void ActualizarDatos(String actual, int saltos) {
		setActual(actual);
		setSaltos(saltos);
	}
	public void saltarCancion() {
		saltos++;
		actual=canciones[saltos];
		ActualizarDatos(actual,saltos);
		System.out.println("Se está reproduciendo "+getActual());
	}
	public void Descargar() {
		boolean aux=false;
		for(int i=0;i<descargadas.length;i++) {
			if(actual==descargadas[i]) aux=true;
		}
		if(!aux) {
			descargadas[index]=actual;
			index++;
			System.out.println("Las canciones descargadas son: ");
			for(int i=0;i<descargadas.length;i++) {
				System.out.print(descargadas[i]+" - ");
			}
			System.out.println("");
		} else System.out.println("Esta canción ya está descargada.");
		
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
		Premium u=new Premium();

		while(!flag) {
			u.ActualizarDatos(u.getActual(),u.getSaltos());
			u.setActual(u.getCanciones()[u.getSaltos()]);
			switch(op) {			
				case 1: System.out.println("Se está reproduciendo: "+u.getActual());
				u.PausarConsole(); break;
				case 2: u.saltarCancion(); u.PausarConsole();  break;
				case 3: u.repAleatorio(); u.PausarConsole();  break;
				case 4: u.Descargar(); u.PausarConsole();  break;
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


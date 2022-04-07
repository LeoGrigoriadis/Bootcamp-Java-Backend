package FakeSporty;
import java.util.Scanner;

public class Premium extends Usuario{
	private String[] canciones= {"canci�n1", "canci�n2", "canci�n3", "canci�n4", "canci�n5", "canci�n6"}, 
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
		System.out.println("Se est� reproduciendo "+getActual());
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
		} else System.out.println("Esta canci�n ya est� descargada.");
		
	}
	public static void main(String[] args) {
		int op;
		Scanner teclado = new Scanner(System.in);
		boolean flag=false;
		System.out.println("---------Spotify---------");
		System.out.println("-------------------------");
		System.out.println("1_ Canci�n actual.-------");
		System.out.println("2_ Siguiente canci�n.----");
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
				case 1: System.out.println("Se est� reproduciendo: "+u.getActual());
				u.PausarConsole(); break;
				case 2: u.saltarCancion(); u.PausarConsole();  break;
				case 3: u.repAleatorio(); u.PausarConsole();  break;
				case 4: u.Descargar(); u.PausarConsole();  break;
				case 5: System.out.println("Estas saliendo de la aplicaci�n.");flag=true; u.PausarConsole();  break;
				default: System.out.println("Esta opci�n no es v�lida."); u.PausarConsole();  break;
			}
			if(!flag) {
			System.out.println("---------Spotify---------");
			System.out.println("-------------------------");
			System.out.println("1_ Canci�n actual.-------");
			System.out.println("2_ Siguiente canci�n.----");
			System.out.println("3_ Reproducir aleatorio.-");
			System.out.println("4_ Descargar.------------");
			System.out.println("5_ Cerrar.---------------");
			System.out.print("_");
			op=teclado.nextInt();
			}
			else System.out.println("Aplicaci�n cerrada.");
		}	
	}
}


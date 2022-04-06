package FakeSporty;

public class Estandar extends Usuario{
	
	public void saltarCancion() {
		saltos++;
		if(saltos%3==0) System.out.println("Estas escuchando un anuncio...");
		System.out.println("Se está reproduciendo la canción "+cancionActual());
	}
	public void repAleatorio() {
		System.out.println("Función no disponible para usuarios estándar.");
	}
}

package FakeSporty;

public class Estandar extends Usuario{
	
	public void saltarCancion() {
		saltos++;
		if(saltos%3==0) System.out.println("Estas escuchando un anuncio...");
		System.out.println("Se est� reproduciendo la canci�n "+cancionActual());
	}
	public void repAleatorio() {
		System.out.println("Funci�n no disponible para usuarios est�ndar.");
	}
}

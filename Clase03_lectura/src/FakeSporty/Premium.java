package FakeSporty;

public class Premium extends Usuario{
	private String[] canciones= {"canci�n1", "canci�n2", "canci�n3", "canci�n4", "canci�n5", "canci�n6"}, 
			descargadas= {"","","","","",""};
	private int saltos=0, index=0;
	private String actual=canciones[saltos];
	
	
	
	public void saltarCancion() {
		saltos++;
		System.out.println("Se est� reproduciendo la canci�n "+cancionActual());
	}
	public void Descargar(String actual) {
		descargadas[index]=actual;
		index++;
	}
	
}

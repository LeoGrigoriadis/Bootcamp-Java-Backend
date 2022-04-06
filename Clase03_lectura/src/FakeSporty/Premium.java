package FakeSporty;

public class Premium extends Usuario{
	private String[] canciones= {"canción1", "canción2", "canción3", "canción4", "canción5", "canción6"}, 
			descargadas= {"","","","","",""};
	private int saltos=0, index=0;
	private String actual=canciones[saltos];
	
	
	
	public void saltarCancion() {
		saltos++;
		System.out.println("Se está reproduciendo la canción "+cancionActual());
	}
	public void Descargar(String actual) {
		descargadas[index]=actual;
		index++;
	}
	
}

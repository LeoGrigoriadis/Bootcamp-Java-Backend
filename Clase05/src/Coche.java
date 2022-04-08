
public class Coche implements imprimirDatos{
	private String matricula, marca, modelo;
	//constructor
	public Coche(String matricula, String marca, String modelo) {
		this.matricula=matricula;
		this.marca=marca;
		this.modelo=modelo;
	}
	//imprimir datos
	@Override
	public void imprimir() {
		System.out.print("matricula: "+matricula+" - marca: "+marca+" - modelo: "+modelo);
	}
}

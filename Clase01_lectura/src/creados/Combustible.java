package creados;
import java.util.Scanner;

public class Combustible {
	private int opcion,litros;
	
	public Combustible() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese el tipo de combustible(1-gasolina, 2-diesel, 3-etanol): ");
		this.opcion=teclado.nextInt();
		System.out.print("Ingrese los litros a cargar: ");
		this.litros=teclado.nextInt();
	}
	public void precios() {
		switch(opcion) {
		case 1: System.out.print("El precio total es de $"+litros*120);break;
		case 2: System.out.print("El precio total es de $"+litros*87);break;
		case 3: System.out.print("El precio total es de $"+litros*134);break;
		default: System.out.print("Tipo de combustible no válido.");
		}
	}
	public static void main(String[] args) {
		Combustible com= new Combustible();
		com.precios();
	}
}

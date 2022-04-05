package Ejercicio2;

public class Clase2 implements Interfaz{
	public void Calcular() {
		System.out.print("La suma entre 3 y 5 es "+(3+5));
	}
	public static void main(String[] args) {
		Clase2 c=new Clase2();
		c.Calcular();
	}
}

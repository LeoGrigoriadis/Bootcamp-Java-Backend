package Ejercicio2;

public class Clase1 implements Interfaz{
	public void Calcular() {
		System.out.print("La resta entre 6 y 1 es "+(6-1));
	}
	public static void main(String[] args) {
		Clase1 c=new Clase1();
		c.Calcular();
	}
}
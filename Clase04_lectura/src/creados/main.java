package creados;
import java.util.Scanner;

public class main {
	
	public static void main (String [] args) {
		int opcion=1;
		
		try (Scanner teclado = new Scanner(System.in)) {
			while(opcion!=0) {
				System.out.println( "\nIngrese la opcion de la figura que quiere calcular:  "
						+ "\n 1) Cuadrado \n 2) Rectangulo \n 3) Triangulo \n 0) Salir ");
				System.out.print("Opcion= ");
				opcion = teclado.nextInt();
				switch(opcion) {
				case 1: 
					System.out.print("Ingrese el valor del lado del Cuadrado: ");
					var lado=teclado.nextInt();
					Cuadrado cuadrado1=new Cuadrado(lado);
					System.out.println("El perimetro es= "+cuadrado1.perimetro());
					System.out.println("La superficie es= "+cuadrado1.superficie());
					break;
		
				case 2:
					System.out.print("Ingrese el valor del lado Mayor del Rectangulo: ");
					var mayor=teclado.nextInt();
					System.out.print("Ingrese el valor del lado Menor del Rectangulo: ");
					var menor=teclado.nextInt();
					Rectangulo rectangulo1=new Rectangulo(mayor,menor);
					System.out.println("El perimetro es= "+rectangulo1.perimetro());
					System.out.println("La superficie es= "+rectangulo1.superficie());
					break;
				case 3: 
					System.out.print("Ingrese el valor del lado1: ");
					var lado1=teclado.nextInt();
					System.out.print("Ingrese el valor del lado2: ");
					var lado2=teclado.nextInt();
					System.out.print("Ingrese el valor del lado3: ");
					var lado3=teclado.nextInt();
					Triangulo triangulo1=new Triangulo(lado1,lado2,lado3);
					System.out.println("El perimetro es= "+triangulo1.perimetro());
					System.out.println("La superficie es= "+triangulo1.superficie());
				}
			}
		}catch (Exception e) {
			System.out.println("No ingreso un numero");
		}
	}
}
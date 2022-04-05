package EjerciciosCreados;

import java.util.Scanner;

public class Camionetas implements Tunear{

	@Override
	public void HacerRuido() {
		System.out.print("GRUUUMMMMM");
	}
	public void ElegirColor() {
		String[] color = {"Gris","Azul", "Verde","Rosa", "Naranja"};
		int op;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Elija uno de los colores (1-Gris, 2-Azul, 3-Verde, 4-Rosa, 5-Naranja): ");
		op=teclado.nextInt();
		boolean flag=false;
		while(!flag) {
			switch(op) {
			case 1: System.out.print("El color que elegiste es el Gris."); flag=true; break;
			case 2:System.out.print("El color que elegiste es el Azul."); flag=true; break;
			case 3:System.out.print("El color que elegiste es el Verde.");flag=true; break;
			case 4:System.out.print("El color que elegiste es el Rosa.");flag=true; break;
			case 5:System.out.print("El color que elegiste es el Naranja.");flag=true; break;
				default: System.out.print("Este color no está disponible."); break;
			}
		}
	}
	public static void main(String []args) {
		Autos a=new Autos();
		int op;
		boolean flag=false;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("-------Menu-------");
		System.out.println("¿Qué desea hacer con el auto?");
		System.out.println("1- Cambiar el caño de escape y hacer ruido. ");
		System.out.println("2- Elegir color. ");
		op=teclado.nextInt();
		do {
			switch(op) {
			case 1: a.HacerRuido(); op=teclado.nextInt(); break;
			case 2: a.ElegirColor(); flag=true; break;
			default: System.out.println("Esta opción no es válida.");break;
			}
			}while(!flag);
		}
	}



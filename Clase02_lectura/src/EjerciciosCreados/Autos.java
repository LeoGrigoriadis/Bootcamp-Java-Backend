package EjerciciosCreados;

import java.util.Scanner;

public class Autos implements Tunear{
	
	
	@Override
	public void HacerRuido() {
		System.out.println("grummm.");
	}

	public void ElegirColor() {
		String[] color = {"blanco","negro", "rojo","amarillo"};
		int op;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Elija uno de los colores (1-blanco, 2-negro, 3-rojo, 4-amarillo): ");
		op=teclado.nextInt();
		boolean flag=false;
		while(!flag) {
			switch(op) {
			case 1: System.out.print("El color que elegiste es el blanco."); flag=true; break;
			case 2:System.out.print("El color que elegiste es el negro."); flag=true; break;
			case 3:System.out.print("El color que elegiste es el rojo.");flag=true; break;
			case 4:System.out.print("El color que elegiste es el amarillo.");flag=true; break;
				default: System.out.print("Este color no est� disponible."); break;
			}
		}
	}
	public static void main(String []args) {
		Autos a=new Autos();
		int op;
		boolean flag=false;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("-------Menu-------");
		System.out.println("�Qu� desea hacer con el auto?");
		System.out.println("1- Cambiar el ca�o de escape y hacer ruido. ");
		System.out.println("2- Elegir color. ");
		op=teclado.nextInt();
		do {
			switch(op) {
			case 1: a.HacerRuido(); op=teclado.nextInt(); break;
			case 2: a.ElegirColor(); flag=true; break;
			default: System.out.println("Esta opci�n no es v�lida.");break;
			}
			}while(!flag);
		}
	}


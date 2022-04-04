import java.util.Scanner;
public class Promedio {
	public static void main(String args[]) {
		int prim, seg, ter;
		double res;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Ingrese la primera nota: ");
		prim=teclado.nextInt();

		System.out.print("Ingrese la segunda nota: ");
		seg=teclado.nextInt();
		
		System.out.print("Ingrese la tercera nota: ");
		ter=teclado.nextInt();
		
		res=(prim+seg+ter)/3;
		
		if(res<10) System.out.print("Reprobado.");
		else if(res>=10 && res<=15) System.out.print("Aprobado.");
		else if(res>15) System.out.print("Eximido.");
	}	
}


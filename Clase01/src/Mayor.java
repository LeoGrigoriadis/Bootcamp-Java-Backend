import java.util.Scanner;
public class Mayor {
	public static void main(String args[]) {
		int prim, seg, ter;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Ingrese el primer valor: ");
		prim=teclado.nextInt();

		System.out.print("Ingrese el segundo valor: ");
		seg=teclado.nextInt();
		
		System.out.print("Ingrese el tercer valor: ");
		ter=teclado.nextInt();
		
		if(prim>seg && prim> ter) System.out.print("El primero es el mayor.");
		else if(seg>prim && seg> ter) System.out.print("El segundo es el mayor.");
		else if(ter>prim && ter> seg) System.out.print("El tercero es el mayor.");
	}	
}

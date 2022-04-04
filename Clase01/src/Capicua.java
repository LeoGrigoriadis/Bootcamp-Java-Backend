import java.util.Scanner;
public class Capicua {
	public static void main(String args[]) {
		
		int num;
		String cadena;
		boolean capicua=false;
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Ingrese un número: ");
		num=teclado.nextInt();
		
		cadena=""+num;
		char[] chcadena= cadena.toCharArray();
		
		for(int i=0;i<=Math.round((cadena.length()-2)/2);i++) {
			if(chcadena[i]==chcadena[cadena.length()-1-i]) capicua=true;
		}
		if(capicua) System.out.print("Es capicúa.");
		else System.out.print("No es capicúa.");
		System.out.print(capicua);
	}	
}
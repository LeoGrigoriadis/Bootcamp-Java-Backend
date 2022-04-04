import java.util.Scanner;
import java.lang.Math;
public class IMC {
	public static void main(String args[]) {
		double peso, altura, mc;
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese el peso (en kg): ");
		peso=teclado.nextFloat();

		System.out.print("Ingrese la altura (en metros): ");
		altura=teclado.nextFloat();
		
		mc=peso/(Math.pow(altura,2));
		
		if(mc<20) System.out.println("Usted se encuentra en Mal Estado");
		else if(mc>=20 && mc<22) System.out.println("Usted se encuentra en Bajo Peso");
		else if(mc>=22 && mc<25) System.out.println("Usted se encuentra en Peso Normal");
		else if(mc>=25 && mc<30) System.out.println("Usted se encuentra en Sobrepeso");
		else if(mc>=30 && mc<40) System.out.println("Usted se encuentra en Sobrepeso Crónico");
		else if(mc>40) System.out.println("Usted se encuentra Hospitalizado");
	}
}

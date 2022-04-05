import java.util.Scanner;

public class Raices {
	double a,b,c,aux,res;
	
	public void ingresar() {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Ingrese los valores de la formula (b2 – 4ac): ");

		System.out.print("Ingrese valor de a: ");
		a=teclado.nextInt();
		System.out.print("Ingrese valor de b: ");
		b=teclado.nextInt();
		System.out.print("Ingrese valor de c: ");
		c=teclado.nextInt();
	}
	
	public void calcular() {
		aux=Math.pow(b, 2);
		res=aux-(4*a*c);
		
		if(res>0) {
			System.out.print("Hay dos raices reales distintas.");
		}else if(res==0) {
			System.out.print("Hay una raiz doble.");
		}else {
			System.out.print("No hay raices reales.");
		}
		System.out.println(" Resultado= "+res);
	}	

	public static void main(String[] args) {
		Raices p2= new Raices();
		p2.ingresar();
		p2.calcular();
	}
}
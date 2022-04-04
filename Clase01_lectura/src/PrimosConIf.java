import java.util.Scanner;

public class PrimosConIf {
	private int num;
	public PrimosConIf(){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese un numero (entre 1 y 14): ");
		this.num=teclado.nextInt();
	}
	
	public void primosOno(){
		if(num==2||num==3||num==5||num==7||num==11||num==13) {
			System.out.print("Este número es primo.");
		} else System.out.print("Este número no es primo.");
	}
	
	public static void main(String[] args) {
		Primos num= new Primos();
		num.primosOno();
	}
}

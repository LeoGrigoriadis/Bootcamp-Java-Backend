import java.util.Scanner;

public class Primos {
	private int num;
	public Primos(){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese un numero (entre 1 y 14): ");
		this.num=teclado.nextInt();
	}
	
	public void primosOno(){
		switch(this.num) {
		case 2:
		case 3:
		case 5:
		case 7:
		case 11:
		case 13: System.out.print("Este número es primo.");break;
		default: System.out.print("Este número no es primo.");break;
		}
	}
	
	public static void main(String[] args) {
		Primos num= new Primos();
		num.primosOno();
	}
}

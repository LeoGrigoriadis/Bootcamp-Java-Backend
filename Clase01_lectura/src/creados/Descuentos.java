package creados;
import java.util.Scanner;

public class Descuentos {
	private double precio;
	
	public Descuentos(){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese el precio a pagar: ");
		this.precio=teclado.nextInt();
	}
	
	public int rangoPrecio() {
		int opcion=0;
		if(precio>=1000&&precio<3000) opcion=1;
		else if(precio>=3000&&precio<5000) opcion=2;
		else if(precio>=5000) opcion=3;
		
		return opcion;
	}
	public double descuentos(int opcion) {
		double total=0;
		
		switch(opcion) {
		case 1: total=precio*0.9; System.out.println("Se le aplica un 10%.") ;break;
		case 2: total=precio*0.8; System.out.println("Se le aplica un 20%.") ;break;
		case 3: total=precio*0.7; System.out.println("Se le aplica un 30%.") ;break;
		}
		return total;
	}
	public static void main(String[] args) {
		Descuentos d=new Descuentos();
		int op=d.rangoPrecio();
		System.out.println("El precio total aplicando el descuento es de $"+d.descuentos(op));
	}
}
import java.util.Arrays;
import java.util.Scanner;

public class Arreglos {
	private int num;
	private int vector[];
	
	public Arreglos() {
		vector=new int[10];
		Scanner teclado = new Scanner(System.in);
		
		for(int i=0;i<10;i++) {
			System.out.print("Ingrese un n�mero: ");
			this.num=teclado.nextInt();
			vector[i]=num;
		}
		
		Mostrar(vector);
	}
	private void Mostrar(int vector[]) {
		int mayor=0, menor=10000,pares[], par=0, impares[], impar=0, ascendente[], descendente[];
		pares= new int[10]; impares=new int[10]; descendente=new int[10]; ascendente=new int[10];
		for(int i=0;i<10;i++) {
			if(vector[i]>mayor) mayor=vector[i];
			if(vector[i]<menor) menor=vector[i];
			if(vector[i]%2==0) {pares[par]=vector[i]; par++;}
			if(vector[i]%2!=0) {impares[impar]=vector[i]; impar++;}
			ascendente[i]=vector[i];
		}
		Arrays.sort(ascendente);
		int aux=0;
		for(int i=9;i>=0;i--) {
			descendente[i]=ascendente[aux]; aux++;
		}
		System.out.println("El mayor es "+mayor+", el menor es "+menor+", los numeros pares son los siguientes: ");
		Imprimir(pares);
		System.out.println("Los impares son los siguientes: ");
		Imprimir(impares);
		System.out.println("En orden ascendente es: ");
		Imprimir(ascendente);
		System.out.println("En orden descendente es: ");
		Imprimir(descendente);
	}
	private void Imprimir(int vector[]) {
		for(int i=0;i<10;i++) {
			System.out.print(vector[i]+" - ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		Arreglos nums=new Arreglos();
	}
}

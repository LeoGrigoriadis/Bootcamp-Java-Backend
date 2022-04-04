import java.util.Scanner;

public class Triangulo {
	
	private int lado1,lado2,lado3;
	
	public Triangulo(int lado1,int lado2,int lado3){
		this.lado1=lado1;
		this.lado2=lado2;
		this.lado3=lado3;
	}
	
	public Triangulo(){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese el lado 1: ");
		this.lado1=teclado.nextInt();
		System.out.print("Ingrese el lado 2: ");
		this.lado2=teclado.nextInt();
		System.out.print("Ingrese el lado 3: ");
		this.lado3=teclado.nextInt();
	}
	
	public void tipoDeTriangulo() {
		int cont=0;
		if(lado1==lado2) cont++;
		if(lado1==lado3) cont++;
		if(lado2==lado3) cont++;
		
		switch(cont) {
		case 0: System.out.print("Escaleno"); break;
		case 1: System.out.print("Isóseles"); break;
		case 3: System.out.print("Equilátero"); break;
		}
	}

	public static void main(String[] args) {
		Triangulo t= new Triangulo();
		t.tipoDeTriangulo();
		}
	}
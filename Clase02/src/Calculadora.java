import java.util.Scanner;

public class Calculadora {
	private int a, b;
	private char op;
	public Calculadora() {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese el valor a: ");
		this.a=teclado.nextInt();
		System.out.print("Ingrese la operación a utilizar (+ - * /: ");
		this.op=teclado.next().charAt(0);
		System.out.print("Ingrese el valor b: ");
		this.b=teclado.nextInt();
		Calcular(a,op,b);
	}
	private void Calcular(int a, char op, int b) {
		switch(op) {
		case '+': System.out.print(a+b);break;
		case '-': System.out.print(a-b);break;
		case '*': System.out.print(a*b);break;
		case '/': System.out.print(a/b);break;
		default: System.out.print("Caracter no válido.");break;
		}
	}
	public static void main(String[] args) {
		Calculadora a=new Calculadora();
	}

}

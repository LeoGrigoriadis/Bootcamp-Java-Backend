package EjerciciosDía02;
import java.util.Vector;
import java.util.Scanner;

public class Ahorcado {
	private String palabraj1, palabraj2, pistaj1, pistaj2;
	private Vector j1=new Vector(2), j2=new Vector(2); //nombre, puntos;
	Scanner teclado = new Scanner(System.in);
	
	public Ahorcado() {
		System.out.print("Ingrese el nombre del jugador 1: ");
		j1.addElement(teclado.next());
		System.out.print("Ingrese el nombre del jugador 2: ");
		j2.addElement(teclado.next());
		System.out.print(j1.elementAt(0)+" comienza ingresando una palabra: ");
		palabraj1=teclado.next();
		System.out.print(j1.elementAt(0)+" agrega una pista: ");
		pistaj1=teclado.next();

		j1.addElement(0);
		j2.addElement(0);
		
		div();
			if(adivinar(palabraj1)) {
				System.out.print("Ganaste 1 punto "+j2.elementAt(0));
				j2.insertElementAt(1, 1);
			}else {
				System.out.print("Ganaste 1 punto "+j1.elementAt(0));
				j1.insertElementAt(1, 1);;
			}
	}
	private boolean adivinar(String p1) {
		char[] caracteres;
		char letra;
		char[] letrasAcertadas;
		boolean acerto=false;
		int trys=6, cont=0;
		caracteres=new char[trys];
		letrasAcertadas=new char[p1.length()];
		
		while(trys>0&&acerto==false) {
			System.out.println("Ingrese una letra: ");
			letra=teclado.next().charAt(0);
			
			if(comprobarRepeticion(letra, caracteres)) {
				System.out.println("La letra es repetida.");
			}else if(comprobarAcertadas(letra, p1)) {
				
				//me falta la parte donde muestra la palabra con las letras 
				//que va adivinando y le permite ganar al jugador 2.
			}
			else {
				caracteres[cont]=letra;
				cont++; trys--;
			}
			mostrarIngresadas(caracteres, trys);
		}
		return acerto;
	}
	private boolean comprobarAcertadas(char letra, String p1) {
		boolean flag=false;
		char[] palabra=p1.toCharArray();
		for(int i=0;i<p1.length();i++) {
			if(palabra[i]==letra) {
				flag=true;
			}
		}
		return flag;
	}
	private void mostrarIngresadas(char[] car, int trys) {
		System.out.println("Intentos restantes: "+trys);
		for(int i=0;i<car.length;i++) {
			System.out.print(car[i]+" - ");
		}
		System.out.println("");
	}
	private boolean comprobarRepeticion(char letra, char[]caracter) {
		boolean flag=false;
		for(int i=0;i<caracter.length-1;i++) {
			if(caracter[i]==letra) {
				flag=true;
			}
		}
		return flag;
	}
	private void div() {
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
		System.out.println("----------------------");
	}
	public static void main(String[] args) {
		Ahorcado a=new Ahorcado();
	}
}
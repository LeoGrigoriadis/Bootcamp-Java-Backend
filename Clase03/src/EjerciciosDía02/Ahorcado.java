package EjerciciosDía02;
import java.util.Vector;
import java.util.Scanner;

public class Ahorcado {
	private String j1, j2, jactual, palabra, pista;
	private int p1=0,p2=0, turno=0;
	Scanner teclado = new Scanner(System.in);
	
	public Ahorcado() {
		
		System.out.print("Ingrese el nombre del jugador 1: ");
		j1=teclado.next();
		System.out.print("Ingrese el nombre del jugador 2: ");
		j2=teclado.next();
		jactual=j1;
			for(int i=0;i<5;i++) {
				System.out.print(jactual+" comienza ingresando una palabra: ");
				palabra=teclado.next();
				System.out.print(jactual+" agrega una pista: ");
				pista=teclado.next();

				div();
					if(adivinar(palabra)&&jactual==j1) {
						p2++;
						System.out.println("\n¡Ganaste 1 punto "+j2+"!");
						jactual=j1;
					}else if(!adivinar(palabra)&&jactual==j1){
						p1++;
						System.out.println("\n¡Ganaste 1 punto "+j1+"!");
						jactual=j1;
					}else if(!adivinar(palabra)&&jactual==j2){
						p2++;
						System.out.println("\n¡Ganaste 1 punto "+j2+"!");
						jactual=j2;
					}else if(adivinar(palabra)&&jactual==j2){
						p1++;
						System.out.println("\n¡Ganaste 1 punto "+j1+"!");
						jactual=j1;
					}
					System.out.println("El puntaje actual es: "+j1+"= "+p1+" - "+j2+"= "+p2);
				}
	}
	private boolean adivinar(String p1) {
		char[] caracteres;
		char letra;
		char[] letrasAcertadas;
		boolean acerto=false;
		int trys=6, cont=0, acertadas=0;
		caracteres=new char[trys];
		letrasAcertadas=new char[p1.length()];
		
		while(trys>0&&acerto==false) {
			System.out.println("Ingrese una letra: ");
			letra=teclado.next().charAt(0);
			
			if(comprobarRepeticion(letra, caracteres)) {
				System.out.println("La letra es repetida.");
			}else if(comprobarAcertadas(letra, p1, letrasAcertadas)) {
				if(!comprobarRepeticion(letra, letrasAcertadas)) {
					letrasAcertadas[acertadas]=letra;
					acertadas++;
				}
				if(acertadas==p1.length()) acerto=true;
			}
			else {
				caracteres[cont]=letra;
				cont++; trys--;
			}
			
			System.out.println("Letras acertadas: ");
			mostrarAcertadas(letrasAcertadas);
			System.out.println("Intentos restantes: "+trys);
			System.out.println("Letras incorrectas: ");
			mostrarIngresadas(caracteres);
		}
		return acerto;
	}
	private void mostrarAcertadas(char[] car) {
		for(int i=0;i<car.length;i++) {
			System.out.print(car[i]+" - ");
		}
		System.out.println("");
	}
	private boolean comprobarAcertadas(char letra, String p1, char[]letrasAcertadas) {
		boolean flag=false;
		char[] palabra=p1.toCharArray();
		for(int i=0;i<p1.length();i++) {
			if(palabra[i]==letra) {
				flag=true;
			}
		}
		return flag;
	}
	private void mostrarIngresadas(char[] car) {
		for(int i=0;i<car.length;i++) {
			System.out.print(car[i]+" - ");
		}
		System.out.println("");
	}
	private boolean comprobarRepeticion(char letra, char[]caracter) {
		boolean flag=false;
		for(int i=0;i<caracter.length;i++) {
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
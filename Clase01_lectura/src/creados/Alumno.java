package creados;
import java.util.Scanner;

public class Alumno {
	
	private int edad;
	private int nota;
	
	public Alumno(){
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese la edad del Alumno: ");
		this.edad=teclado.nextInt();
		
		System.out.print("Ingrese la nota del Alumno: ");
		this.nota=teclado.nextInt();
	}
	public void admision() {
		boolean aprobado=false;
		
		if(edad>=18 && nota>=7) System.out.print("Este alumno cumple los requisitos."); 
		else if(edad>=18 && nota<7) System.out.print("Este alumno no aprobó el examen de ingreso.");
		else if(edad<18 && nota>=7) System.out.print("Este alumno no cumple con la edad requerida.");
		else System.out.print("Este alumno no cumple ningún requisito.");
	}
	
	public static void main(String[] args) {
		Alumno alumno= new Alumno();
		alumno.admision();	
	}
}
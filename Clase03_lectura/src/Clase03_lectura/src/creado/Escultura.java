package creado;
import java.util.Scanner;

public class Escultura extends Obra {
	
	public Escultura(String fechaIngreso, String nombre, String fechaOriginal, int ultimoMantenimiento, boolean estado){
		super(fechaIngreso, nombre, fechaOriginal, ultimoMantenimiento, estado);
		setFechaIngreso(fechaIngreso);
		setNombre(nombre);
		setFechaOriginal(fechaOriginal);
		setUltimoMantenimiento(ultimoMantenimiento);
		setEstado(estado);
		realizarMantenimiento(estado);
	}
	
	public void realizarMantenimiento(boolean estado) {
		char aux;
		boolean flag=false;
		Scanner teclado = new Scanner(System.in);

		if(estado) {
		while(!flag) {
				System.out.println("¿Quiere continuar con la restauración? (y/n): ");
				aux=teclado.next().charAt(0);
					if(aux=='y') {
						System.out.println("Restauración realizada.");
						setEstado(true);
						setUltimoMantenimiento(0);
						flag=true;
					}else if(aux=='n') {
						flag=true;
						System.out.println("La restauración se hará en otro momento.");
					}else {
						System.out.println("Esta opción no es válida.");
					}
			}
		}
		
		if(getUltimoMantenimiento()>60) {
			System.out.println("A esta escultura se le realizará un mantenimiento de esctructura tipo 1");
		}
		else if(getUltimoMantenimiento()>120) {
			System.out.println("A esta escultura se le realizará un mantenimiento de esctructura tipo 2");
		}
		else if(getUltimoMantenimiento()>180) {
			System.out.println("A esta escultura se le realizará un mantenimiento de esctructura tipo 3");
		}
		
		mostrar();
	}
	public void mostrar() {
		System.out.println("El nombre de la escultura es: "+getNombre());
		System.out.println("La fecha en la que ingresó esta escultura es: "+getFechaIngreso());
		System.out.println("La escultura fue creada en la fecha: "+getFechaOriginal());
		System.out.println("Se le realizó un mantenimiento general hace "+getFechaOriginal()+" días.");
	}
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String fechaIngreso, nombreEscultura, fechaOriginal; 
		int ultimoMantenimiento, estado;
		boolean aux=true, flag=false;
		
		System.out.println("Introduzca la fecha de ingreso de la escultura: ");
		fechaIngreso=teclado.next();
		System.out.println("Introduzca el nombre: ");
		nombreEscultura=teclado.next();
		System.out.println("Introduzca la fecha original: ");
		fechaOriginal=teclado.next();
		System.out.println("Introduzca hace cuantos días se realizó el último mantenimiento: ");
		ultimoMantenimiento=teclado.nextInt();
		
		while(!flag) {
			System.out.println("Introduzca el estado de la escultura (1.necesita restauración, 2.está restaurada): ");
			estado=teclado.nextInt();
			switch(estado) {
			default: System.out.print("Introduzca un número válido.");break;
			case 1: flag=true; break;
			case 2: aux=false; flag=true; break;
			}
		}
		Escultura e=new Escultura(fechaIngreso, nombreEscultura, fechaOriginal, ultimoMantenimiento, aux);
	}
}

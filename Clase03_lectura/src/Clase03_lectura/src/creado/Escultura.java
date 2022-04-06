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
				System.out.println("�Quiere continuar con la restauraci�n? (y/n): ");
				aux=teclado.next().charAt(0);
					if(aux=='y') {
						System.out.println("Restauraci�n realizada.");
						setEstado(true);
						setUltimoMantenimiento(0);
						flag=true;
					}else if(aux=='n') {
						flag=true;
						System.out.println("La restauraci�n se har� en otro momento.");
					}else {
						System.out.println("Esta opci�n no es v�lida.");
					}
			}
		}
		
		if(getUltimoMantenimiento()>60) {
			System.out.println("A esta escultura se le realizar� un mantenimiento de esctructura tipo 1");
		}
		else if(getUltimoMantenimiento()>120) {
			System.out.println("A esta escultura se le realizar� un mantenimiento de esctructura tipo 2");
		}
		else if(getUltimoMantenimiento()>180) {
			System.out.println("A esta escultura se le realizar� un mantenimiento de esctructura tipo 3");
		}
		
		mostrar();
	}
	public void mostrar() {
		System.out.println("El nombre de la escultura es: "+getNombre());
		System.out.println("La fecha en la que ingres� esta escultura es: "+getFechaIngreso());
		System.out.println("La escultura fue creada en la fecha: "+getFechaOriginal());
		System.out.println("Se le realiz� un mantenimiento general hace "+getFechaOriginal()+" d�as.");
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
		System.out.println("Introduzca hace cuantos d�as se realiz� el �ltimo mantenimiento: ");
		ultimoMantenimiento=teclado.nextInt();
		
		while(!flag) {
			System.out.println("Introduzca el estado de la escultura (1.necesita restauraci�n, 2.est� restaurada): ");
			estado=teclado.nextInt();
			switch(estado) {
			default: System.out.print("Introduzca un n�mero v�lido.");break;
			case 1: flag=true; break;
			case 2: aux=false; flag=true; break;
			}
		}
		Escultura e=new Escultura(fechaIngreso, nombreEscultura, fechaOriginal, ultimoMantenimiento, aux);
	}
}

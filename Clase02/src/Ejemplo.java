import java.util.Scanner;
public class Ejemplo {

	public static void main(String[] args) {
		Scanner sn=new Scanner(System.in);
		
		/*Boolean salir=false;
		int opcion;
		
		while(!salir) {
			System.out.println("Menu");
			System.out.println("1-accion");
			System.out.println("2-accion");
			System.out.println("3-accion");
			System.out.println("4-salir");
			System.out.println("Ingrese la opción del Menu: ");
			opcion=sn.nextInt();
			
			switch(opcion) {
			default: System.out.println("Ingrese una opción entre 1 - 4");break;
			case 1: System.out.println("1");break;
			case 2: System.out.println("2");break;
			case 3: System.out.println("3");break;
			case 4: salir=true; break;
			}
		}
		*/
		int ejemplo[];
		ejemplo= new int[10];
		for(int i=0;i<10;i++) {
			System.out.println("Posicion "+i+": ");
			ejemplo[i]=sn.nextInt();
		}
	}
}

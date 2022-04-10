package Classes;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		//variables locales
		boolean flag=false, esCliente; int op;
		String username, password;
		//objetos
		Scanner teclado = new Scanner(System.in);
		Conexion a= new ServicioBaseDeDatos();
		AccesoADatos access=new AccesoADatos(a);
		//interfaz grafica
		System.out.println("------------------------------------------------");
		System.out.println("------ Bienvenido al sistema del Hospital ------");
		System.out.println("------------------------------------------------\n");
		while(!flag) {
			System.out.println("1-Iniciar Sesión.");
			System.out.println("2-Crear cuenta.");
			System.out.println("3-Mostrar tabla de usuarios.");
			System.out.println("4-Salir.");
			op=teclado.nextInt();
			switch(op) {
				case 1: 
					System.out.println("Ingrese su nombre de usuario: ");
					username=teclado.next();
					System.out.println("Ingrese su contraseña: ");
					password=teclado.next();
					System.out.println("¿Usted es cliente(0) o Empleado(1)?: ");
					op=teclado.nextInt();
					if(op==0) {
						esCliente=true;
						Usuario u=new Cliente(username, password, esCliente);
						if(access.UserRegistrado(u)&&u.getEsCliente()) System.out.println("Inició sesión correctamente. Cliente");
						else if(access.UserRegistrado(u)&&u.getEsCliente()==false) System.out.println("Inició sesión correctamente. Empleado");
						else System.out.println("No se pudo iniciar sesión. Revise su nombre de usuario o contraseña.");
					}
					else if(op==1) {
						esCliente=false;
						Usuario u=new Empleado(username, password, esCliente);
						if(access.UserRegistrado(u)&&u.getEsCliente()) System.out.println("Inició sesión correctamente. Cliente");
						else if(access.UserRegistrado(u)&&u.getEsCliente()==false) System.out.println("Inició sesión correctamente. Empleado");
						else System.out.println("No se pudo iniciar sesión. Revise su nombre de usuario o contraseña.");
					}
					break;
				case 2: 
					System.out.println("Ingrese su nombre de usuario: ");
					username=teclado.next();
					System.out.println("Ingrese su contraseña: ");
					password=teclado.next();
					System.out.println("¿Usted es cliente(0) o Empleado(1)?: ");
					op=teclado.nextInt();
					if(op==0) {
						esCliente=true;
						Usuario u=new Cliente(username,password, esCliente);
						access.altaUser(u);
					}
					else if(op==1) {
						esCliente=false;
						Usuario u=new Empleado(username,password, esCliente);
						access.altaUser(u);
					}
					break;
				case 3: access.getUsers(); break;
				case 4: System.out.println("Saliste del programa..."); flag=true; break;
				default: System.out.println("ERROR: Caracter invalido."); break;
			}
			System.out.println("\n");
		}
	}
}
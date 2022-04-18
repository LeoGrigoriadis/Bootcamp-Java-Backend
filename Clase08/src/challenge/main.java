package challenge;
import java.sql.*;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		//objetos de conexión
		Conexion conectar = new Conexion();
		Connection conectado=null;
		conectado=conectar.conexionDB();
		
		int op=1;
		Scanner teclado = new Scanner(System.in);
		while(op!=0) {
			System.out.println( "\nElija una opción en la siguiente linea: "
				+ "\n 1- Insertar datos. \n 2- Mostrar datos. \n 0- Salir.");
			System.out.print("Opcion= ");
			op = teclado.nextInt();
			switch(op) {
				case 1: InsertClass insert=new InsertClass(conectado);break;
				case 2:	SelectClass sel=new SelectClass(conectado);break;
				case 0: System.out.print("Finalizando programa...");break;
				default: System.out.print("Esta opción no es válida."); break;
			}
		}
	}
}
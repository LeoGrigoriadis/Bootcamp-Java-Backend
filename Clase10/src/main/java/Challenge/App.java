package Challenge;

import java.util.Scanner;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {

	public static void main(String[] args) {
		
    	Conexion con= new Conexion();
    	MongoDatabase conect=con.conexiondb();
    	MongoCollection<Document> userData=conect.getCollection("Collection");
    	
    	int op=1;
		Scanner teclado = new Scanner(System.in);
		while(op!=0) {
			System.out.println( "\n\nElija una opción: "
				+ "\n 1- Registrar datos. \n 2- Consultar datos. \n 3- Eliminar datos. \n 4- Listado general. \n 0- Salir.");
			System.out.print("Opcion= ");
			op = teclado.nextInt();
			switch(op) {
				case 1: 
					Registrar r=new Registrar();
					r.guardar(userData);
					break;
				case 2:	
					Consultar c=new Consultar();
					c.mostrar(userData);
					break;
				case 3: 
					Eliminar e=new Eliminar(userData);
					break;
				case 4: 
					Listar l=new Listar();
					l.mostrar(userData);
					break;
				case 0: System.out.print("Finalizando programa..."); break;
				default: System.out.print("Esta opción no es válida."); break;
			}
		}
	}
}
package Challenge;
import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class Registrar extends Model{

	public Registrar() {
		
		System.out.print("Nombre: ");
		setNombre(teclado.next());
		System.out.print("Apellido: ");
		setApellido(teclado.next());
		System.out.print("Dni: ");
		setDni(teclado.nextInt());
		System.out.print("Direccion: ");
		setDireccion(teclado.next());
	}
	
	public void guardar(MongoCollection<Document> userData) {
		Integer dni= getDni();
		FindIterable<Document> resultado = userData.find().filter(new Document("dni", dni));
		if(resultado.first()==null) {
			Document lista=new Document("nombre",getNombre()).append("apellido", getApellido()).append("dni", getDni()).append("direccion", getDireccion());
			userData.insertOne(lista);
			System.out.println("Registro realizado.");
		}else System.out.println("Dni ya registrado.");
	}
}
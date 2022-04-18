package Challenge;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public class Eliminar extends Model{

	public Eliminar(MongoCollection<Document> userData) {
		System.out.print("\nDni de la consulta: ");
		setDni(teclado.nextInt());
		userData.deleteOne(new Document("dni", getDni()));
		System.out.println("Eliminación realizada.");
	}
}
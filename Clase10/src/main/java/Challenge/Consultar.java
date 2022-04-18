package Challenge;

import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class Consultar extends Model{

	public Consultar() {
		System.out.print("\nDni de la consulta: ");
		setDni(teclado.nextInt());
	}
	public void mostrar(MongoCollection<Document> userData) {
		Integer dni= getDni();
		FindIterable<Document> resultado = userData.find().filter(new Document("dni", dni));
		System.out.println(resultado.first().toJson());
	}
}
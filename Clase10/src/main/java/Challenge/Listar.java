package Challenge;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class Listar extends Model{
	public Listar() { }
	public void mostrar(MongoCollection<Document> userData) {
		MongoCursor<Document> resultado=userData.find().iterator();
		while(resultado.hasNext()) {
    		System.out.println(resultado.next().toJson());
    	}
	}
}
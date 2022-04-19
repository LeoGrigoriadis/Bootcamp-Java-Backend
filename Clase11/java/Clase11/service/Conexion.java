
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Conexion {
	public Conexion() {	}
	public MongoDatabase conexiondb() {
		MongoClient mongoClient=MongoClients.create();
    	List<Document> database=mongoClient.listDatabases().into(new ArrayList<Document>());
    	database.forEach(db->System.out.println(db.toJson()));
    	MongoDatabase BaseDatos=mongoClient.getDatabase("apiRest");
    	return BaseDatos;
	}
}
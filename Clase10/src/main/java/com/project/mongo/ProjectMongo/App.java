package com.project.mongo.ProjectMongo;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class App 
{
    public static void main( String[] args )
    {
    	MongoClient mongoClient=MongoClients.create();
    	List<Document> database=mongoClient.listDatabases().into(new ArrayList<Document>());
    	database.forEach(db->System.out.println(db.toJson()));
    	//tomar una Base de datos local
    	MongoDatabase BaseDatos=mongoClient.getDatabase("Collections");

//    	MongoCollection<Document> userData2=BaseDatos.getCollection("Collection2");
    	//crear colección
//    	BaseDatos.createCollection("Collection2");
    	//insertar datos
//    	Document listadInsert=new Document("nombre","Juan").append("apellido", "Mendez");
//    	userData2.insertOne(listadInsert);
//    	userData2.findOneAndDelete(listadInsert);
    	
    	//insertar varios datos
//    	userDate2.insertMany();
    	MongoCollection<Document> userData=BaseDatos.getCollection("Collection");
    	//seleccionar el primer valor
    	BasicDBObject filtro = new BasicDBObject();
//		Document resultado=userData.find(("dni", 1234));
//    	MongoCursor<Document> result=userData2.find().iterator();
//    	Document result2=userData2.find().first();
//    	//mostrar varios datos
//    	while(result.hasNext()) {
//    		System.out.println(result.next().toJson());
//    	}
    	//mostrar un dato datos
//    	System.out.println(resultado.toJson());
    }
}

package Ejercicio.Clase19_lectura.Model.Concrets;

import Ejercicio.Clase19_lectura.Model.User;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserMongo extends User {
}

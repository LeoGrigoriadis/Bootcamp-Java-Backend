package Ejercicio.Clase19_lectura.Repository;

import Ejercicio.Clase19_lectura.Model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("mon")
public interface UserRepositoryMongo extends MongoRepository<User, Long> {
}

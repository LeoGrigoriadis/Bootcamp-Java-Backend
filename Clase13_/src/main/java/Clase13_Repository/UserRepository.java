package Clase13_Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import Clase13_Model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	//metodo para buscar un user específico
	List<User>findByDni(int dni);
}

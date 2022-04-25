package Login.Port;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import Login.Model.Usuario;

public interface UsuarioPort extends MongoRepository<Usuario, String>{
	List<Usuario>findByEmail(String email);
}
package Arquitectura.Port;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import Arquitectura.Model.Libro;

public interface LibroPort extends MongoRepository<Libro, String>{
	List<Libro>findByNombre(String nombre);
}

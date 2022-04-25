package Login.Port;

import org.springframework.data.mongodb.repository.MongoRepository;

import Login.Model.Producto;

public interface ProductoPort extends MongoRepository<Producto, String>{ }

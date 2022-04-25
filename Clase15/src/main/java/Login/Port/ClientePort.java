package Login.Port;

import org.springframework.data.mongodb.repository.MongoRepository;

import Login.Model.Cliente;

public interface ClientePort extends MongoRepository<Cliente, String>{ }
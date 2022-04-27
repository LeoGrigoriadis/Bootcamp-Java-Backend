package main.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import main.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	User findByUsername(String username);
	User findByEmail(String email);
	User findByPassword(String password);
}
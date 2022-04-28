package Main.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Main.Model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	List<User> findByEmail(String email);
}
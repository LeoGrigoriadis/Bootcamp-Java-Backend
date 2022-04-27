package main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.Model.User;
import main.Repository.UserRepository;

@Service
public class UserSerivce {
	
	@Autowired
	UserRepository ur;

	public List<User> getAllUser() {
		List<User> users=ur.findAll();
		return users;
	}

	public User getUser(String email) {
		User user=ur.findByEmail(email);
		return user;
	}

	public boolean saveUser(User newUser) {
		User user=ur.findByEmail(newUser.getEmail());
		User userTwo=ur.findByPassword(newUser.getPassword());
		if(user==null&&userTwo==null) { ur.save(newUser); return true; }
		return false;
	}

	public boolean updateUser(User newUser) {
		User user=ur.findByEmail(newUser.getEmail());
		if(user==null) return false;
		ur.delete(user); 
		ur.save(newUser);
		return true; 
	}

	public User deleteUser(String email) {
		User user=ur.findByEmail(email);
		if(user==null) return null;
		else ur.delete(user);
		return user;
	}
}

package Main.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main.Model.User;
import Main.Repository.UserRepository;

@Service
public class UserSerivce {
	
	@Autowired
	private UserRepository ur;
	
	//Get all users
	public List<User> getAllUsers() { return ur.findAll(); }
	
	//Get an user
	public List<User> getUser(String email) { 
		List<User> user=new ArrayList<User>();
		ur.findByEmail(email).forEach(user::add);
		return user; }
}
package main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.Model.User;
import main.Service.UserSerivce;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserSerivce us;
		
	@GetMapping()
	public ResponseEntity<List<User>> getAllUsers() {
		try {
			List<User> allUsers=us.getAllUser();
			if(allUsers.isEmpty()) return ResponseEntity.status(400).body(null);
			return ResponseEntity.status(200).body(allUsers);
		}catch(Exception e) { return ResponseEntity.status(500).body(null); }
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<User> getUser(@PathVariable("email") String email) {
		try {
			User user=us.getUser(email);
			if(user==null) return ResponseEntity.status(400).body(null);
			return ResponseEntity.status(200).body(user);
		}catch(Exception e) { return ResponseEntity.status(500).body(null); }
	}
	
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User newUser) {
		try {
			if(newUser.getEmail()==null||newUser.getPassword()==null||newUser.getUsername()==null) return ResponseEntity.status(400).body(null);
			if(!us.saveUser(newUser)) return ResponseEntity.status(400).body(null);
			return ResponseEntity.status(201).body(newUser);
		}catch(Exception e) { return ResponseEntity.status(500).body(null); }
	}
	
	@PutMapping("/{email}")
	public ResponseEntity<User> updateUser(@PathVariable("email") String email, @RequestBody User newUser){
		try {
			newUser.setEmail(email);
			if(!us.updateUser(newUser)) return ResponseEntity.status(400).body(null);
			return ResponseEntity.status(200).body(newUser);
		}catch(Exception e) { return ResponseEntity.status(500).body(null); }
	}
	
	@DeleteMapping("{email}")
	public ResponseEntity<User> deleteUser(@PathVariable("email") String email){
		try {
			User user=us.deleteUser(email);
			if(user==null) return ResponseEntity.status(400).body(null);
			return ResponseEntity.status(200).body(user);
		}catch(Exception e) { return ResponseEntity.status(500).body(null); }
	}
}

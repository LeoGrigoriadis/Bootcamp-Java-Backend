package Clase13_.Clase13_Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Clase13_.Clase13_Repository.UserRepository;
import Clase13_.Clase13_Model.User;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository ur;
	
	@GetMapping("/mostrar/todos")
	public ResponseEntity<List<User>> getAll(){
		try {
			List<User> users=new ArrayList<User>();
			ur.findAll().forEach(users::add);
			if(users.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
			return new ResponseEntity<>(users,HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/mostrar/{dni}")
	public ResponseEntity<List<User>> getOneById(@PathVariable("dni") int dni){
		try {
			List<User> users=new ArrayList<User>();
			ur.findByDni(dni).forEach(users::add);
			if(users.isEmpty()) { return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
			return new ResponseEntity<>(users,HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/agregar")	
	public ResponseEntity<User> addOne(@RequestBody User users){
		try {
			User user=ur.save(new User(users.getNombre(), users.getApellido(), users.getDireccion(), users.getDni()));
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/eliminar/{dni}")
	public ResponseEntity<User> deleteOne(@PathVariable("dni") int dni){
		try {
			List<User> users=new ArrayList<User>();
			ur.findByDni(dni).forEach(users::add);
			User user= users.get(0);
			ur.delete(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
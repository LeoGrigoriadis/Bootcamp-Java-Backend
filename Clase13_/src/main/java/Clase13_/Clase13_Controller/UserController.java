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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Clase13_.Clase13_Repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import Clase13_.Clase13_Model.User;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository ur;
	
	@ApiOperation(value="Listar todos los usuarios", notes="Mostramos todos los usuarios"
			+ "registrados en la base de datos.")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Operación exitosa."),
			@ApiResponse(code=400, message="Operación fallida. Sin contenido."),
			@ApiResponse(code=500, message="Error interno de servidor.")
		})
	@GetMapping("/mostrar/todos")
	public ResponseEntity<List<User>> getAll(){
		try {
			List<User> users=new ArrayList<User>();
			ur.findAll().forEach(users::add);
			if(users.isEmpty()) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
			return new ResponseEntity<>(users,HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation(value="Filtrar un usuario por DNI", notes="Filtramos un usuario"
			+ "mediante el dni ingresado por header.")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Operación exitosa."),
			@ApiResponse(code=400, message="Operación fallida. Sin contenido."),
			@ApiResponse(code=500, message="Error interno de servidor.")
		})
	@GetMapping("/mostrar/{dni}")
	public ResponseEntity<List<User>> getOneById(@PathVariable("dni") int dni){
		try {
			List<User> users=new ArrayList<User>();
			ur.findByDni(dni).forEach(users::add);
			if(users.isEmpty()) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
			return new ResponseEntity<>(users,HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation(value="Agregar un usuario", notes="Agregamos un usuario mediante"
			+ "los datos ingresados por el body.")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Operación exitosa."),
			@ApiResponse(code=400, message="Operación fallida. Sin contenido."),
			@ApiResponse(code=500, message="Error interno de servidor.")
		})
	@PostMapping("/agregar")	
	public ResponseEntity<User> addOne(@RequestBody User users){
		try {
			List<User> nUser=new ArrayList<User>();
			ur.findByDni(users.getDni()).forEach(nUser::add);
			if(nUser.isEmpty()) {
				User user=ur.save(new User(users.getNombre(), users.getApellido(), users.getDireccion(), users.getDni()));
				return new ResponseEntity<>(user, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@ApiOperation(value="Actualizar un usuario", notes="Actualizamos un usuario mediante los datos ingresados por"
			+ "el body. Es necesario que el Id este especificado.")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Operación exitosa."),
			@ApiResponse(code=400, message="Operación fallida. Sin contenido."),
			@ApiResponse(code=500, message="Error interno de servidor.")
		})
	@PutMapping("/actualizar/{dni}")
	public ResponseEntity<User> updateOne(@RequestBody User users,@PathVariable("dni") int dni){
		try {
			List<User> nUser=new ArrayList<User>();
			ur.findByDni(dni).forEach(nUser::add);
			if(!nUser.isEmpty()) { users.setDni(dni); ur.save(users); 
				return new ResponseEntity<>(users, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value="Eliminar un usuario filtrado por DNI", notes="Eliminamos un usuario mediante"
			+ "su DNI, el cual es ingresado mediante el header.")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Operación exitosa."),
			@ApiResponse(code=400, message="Operación fallida. Sin contenido."),
			@ApiResponse(code=500, message="Error interno de servidor.")
		})
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
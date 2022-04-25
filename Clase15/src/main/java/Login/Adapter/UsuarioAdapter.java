package Login.Adapter;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import Login.Model.Usuario;
import Login.Port.UsuarioPort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuarios")
public class UsuarioAdapter {
	
	@Autowired
	UsuarioPort userPort;
	
	@ApiOperation(value="Listar todos los usuarios", notes="Mostramos todos los usuarios"
			+ "registrados en la base de datos.")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Operación exitosa."),
			@ApiResponse(code=400, message="Operación fallida. Sin contenido."),
			@ApiResponse(code=500, message="Error interno de servidor.")
		})
	@GetMapping("/mostrar/todos")
	public ResponseEntity<List<Usuario>> getAll(){
		try {
			List<Usuario> usuarios=new ArrayList<Usuario>();
			userPort.findAll().forEach(usuarios::add);
			if(usuarios.isEmpty()) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
			return new ResponseEntity<>(usuarios,HttpStatus.OK);
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
	@GetMapping("/mostrar/{email}")
	public ResponseEntity<List<Usuario>> getOneById(@Valid @PathVariable("email") String email){
		try {
			List<Usuario> users=new ArrayList<Usuario>();
			userPort.findByEmail(email).forEach(users::add);
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
	public ResponseEntity<Usuario> addOne(@Valid @RequestBody Usuario usuario){
		try {
			List<Usuario> nUsuario=new ArrayList<Usuario>();
			userPort.findByEmail(usuario.getEmail()).forEach(nUsuario::add);
			if(nUsuario.isEmpty()) {
				Usuario user=userPort.save(new Usuario(usuario.getNombre(), usuario.getApellido(), usuario.getEmail(), usuario.getPassword()));
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
	@PutMapping("/actualizar/{email}")
	public ResponseEntity<Usuario> updateOne(@RequestBody Usuario usuario,@PathVariable("email") String email){
		try {
			List<Usuario> nUsuario=new ArrayList<Usuario>();
			userPort.findByEmail(email).forEach(nUsuario::add);
			if(!nUsuario.isEmpty()) { usuario.setEmail(email); userPort.save(usuario); 
				return new ResponseEntity<>(usuario, HttpStatus.OK);
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
	@DeleteMapping("/eliminar/{email}")
	public ResponseEntity<Usuario> deleteOne(@PathVariable("email") String email){
		try {
			List<Usuario> usuario=new ArrayList<Usuario>();
			userPort.findByEmail(email).forEach(usuario::add);
			Usuario nUsuario= usuario.get(0);
			userPort.delete(nUsuario);
			return new ResponseEntity<>(nUsuario, HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

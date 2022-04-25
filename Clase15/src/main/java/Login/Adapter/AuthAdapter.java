package Login.Adapter;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Login.Message.MessageResponse;
import Login.Model.Usuario;
import Login.Port.UsuarioPort;
import Login.Request.RequestLogin;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/Auth")
public class AuthAdapter {
	@Autowired
	UsuarioPort userPort;
//	@Autowired
//	PasswordEncoder encoder;
	
	@ApiOperation(value="Logear usuario", notes="Recibe un email y una password, y comprueba si estos datos están "
			+ "registrados en la base de datos.")
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Email no registrado."),
			@ApiResponse(code=200, message="Inicio de sesión exitoso."),
			@ApiResponse(code=200, message="La contraseña no corresponde al email ingresado."),
			@ApiResponse(code=500, message="Error interno de servidor.")
		})
	@PostMapping("/login")
	public  ResponseEntity<?> login(@Valid @RequestBody RequestLogin login){
		try {
			List<Usuario> user=new ArrayList<Usuario>();
			userPort.findByEmail(login.getEmail()).forEach(user::add);
			Usuario password = user.get(0);
			if(user.isEmpty()) { return ResponseEntity.badRequest().body(new MessageResponse("Error: El email no está registrado.")); }
			else { 
				if(login.getEmail().equals(password.getPassword())) {
					return ResponseEntity.badRequest().body(new MessageResponse("Inicio de sesión exitoso."));
				}
			}
			return ResponseEntity.badRequest().body(new MessageResponse("Error: La contraseña no corresponde al email ingresado."));
		}catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
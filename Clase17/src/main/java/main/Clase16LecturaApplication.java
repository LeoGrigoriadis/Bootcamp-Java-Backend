package main;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import main.Model.User;
//import main.Repository.UserRepository;

@EnableAutoConfiguration
@OpenAPIDefinition
@EnableWebMvc
@SpringBootApplication
public class Clase16LecturaApplication {
//	@Autowired
//	private PasswordEncoder pe;
	
	public static void main(String[] args) {
		SpringApplication.run(Clase16LecturaApplication.class, args);
	}
//	@Bean
//	protected CommandLineRunner init(final UserRepository ur) {
//		return args->{
//				String pass = pe.encode("123");
//				User user= new User("leo", "leo@gmail.com", pass);
//				ur.save(user); 
//		};
//	}
}
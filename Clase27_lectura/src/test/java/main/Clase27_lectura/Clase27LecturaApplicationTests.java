package main.Clase27_lectura;

import main.Clase27_lectura.Model.MyUser;
import main.Clase27_lectura.Model.Role;
import main.Clase27_lectura.Service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class Clase27LecturaApplicationTests {

	@Autowired
	private UserService uA;

	@Autowired
	PasswordEncoder pE;

	@Test
	void contextLoads() {
		MyUser user = new MyUser();

		user.setUsername("admin");
		user.setPassword(pE.encode("123"));
		Role role = new Role(1,"ADMIN");
		user.setRole(role);

		uA.save(user);
		MyUser r = uA.findByUsername(user.getUsername());
		Assert.assertTrue(r.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}

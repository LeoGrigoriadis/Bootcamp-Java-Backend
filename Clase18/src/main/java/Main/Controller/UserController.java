package Main.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import Main.Service.UserSerivce;
import Main.Model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserSerivce us;
		
	@GetMapping
	public String getAllUsers(Model model) {
		//model.addAttribute("users", us.getAllUsers());
		ArrayList<User> users=new ArrayList<User>();
		users.add(new User("as","asd","ASd","AD"));
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("/{email}")
	public String getUser(@PathVariable("email") String email, Model model) {
		model.addAttribute("users", us.getUser(email));
		if(us.getUser(email).isEmpty()) return "Error-400";
		return "index";
	}
}

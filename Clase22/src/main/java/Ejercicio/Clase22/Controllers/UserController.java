package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.UserService;
import Ejercicio.Clase22.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService us;

    @GetMapping
    public String findAllUsers(Model model){
        model.addAttribute("users", us.getAllUsers());
        return "UserIndex";
    }

    @GetMapping("/find")
    public String findClient(Model model,@Valid @RequestParam long id){
        model.addAttribute("users", us.findById(id));
        return "UserIndex";
    }

    @GetMapping("/create")
    public String saveUserForm(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "UserCreate";
    }

    @PostMapping("/create")
    public String saveUser(@Valid @ModelAttribute("user") User user, RedirectAttributes redirect){
        us.save(user);
        redirect.addFlashAttribute("message", "Datos insertados correctamente." )
                .addFlashAttribute("class", "success");
        return "redirect:/users";
    }
}

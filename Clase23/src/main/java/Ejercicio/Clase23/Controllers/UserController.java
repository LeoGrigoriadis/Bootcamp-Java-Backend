package Ejercicio.Clase23.Controllers;

import Ejercicio.Clase23.Controllers.Service.UserService;
import Ejercicio.Clase23.Models.User;
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
    public String getUsers(Model model){
        model.addAttribute("users", us.getAllUsers());
        return "UserIndex";
    }

    @GetMapping("/find")
    public String getUser(Model model,@Valid @RequestParam long dni){
        model.addAttribute("users", us.getOneUser(dni));
        return "UserIndex";
    }

    @GetMapping("/create")
    public String showCreateClient(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "UserCreate";
    }

    @PostMapping("/create")
    public String saveClient(@Valid @ModelAttribute("user") User user, RedirectAttributes redirect){
        us.saveUser(user);
        redirect.addFlashAttribute("message", "User creado." )
                .addFlashAttribute("class", "success");
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String showUpdateClient(Model model,@PathVariable("id") long id){
        User user= us.findById(id);
        System.out.print(user);
        model.addAttribute("user", user);
        return "UserUpdate";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@Valid @ModelAttribute("user") User user, @PathVariable long id, RedirectAttributes redirect){
        user.setId(id);
        us.updateUser(user);
        redirect.addFlashAttribute("message", "User actualizado." )
                .addFlashAttribute("class", "success");
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteClient(@PathVariable("id") long id, RedirectAttributes redirect){
        us.deleteUser(id);
        redirect.addFlashAttribute("message", "User eliminado.")
                .addFlashAttribute("class", "danger");
        return "redirect:/users";
    }
}

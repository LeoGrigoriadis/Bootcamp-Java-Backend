package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.UserService;
import Ejercicio.Clase22.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService us;

    @GetMapping("/{pagNum}/{pagSize}")
    public String findAllUsers(Model model, @PathVariable int pagNum, @PathVariable int pagSize){
        Page<User> users=us.getAllUsers(pagNum,pagSize);
        List<User> users1=users.getContent();
        model.addAttribute("users", users1);
        model.addAttribute("totalPage", users.getTotalPages());
        model.addAttribute("totalElements", users.getTotalElements());
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        return "UserIndex";
    }
    @GetMapping("/{pagNum}/{pagSize}/{sortField}/{sortDir}")
    public String findAllUsers(Model model, @PathVariable int pagNum, @PathVariable int pagSize, @PathVariable String sortField, @PathVariable String sortDir){
        Page<User> users=us.getAllUsers(pagNum,pagSize,sortField,sortDir);
        List<User> users1=users.getContent();
        model.addAttribute("users", users1);
        model.addAttribute("totalPage", users.getTotalPages());
        model.addAttribute("totalElements", users.getTotalElements());
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir.equals("asc")?"desc":"asc");
        return "UserIndex";
    }

    @GetMapping("/find/{pagNum}/{pagSize}")
    public String findClient(Model model,@Valid @RequestParam long id, RedirectAttributes redirect, @PathVariable int pagNum, @PathVariable int pagSize){
        try {
            model.addAttribute("users", us.findById(id));
            model.addAttribute("numPageActual", pagNum);
            model.addAttribute("numSize", pagSize);
            return "UserIndex";
        }catch(Exception e) {
            model.addAttribute("numPageActual", pagNum);
            model.addAttribute("numSize", pagSize);
            redirect.addFlashAttribute("message", "Id no encontrado." )
                    .addFlashAttribute("class", "danger");
            return "redirect:/users/1/10";
        }
    }

    @GetMapping("/create")
    public String saveUserForm(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "UserCreate";
    }

    @PostMapping("/create")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "UserCreate";
        }
        us.save(user);
        redirect.addFlashAttribute("message", "Datos insertados correctamente." )
                .addFlashAttribute("class", "success");
        return "redirect:/users/1/10";
    }

    /*public void crear50Users(){
        User user=new User();
        String email= "User@gmail.com";
        String userNombre= "UserName";
        String nombre= "User";
        String contra="password1234";
        for(int i=50;i<=100;i++) {
            us.save(new User(0,userNombre+i,contra+i,nombre+i,i+email));
        }
    }*/
}

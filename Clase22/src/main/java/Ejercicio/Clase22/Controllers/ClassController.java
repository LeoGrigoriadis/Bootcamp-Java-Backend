package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.ClassService;
import Ejercicio.Clase22.Models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    ClassService cs;

    @GetMapping
    public String findAllClasses(Model model){
        model.addAttribute("classes", cs.getAllClasses());
        return "ClassIndex";
    }

    @GetMapping("/find")
    public String findClass(Model model,@Valid @RequestParam long code){
        model.addAttribute("classes", cs.findById(code));
        return "ClassIndex";
    }

    @GetMapping("/create")
    public String saveUserForm(Model model){
        Class clas=new Class();
        model.addAttribute("clas", clas);
        return "ClassCreate";
    }

    @PostMapping("/create")
    public String saveClass(@Valid @ModelAttribute("clas") Class clas, RedirectAttributes redirect){
        cs.save(clas);
        redirect.addFlashAttribute("message", "Datos insertados correctamente." )
                .addFlashAttribute("class", "success");
        return "redirect:/classes";
    }
}

package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.ClassService;
import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    ClassService cs;

    @GetMapping("/{pagNum}/{pagSize}")
    public String findAllUsers(Model model, @PathVariable int pagNum, @PathVariable int pagSize){
        Page<Class> classes=cs.getAllClasses(pagNum,pagSize);
        List<Class> classesFinal=classes.getContent();
        model.addAttribute("classes", classesFinal);
        model.addAttribute("totalPage", classes.getTotalPages());
        model.addAttribute("totalElements", classes.getTotalElements());
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        return "ClassIndex";
    }

    @GetMapping("/find/{pagNum}/{pagSize}")
    public String findClass(Model model,@Valid @RequestParam long code, @PathVariable int pagNum, @PathVariable int pagSize){
        model.addAttribute("classes", cs.findById(code));
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
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
        return "redirect:/classes/1/10";
    }
}

package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.ClassService;
import Ejercicio.Clase22.Controllers.Service.RegistrationService;
import Ejercicio.Clase22.Controllers.Service.StudentService;
import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegistrationService rs;
    @Autowired
    StudentService ss;
    @Autowired
    ClassService cs;

    @GetMapping("/add/{id}/{code}")
    public String save(@PathVariable long id,@PathVariable long code, RedirectAttributes redirect){
        Student student=ss.findById(id);
        Class clas=cs.findById(code);
        try{
            rs.save(student, clas);
            redirect.addFlashAttribute("message", "Materia añadida al estudiante." )
                    .addFlashAttribute("class", "success");
            return "redirect:/students/addClass/"+student.getId();
        }catch (Exception e){
            redirect.addFlashAttribute("message", "Algo ha salido mal." )
                    .addFlashAttribute("class", "danger");
            return "redirect:/students/addClass/"+student.getId();
        }
    }
}

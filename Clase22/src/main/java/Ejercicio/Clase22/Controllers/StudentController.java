package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Repository.RegistrationRepository;
import Ejercicio.Clase22.Controllers.Service.ClassService;
import Ejercicio.Clase22.Controllers.Service.RegistrationService;
import Ejercicio.Clase22.Controllers.Service.StudentService;
import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Registration;
import Ejercicio.Clase22.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService ss;

    @GetMapping
    public String findAllStudents(Model model){
        model.addAttribute("students", ss.getAllStudents());
        return "StudentIndex";
    }

    @GetMapping("/find")
    public String findStudent(Model model,@Valid @RequestParam long dni){
        model.addAttribute("students", ss.findByDni(dni));
        return "StudentIndex";
    }

    @GetMapping("/create")
    public String saveStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student", student);
        return "StudentCreate";
    }

    @PostMapping("/create")
    public String saveClass(@Valid @ModelAttribute("student") Student student, RedirectAttributes redirect){
        ss.save(student);
        redirect.addFlashAttribute("message", "Datos insertados correctamente." )
                .addFlashAttribute("class", "success");
        return "redirect:/students";
    }
    @Autowired
    ClassService cs;
    @Autowired
    RegistrationService rs;

    @GetMapping("/addClass/{id}")
    public String addClassForm(Model model, @PathVariable long id){
        Student student= ss.findById(id);
        ArrayList<Registration> registrations=rs.findAllId(id);
        ArrayList<Class> clas=cs.getAllClasses();

        for (Registration reg: registrations){
            if(reg.getIdStudent().getId()==id){
                for(int i=0; i<=clas.toArray().length-1;i++){
                    if(reg.getCodeClass().getCode()== clas.get(i).getCode()){
                        clas.remove(i);
                    }
                }
            }
        }
        System.out.println(clas);
        model.addAttribute("student", student);
        model.addAttribute("classes", clas);
        return "AddClass";
    }

    @GetMapping("/view/{id}")
    public String viewForm(Model model, @PathVariable long id){
        ArrayList<Registration> registrations=rs.findAllId(id);
        ArrayList<Class> classes=new ArrayList<>();
        for (Registration regis : registrations ){
            classes.add(cs.findById(regis.getCodeClass().getCode()));
        }
        model.addAttribute("student", ss.findById(id));
        model.addAttribute("classes", classes);
        return "viewClasses";
    }
}

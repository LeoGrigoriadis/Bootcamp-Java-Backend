package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.ClassService;
import Ejercicio.Clase22.Controllers.Service.RegistrationService;
import Ejercicio.Clase22.Controllers.Service.StudentService;
import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Registration;
import Ejercicio.Clase22.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService ss;

    @GetMapping("/{pagNum}/{pagSize}")
    public String findAllStudents(Model model, @PathVariable int pagNum, @PathVariable int pagSize){
        Page<Student> student=ss.getAllStudents(pagNum,pagSize);
        List<Student> students=student.getContent();
        model.addAttribute("students", students);
        model.addAttribute("totalPage", student.getTotalPages());
        model.addAttribute("totalElements", student.getTotalElements());
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        return "StudentIndex";
    }

    @GetMapping("/find/{pagNum}/{pagSize}")
    public String findStudent(Model model,@Valid @RequestParam long dni, @PathVariable int pagNum, @PathVariable int pagSize){
        model.addAttribute("students", ss.findByDni(dni));
        model.addAttribute("numPageActual", pagNum);
        model.addAttribute("numSize", pagSize);
        return "StudentIndex";
    }

    @GetMapping("/create")
    public String saveStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student", student);
        return "StudentCreate";
    }

    @PostMapping("/create")
    public String saveClass(@Valid @ModelAttribute("student") Student student, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "UserCreate";
        }
        ss.save(student);
        redirect.addFlashAttribute("message", "Datos insertados correctamente." )
                .addFlashAttribute("class", "success");
        return "redirect:/students/1/10";
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

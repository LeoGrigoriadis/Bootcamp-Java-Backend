package Ejercicio.Clase22.Controllers;

import Ejercicio.Clase22.Controllers.Service.StudentService;
import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        model.addAttribute("students", ss.findById(dni));
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
}

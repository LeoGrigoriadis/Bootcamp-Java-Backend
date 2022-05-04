package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.StudentRepository;
import Ejercicio.Clase22.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    StudentRepository sr;

    public ArrayList<Student> getAllStudents() { return (ArrayList<Student>) sr.findAll(); }
    public Student findById(long dni) { return sr.findByDni(dni); }
    public void save(Student student) { sr.save(student); }
}

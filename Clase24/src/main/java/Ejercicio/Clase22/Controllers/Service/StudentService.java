package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.StudentRepository;
import Ejercicio.Clase22.Models.Student;
import Ejercicio.Clase22.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    StudentRepository sr;
    public Page<Student> getAllStudents(int pagNum, int pagSize) {
        Pageable cantidad= PageRequest.of(pagNum-1, pagSize);
        return sr.findAll(cantidad);
    }
    public Student findByDni(long dni) { return sr.findByDni(dni); }
    public void save(Student student) { sr.save(student); }
    public Student findById(long id) { return sr.findById(id); }
}

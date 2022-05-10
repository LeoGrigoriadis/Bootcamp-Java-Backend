package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.StudentRepository;
import Ejercicio.Clase22.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.springframework.core.OrderComparator.sort;

@Service
public class StudentService {
    @Autowired
    StudentRepository sr;
    public Page<Student> getAllStudents(int pagNum, int pagSize) {
        Pageable cantidad= PageRequest.of(pagNum-1, pagSize);
        return sr.findAll(cantidad);
    }
    public ArrayList<Student> getAllStudents(){ return (ArrayList<Student>) sr.findAll();}
    public Student findByDni(long dni) { return sr.findByDni(dni); }
    public void save(Student student) { sr.save(student); }
    public Student findById(long id) { return sr.findById(id); }
    public List<Student> findAll() { return sr.findAll(); }
    public ArrayList<Student> getAllStudentsOrder() {
        return (ArrayList<Student>) sr.findAll(Sort.by(Sort.Direction.ASC, "firstname"));
    }
}

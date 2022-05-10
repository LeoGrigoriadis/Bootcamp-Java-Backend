package main.Clase25.Controllers.Service;

import main.Clase25.Controllers.Repository.StudentRepository;
import main.Clase25.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    StudentRepository sr;
    public Page<Student> getAll(int actual, int size) {
        Pageable cant = PageRequest.of(actual,size);
        return sr.findAll(cant); }
    public Page<Student> getAllBySort(int actual, int size, String sort, String sortField){
        Pageable cant= PageRequest.of(actual, size, sort.equals("asc")? Sort.by(sortField).ascending():Sort.by(sortField).descending());
        return sr.findAll(cant);
    }
    public Student getByFirstname(String firstname) { return sr.findByFirstname(firstname); }

    public Student getByLastname(String lastname) { return sr.findByLastname(lastname); }
}

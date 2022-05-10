package main.Clase25.Controllers;

import main.Clase25.Controllers.Service.StudentService;
import main.Clase25.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService ss;
    @GetMapping(value = "/{actual}/{size}",  produces = { "application/json", "application/xml" })
    public ResponseEntity<List<Student>> getAll(@PathVariable int actual,@PathVariable int size){
        try{
            Page<Student> students=ss.getAll(actual, size);
            List<Student> students1=students.getContent();
            if(students.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(students1, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{firstname}")
    public ResponseEntity<Student> getByFirstname(@PathVariable String firstname){
        try{
            Student students=ss.getByFirstname(firstname);
            if(students==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{lastname}")
    public ResponseEntity<Student> getByLastname(@PathVariable String lastname){
        try{
            Student students=ss.getByLastname(lastname);
            if(students==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(students, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{actual}/{size}/{sort}/{sortField}")
    public ResponseEntity<List<Student>> getSortAsc(@PathVariable int actual,@PathVariable int size,@PathVariable String sort,@PathVariable String sortField){
        try{
            Page<Student> students=ss.getAllBySort(actual, size, sort, sortField);
            List<Student> students1=students.getContent();
            if(students.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(students1, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

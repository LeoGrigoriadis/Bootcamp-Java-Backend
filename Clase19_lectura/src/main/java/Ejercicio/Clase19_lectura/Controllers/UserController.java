package Ejercicio.Clase19_lectura.Controllers;

import Ejercicio.Clase19_lectura.Model.User;
import Ejercicio.Clase19_lectura.Service.Concrets.UserServiceSQL;
import Ejercicio.Clase19_lectura.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceSQL us;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            List<User> users = us.getAllUsers();
            if (users.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{dni]")
    public ResponseEntity<?> getOneUser(@PathVariable("dni") long dni) {
        try {
            User user = us.getOneUser(dni);
            if (user==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping
    public ResponseEntity<User> addOne(@RequestBody User user){
        try {
            if(us.saveUser(user)!=null) {
                return new ResponseEntity<>(user, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{dni}")
    public ResponseEntity<User> updateOne(@RequestBody User user, @PathVariable("dni") long dni){
        try {
            if(us.saveUser(user)!=null) {
                return new ResponseEntity<>(user, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{dni}")
    public ResponseEntity<?> deleteOne(@PathVariable("dni") long dni){
        try {
            User user=us.deleteOne(dni);
            if(user!=null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch( Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
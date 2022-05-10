package main.Clase25.Controllers;

import main.Clase25.Controllers.Service.UserService;
import main.Clase25.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService us;
    @GetMapping("/all")
    public ResponseEntity<ArrayList<User>> getAll(){
        try{
            ArrayList<User> users=us.getAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable String username){
        try{
            User user=us.getByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save/{type}")
    public ResponseEntity<User> setUser(@RequestBody User user, @PathVariable("type") String type){
        try{
            us.save(user, type);
            if(user!=null)return new ResponseEntity<>(user, HttpStatus.OK);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        try{
            us.update(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id){
        try{
            User user=us.getById(id);
            us.delete(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

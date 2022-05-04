package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.UserRepository;
import Ejercicio.Clase22.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository ur;
    public ArrayList<User> getAllUsers() { return (ArrayList<User>) ur.findAll(); }
    public User findById(long id) { return ur.findById(id); }
    public void save(User user) { ur.save(user); }


}

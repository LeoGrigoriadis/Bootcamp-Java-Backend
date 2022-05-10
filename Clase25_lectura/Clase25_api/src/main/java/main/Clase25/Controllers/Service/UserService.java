package main.Clase25.Controllers.Service;

import main.Clase25.Controllers.Repository.RoleRepository;
import main.Clase25.Controllers.Repository.UserRepository;
import main.Clase25.Model.Role;
import main.Clase25.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    UserRepository ur;
    @Autowired
    RoleRepository rr;
    public ArrayList<User> getAll() { return (ArrayList<User>) ur.findAll(); }
    public User getByUsername(String username) { return ur.getByUsername(username); }
    public void save(User user, String type) {
        if(user!=null&&(type=="PREMIUM"||type=="STANDARD")) {
        Role userRole = rr.findByRole(type);
        user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
        ur.save(user);
        }
    }
    public void update(User user) {
        User nUser=new User();
        nUser.setPassword(user.getPassword());
        nUser.setUsername(user.getUsername());
        nUser.setId(user.getId());
        ur.save(nUser);
    }
    public User getById(long id) { return ur.getById(id); }
    public void delete(User user) { ur.delete(user); }
}

package Ejercicio.Clase19_lectura.Service.Concrets;

import Ejercicio.Clase19_lectura.Model.User;
import Ejercicio.Clase19_lectura.Repository.UserRepositorySQL;
import Ejercicio.Clase19_lectura.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceSQL{
    @Autowired
    UserRepositorySQL ur;
    public List<User> getAllUsers() {
        return ur.findAll();
    }
    public User getOneUser(long dni) {
        return ur.findByDni(dni);
    }
    public User saveUser(User user) {
        return ur.save(user);
    }
    public User deleteOne(long dni) {
        User user=ur.findByDni(dni);
        return user;
    }
}

package Ejercicio.Clase19_lectura.Service;

import Ejercicio.Clase19_lectura.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    User getOneUser(long dni);
    User saveUser(User user);
    User deleteOne(long dni);
}

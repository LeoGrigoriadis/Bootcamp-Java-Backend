package Ejercicio.Clase19_lectura.Service.Concrets;

import Ejercicio.Clase19_lectura.Model.User;
import Ejercicio.Clase19_lectura.Service.IUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("mon")
public class UserServiceMongo implements IUserService {

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getOneUser(long dni) {
        return null;
    }
    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User deleteOne(long dni) {
        return null;
    }
}

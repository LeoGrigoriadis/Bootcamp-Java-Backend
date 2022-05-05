package Ejercicio.Clase23.Controllers.Service;

import Ejercicio.Clase23.Models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class UserService {
    String url = "http://localhost:8081/users/";
    RestTemplate restTemplate = new RestTemplate();
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = restTemplate.getForObject(url, ArrayList.class);
        return users; }
    public User getOneUser(long dni) {
        User user = restTemplate.getForObject(url+"dni/"+dni, User.class);
        return user; }
    public User findById(long id) { User user = restTemplate.getForObject(url+id, User.class);
        return user; }
    public void saveUser(User user) { restTemplate.postForObject(url, user, User.class); }
    public void updateUser(User user) { restTemplate.put(url, user, User.class); }
    public void deleteUser(long id) { restTemplate.delete(url+id); }

}

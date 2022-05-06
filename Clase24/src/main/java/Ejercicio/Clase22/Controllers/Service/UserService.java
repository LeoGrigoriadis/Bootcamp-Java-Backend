package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.UserRepository;
import Ejercicio.Clase22.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository ur;
    public Page<User> getAllUsers(int pagNum, int pagSize) {
        Pageable cantidad= PageRequest.of(pagNum-1, pagSize);
        return ur.findAll(cantidad);
    }
    public Page<User> getAllUsers(int pagNum, int pagSize,String sortField, String sortDir) {
        Pageable cantidad= PageRequest.of(pagNum-1, pagSize,
                sortDir.equals("asc")? Sort.by(sortField).ascending():Sort.by(sortField).descending());
        return ur.findAll(cantidad);
    }
    public User findById(long id) { return ur.findById(id); }
    public void save(User user) { ur.save(user); }


}

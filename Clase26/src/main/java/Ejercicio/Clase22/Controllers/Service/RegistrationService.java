package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.ClassRepository;
import Ejercicio.Clase22.Controllers.Repository.RegistrationRepository;
import Ejercicio.Clase22.Controllers.Repository.StudentRepository;
import Ejercicio.Clase22.Models.Class;
import Ejercicio.Clase22.Models.Registration;
import Ejercicio.Clase22.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegistrationService {
    @Autowired
    RegistrationRepository rr;

    public void save(Student student, Class clas) {
        Registration reg=new Registration();
        reg.setCodeClass(clas);
        reg.setIdStudent(student);
        rr.save(reg);
    }

    public ArrayList<Registration> findAllId(long id) { return rr.findAllById(id); }
}

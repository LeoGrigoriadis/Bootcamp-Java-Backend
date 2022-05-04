package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.ClassRepository;
import Ejercicio.Clase22.Models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;

@Service
public class ClassService {
    @Autowired
    ClassRepository cr;

    public ArrayList<Class> getAllClasses() { return (ArrayList<Class>) cr.findAll(); }
    public Class findById(long code) { return cr.findById(code); }
    public void save(Class clas) { cr.save(clas); }
}

package Ejercicio.Clase22.Controllers.Service;

import Ejercicio.Clase22.Controllers.Repository.ClassRepository;
import Ejercicio.Clase22.Models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassRepository cr;

    public List<Class> getAllClasses() { return cr.findAll(); }
    public Page<Class> getAllClasses(int pagNum, int pagSize) {
        Pageable cantidad= PageRequest.of(pagNum-1, pagSize);
        return cr.findAll(cantidad);
    }
    public Class findById(long code) { return cr.findById(code); }
    public void save(Class clas) { cr.save(clas); }
}

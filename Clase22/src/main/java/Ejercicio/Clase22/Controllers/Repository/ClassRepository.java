package Ejercicio.Clase22.Controllers.Repository;

import Ejercicio.Clase22.Models.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Long> {
     Class findById(long code);
}

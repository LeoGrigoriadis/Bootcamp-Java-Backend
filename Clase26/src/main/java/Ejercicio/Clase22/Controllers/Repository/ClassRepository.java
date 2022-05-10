package Ejercicio.Clase22.Controllers.Repository;

import Ejercicio.Clase22.Models.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
     Class findById(long code);
     Page<Class> findAll(Pageable cantidad);
}

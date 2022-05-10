package Ejercicio.Clase22.Controllers.Repository;

import Ejercicio.Clase22.Models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    @Query(value="SELECT * from registration where id_student=:id", nativeQuery = true)
    ArrayList<Registration> findAllById(@Param("id") long id);
}
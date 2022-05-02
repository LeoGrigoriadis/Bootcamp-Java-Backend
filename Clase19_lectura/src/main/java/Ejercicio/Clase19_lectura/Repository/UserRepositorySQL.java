package Ejercicio.Clase19_lectura.Repository;

import Ejercicio.Clase19_lectura.Model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("sql")
public interface UserRepositorySQL extends JpaRepository<User, Long> {
    User findByDni(long dni);
}
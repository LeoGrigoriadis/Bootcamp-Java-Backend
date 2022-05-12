package main.Clase27_lectura.Repository;

import main.Clase27_lectura.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);
    @Query(value = "SELECT name FROM my_user INNER JOIN role ON my_user.role_id=role.id WHERE username=:username", nativeQuery = true)
    String getRole(@Param("username") String username);
}

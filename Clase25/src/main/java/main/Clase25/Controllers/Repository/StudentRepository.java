package main.Clase25.Controllers.Repository;

import main.Clase25.Model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findAll(Pageable cant);
    Student findByFirstname(String firstname);
    Student findByLastname(String lastname);
}

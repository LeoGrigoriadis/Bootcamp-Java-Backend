package main.Clase25.Controllers.Repository;

import main.Clase25.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String type);
}

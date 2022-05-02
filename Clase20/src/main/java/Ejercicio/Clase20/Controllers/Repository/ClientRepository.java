package Ejercicio.Clase20.Controllers.Repository;

import Ejercicio.Clase20.Models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findById(long id);
    Client findByDni(long dni);
}

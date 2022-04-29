package Ejercicio.Clase19.Controllers.Repository;

import Ejercicio.Clase19.Models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findById(long id);
}

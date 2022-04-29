package Dia18.EjerciciosPropios18.controllers.Repositories;

import Dia18.EjerciciosPropios18.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByDni(String dni);
}

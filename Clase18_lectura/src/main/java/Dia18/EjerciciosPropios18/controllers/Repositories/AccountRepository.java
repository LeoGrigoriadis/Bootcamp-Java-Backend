package Dia18.EjerciciosPropios18.controllers.Repositories;

import Dia18.EjerciciosPropios18.models.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AccountRepository extends CrudRepository<Account, Long> {
   public ArrayList<Account> findByClientId(long id);
}

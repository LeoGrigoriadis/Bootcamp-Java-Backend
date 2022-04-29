package Dia18.EjerciciosPropios18.controllers.services;

import Dia18.EjerciciosPropios18.controllers.Repositories.AccountRepository;

import Dia18.EjerciciosPropios18.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountService {

    @Autowired
    AccountRepository aR;

    public ArrayList<Account> getAllAccounts()
    {
        return (ArrayList<Account>) aR.findAll();
    }

    public void saveAccount(Account account)
    {
        aR.save(account);
    }

    public ArrayList<Account> findByClientId(long id)
    {
        return aR.findByClientId(id);
    }
}

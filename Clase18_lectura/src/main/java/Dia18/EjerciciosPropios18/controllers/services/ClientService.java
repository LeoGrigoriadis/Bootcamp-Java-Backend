package Dia18.EjerciciosPropios18.controllers.services;

import Dia18.EjerciciosPropios18.controllers.Repositories.ClientRepository;
import Dia18.EjerciciosPropios18.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ClientService {
    @Autowired
    ClientRepository cR;

    public ArrayList<Client> getAllClients()
    {
        return (ArrayList<Client>) cR.findAll();
    }

    public void saveClient(Client client)
    {
        cR.save(client);
    }

    public Client findByDni(String dni)
    {
        return cR.findByDni(dni);
    }
}

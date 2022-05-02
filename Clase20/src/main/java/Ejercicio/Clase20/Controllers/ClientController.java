package Ejercicio.Clase20.Controllers;

import Ejercicio.Clase20.Controllers.Service.ClientService;
import Ejercicio.Clase20.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService cs;

    @GetMapping()
    public String getClients(Model model){
        model.addAttribute("clients", cs.getAllClients());
        return "ClientsIndex";
    }

    @GetMapping("/create")
    public String showCreateClient(Model model){
        Client client=new Client();
        model.addAttribute("client", client);
        return "ClientCreate";
    }

    @PostMapping("/create")
    public String saveClient(@ModelAttribute("client") Client client){
        cs.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/update/{id}")
    public String showUpdateClient(Model model, @PathVariable("id") long id){
        Client client=new Client();
        client.setId(id);
        model.addAttribute("client", client);
        return "ClientUpdate";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteClient( @PathVariable("id") long id){
        Client client=new Client();
        cs.deleteClient(id);
        return "redirect:/clients";
    }
}

package Dia18.EjerciciosPropios18.controllers;

import Dia18.EjerciciosPropios18.models.Client;
import Dia18.EjerciciosPropios18.controllers.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService cS;

    @GetMapping()
    public String getUsers(Model model) {

        model.addAttribute("clients", cS.getAllClients());
        return "ClientTemplates/ClientIndex";
    }

    @GetMapping("/create")
    public String showFormUser(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "ClientTemplates/ClientCreate";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("client") Client client) {
        cS.saveClient(client);
        return "redirect:/clients";
    }

}

package Ejercicio.Clase21.Controllers;

import Ejercicio.Clase21.Controllers.Service.ClientService;
import Ejercicio.Clase21.Models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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

    @GetMapping("/find")
    public String getClients(Model model,@Valid @RequestParam long dni){
        model.addAttribute("clients", cs.getOneUser(dni));
        return "ClientsIndex";
    }

    @GetMapping("/create")
    public String showCreateClient(Model model){
        Client client=new Client();
        model.addAttribute("client", client);
        return "ClientCreate";
    }

    @PostMapping("/create")
    public String saveClient(@Valid @ModelAttribute("client") Client client, RedirectAttributes redirect){
        cs.saveClient(client);
        redirect.addFlashAttribute("message", "Datos insertados correctamente." )
                .addFlashAttribute("class", "success");
        return "redirect:/clients";
    }

    @GetMapping("/update/{id}")
    public String showUpdateClient(Model model,@PathVariable("id") long id){
        Client client=cs.findById(id);
        model.addAttribute("client", client);
        return "ClientUpdate";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteClient(@PathVariable("id") long id, RedirectAttributes redirect){
        Client client=new Client();
        cs.deleteClient(id);
        redirect.addFlashAttribute("message", "Cliente eliminado.")
                .addFlashAttribute("class", "danger");
        return "redirect:/clients";
    }
}

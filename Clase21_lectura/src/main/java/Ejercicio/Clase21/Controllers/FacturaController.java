package Ejercicio.Clase21.Controllers;

import Ejercicio.Clase21.Controllers.Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/facturas")
public class FacturaController {
    @Autowired
    FacturaService fs;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("facturas", fs.getAll());
        return "FacturasIndex";
    }

    @GetMapping("/montoMayor")
    public String getMontoMayor(Model model){
        model.addAttribute("facturas", fs.getHighest());
        return "FacturasIndex";
    }

    @GetMapping("/find")
    public String getClients(Model model,@RequestParam long dni){
        model.addAttribute("facturas", fs.getByDni(dni));
        return "FacturasIndex";
    }


}

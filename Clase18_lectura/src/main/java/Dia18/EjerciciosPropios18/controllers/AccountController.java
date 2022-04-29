package Dia18.EjerciciosPropios18.controllers;

import Dia18.EjerciciosPropios18.models.Account;
import Dia18.EjerciciosPropios18.controllers.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController {
@Autowired
    AccountService aS;
    @GetMapping()
    public String getAccounts(Model model) {

        model.addAttribute("accounts", aS.getAllAccounts());
        return "AccountTemplates/AccountIndex";
    }
    @GetMapping("/filterAccounts/{id}")
    public String filterAccounts(Model model, @PathVariable("id") long id)
    {
        model.addAttribute("accounts", aS.findByClientId(id));
        return  "AccountTemplates/AccountIndex";
    }

    @GetMapping("/create/{clientId}")
    public String showFormAccounts(@PathVariable("clientId") long clientId,  Model model) {
        Account account = new Account();
        account.setClientId(clientId);
        model.addAttribute("account", account);
        return "AccountTemplates/AccountCreate";
    }

    @PostMapping("/create")
    public String saveAccount(@ModelAttribute("account") Account account) {
        aS.saveAccount(account);
        return "redirect:/clients";
    }
}

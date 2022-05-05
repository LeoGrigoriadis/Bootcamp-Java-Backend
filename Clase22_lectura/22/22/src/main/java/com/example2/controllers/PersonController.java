/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example2.controllers;

import com.example2.Model.Person;
import com.example2.controllers.Services.PersonService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public String getAllPersons(Model model) {
        model.addAttribute("personas", personService.getAllPersons());
        return "PersonIndex";
    }

    @GetMapping("/create")
    public String saveUserForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "PersonCreate";
    }

    @PostMapping("/create")
    public String saveUser(@ModelAttribute("person") Person person, RedirectAttributes redirect) {
        personService.savePerson(person);
        redirect.addFlashAttribute("message", "Datos insertados correctamente.")
                .addFlashAttribute("class", "success");
        return "redirect:/person/all";
    }

    @GetMapping("/find")
    public String findPerson(Model model, @RequestParam long id) {
        personService.findById(id);
        model.addAttribute("personas", personService.findById(id));
        return "PersonasIndex";
    }
    /*
     * 
     * @GetMapping("/{id}")
     * public Optional<Person> getPersonByID(@PathVariable("id")Long id){
     * return personService.getPersonByID(id);
     * }
     * 
     * @GetMapping("/query")
     * public ArrayList<Person> getPersonByApellido(@RequestParam("apellido") String
     * apellido) {
     * return personService.getPersonByApellido(apellido);
     * }
     * 
     * @DeleteMapping("/{id}")
     * public String removePerson(@PathVariable("id") Long id) {
     * if (personService.removePerson(id)) {
     * return "Se elimino a la persona de id " + id + " correctamente";
     * } else {
     * return "La persona no existe o no pudo ser eliminada";
     * }
     * }
     */
}


package ar.com.portfoliobracciale.api.controllers;

import ar.com.portfoliobracciale.api.models.Person;
import ar.com.portfoliobracciale.api.services.PersonService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    PersonService personService;
    
    @GetMapping("/all")
    public ArrayList<Person> getAllPersons(){
        return personService.getAllPersons();
    }
    
    @PostMapping("")
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person);
    }
    @GetMapping("/{id}")
    public Optional<Person> getPersonByID(@PathVariable("id")Long id){
        return personService.getPersonByID(id);
    }
    @GetMapping("/query")
    public ArrayList<Person> getPersonByApellido( @RequestParam("apellido") String apellido){
        return personService.getPersonByApellido(apellido);
    }
    @DeleteMapping("/{id}")
    public String removePerson(@PathVariable("id") Long id){
        if (personService.removePerson(id)){
            return "Se elimino a la persona de id " +id+" correctamente";
        } else {
            return "La persona no existe o no pudo ser eliminada";
            }
    }
}

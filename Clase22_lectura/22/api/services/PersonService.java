package ar.com.portfoliobracciale.api.services;

import ar.com.portfoliobracciale.api.models.Person;

import ar.com.portfoliobracciale.api.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    PersonRepository personRepository;
    
    public ArrayList<Person> getAllPersons(){
        return (ArrayList<Person>) personRepository.findAll();
    }
    
    public Person savePerson (Person persona){
        return personRepository.save(persona);
    }

    public Optional<Person> getPersonByID(Long id) {
        return personRepository.findById(id);
    }

    public ArrayList<Person> getPersonByApellido(String apellido) {
        return personRepository.findByApellido(apellido);
    }

    public boolean removePerson(Long id) {
        try {
            personRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Person findById(Long personId) {
        return personRepository.findById(personId).get();
    }
    
    
}

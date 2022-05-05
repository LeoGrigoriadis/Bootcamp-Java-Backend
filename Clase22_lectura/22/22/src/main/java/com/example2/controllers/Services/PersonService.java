/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example2.controllers.Services;

import com.example2.Model.Person;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    public ArrayList<Person> getAllPersons() {
        String url = "http://localhost:8080/api/person/all";
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Person> personas = new ArrayList<Person>();
        personas = restTemplate.getForObject(url, ArrayList.class);
        return personas;
    }

    public Person savePerson(Person person) {
        String url = "http://localhost:8080/api/person";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(url, person, Person.class);
        return person;
    }

    public Person findById(Long id) {
        System.out.println("asd");
        String url = "http://localhost:8080/api/person/" + id;
        RestTemplate restTemplate = new RestTemplate();
        Person person = restTemplate.getForObject(url, Person.class);
        System.out.println(person);
        return person;
    }
    /*
     * 
     * public ArrayList<Person> getPersonByApellido(String apellido) {
     * 
     * }
     * 
     * public boolean removePerson(Long id) {
     * }
     */

}

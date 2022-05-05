/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.portfoliobracciale.api.controllers;

import ar.com.portfoliobracciale.api.models.Nota;
import ar.com.portfoliobracciale.api.models.Person;
import ar.com.portfoliobracciale.api.services.NotaService;
import ar.com.portfoliobracciale.api.services.PersonService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notas")
public class NotaController {
      @Autowired
   PersonService personService;

    @Autowired
    NotaService notaService;

    @GetMapping("/all")
    public ResponseEntity<List<Nota>> getAllNotas() {
        List<Nota> notasList = notaService.getAllNotas();
        return new ResponseEntity<>(notasList, HttpStatus.OK);
    }
    @GetMapping("/avg/{id}")
    public double findAvgPorPersona(@PathVariable(value = "id") Long id){
        return notaService.findAvgPorPersona(id);
    }
    @GetMapping("/aprobadas")
    public ResponseEntity<List<Nota>> findAllAprobedNotes(){
        List<Nota> notasList = notaService.findAllAprobedNotes();
        return new ResponseEntity<>(notasList, HttpStatus.OK);
    }
    
    

    @GetMapping("/{id}")
    public Optional<Nota> getNotasById(@PathVariable(value = "id") Long id) {
          return notaService.getNotasByID(id);
    }

    @GetMapping("/person/{person_id}")
    public ResponseEntity<List<Nota>> getAllNotasByPersonId(@PathVariable(value = "person_id") Long personId) {
        List<Nota> notaList = new ArrayList<>();
        if (personService.getPersonByID(personId) != null) {
            notaList = notaService.getNotaByPersonId(personId);
            return new ResponseEntity<>(notaList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(notaList, HttpStatus.NOT_FOUND);
        }
    }

    
    
    @PostMapping("/person/{person_id}")
    public ResponseEntity<Nota> createNota(@PathVariable(value = "person_id") Long personId, @RequestBody Nota proyectRequest) {
        Person p = personService.findById(personId);
        proyectRequest.setPerson(p);
        Nota newProyect = notaService.save(proyectRequest);
        return new ResponseEntity<>(newProyect, HttpStatus.CREATED);
    }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEducation(@PathVariable("id") long id) {
        notaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

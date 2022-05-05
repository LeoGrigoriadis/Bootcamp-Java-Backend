/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.com.portfoliobracciale.api.services;

import ar.com.portfoliobracciale.api.models.Nota;
import ar.com.portfoliobracciale.api.repositories.NotaRepository;
import ar.com.portfoliobracciale.api.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotaService {
    
    @Autowired
    PersonRepository personRepository;
    
    @Autowired
    NotaRepository notaRepository;
    
     public ArrayList<Nota> getAllNotas() {
        return (ArrayList<Nota>) notaRepository.findAll();
    }

    public Nota save(Nota proyect) {
        return notaRepository.save(proyect);
    }

    public Nota getProyectByID(Long id) {
        return notaRepository.findById(id).get();
    }

    public boolean deleteById(Long id) {
        try {
            notaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public double findAvgPorPersona(Long id){
          return notaRepository.findAvgPorPersona(id);
    }
    public List<Nota> findAllAprobedNotes(){
        return (List<Nota>) notaRepository.findAllAprobedNotes();
    }
    public ArrayList<Nota> getNotaByPersonId(Long personId) {
           return (ArrayList<Nota>) notaRepository.findAllByPersonId(personId);
    }

    public Optional<Nota> getNotasByID(Long id) {
        return notaRepository.findById(id);
    }

    
    
    
}
    

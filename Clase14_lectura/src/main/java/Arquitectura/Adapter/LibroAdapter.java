package Arquitectura.Adapter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Arquitectura.Port.LibroPort;
import Arquitectura.Model.Libro;

@RestController
@RequestMapping("/libreria")
public class LibroAdapter implements LibroAdapterInterface{
	
	LibroPort lp;
	
	@GetMapping("/mostrar/todos")
	public ResponseEntity<List<Libro>> getAll(){
		try {
			List<Libro> libros=new ArrayList<Libro>();
			lp.findAll().forEach(libros::add);
			if(libros.isEmpty()) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
			return new ResponseEntity<>(libros,HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/mostrar/{nombre}")
	public ResponseEntity<List<Libro>> getOneById(@PathVariable("nombre") String nombre){
		try {
			List<Libro> libros=new ArrayList<Libro>();
			lp.findByNombre(nombre).forEach(libros::add);
			if(libros.isEmpty()) { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
			return new ResponseEntity<>(libros,HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/agregar")	
	public ResponseEntity<Libro> addOne(@RequestBody Libro libros){
		try {
			List<Libro> nLibro=new ArrayList<Libro>();
			lp.findByNombre(libros.getNombre()).forEach(nLibro::add);
			if(nLibro.isEmpty()) {
				Libro libro=lp.save(new Libro(libros.getAutor(), libros.getNombre(), libros.getEditorial(), libros.getFecha()));
				return new ResponseEntity<>(libro, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/actualizar/{nombre}")
	public ResponseEntity<Libro> updateOne(@RequestBody Libro libros,@PathVariable("nombre") String nombre){
		try {
			List<Libro> nLibro=new ArrayList<Libro>();
			lp.findByNombre(nombre).forEach(nLibro::add);
			if(!nLibro.isEmpty()) { libros.setNombre(nombre); lp.save(libros); 
				return new ResponseEntity<>(libros, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminar/{nombre}")
	public ResponseEntity<Libro> deleteOne(@PathVariable("nombre") String nombre){
		try {
			List<Libro> libros=new ArrayList<Libro>();
			lp.findByNombre(nombre).forEach(libros::add);
			Libro libro= libros.get(0);
			lp.delete(libro);
			return new ResponseEntity<>(libro, HttpStatus.OK);
		}catch( Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
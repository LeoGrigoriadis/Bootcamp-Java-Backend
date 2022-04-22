package Arquitectura.Adapter;
import Arquitectura.Model.Libro;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface LibroAdapterInterface {
	public ResponseEntity<List<Libro>> getAll();
	public ResponseEntity<List<Libro>> getOneById(String nombre);
	public ResponseEntity<Libro> addOne(Libro libros);
	public ResponseEntity<Libro> updateOne(Libro libros, String nombre);
	public ResponseEntity<Libro> deleteOne(String nombre);
}

import java.util.ArrayList;

public class Estudiante extends Persona{
	private ArrayList<String> cursos;
	//constructor
	public Estudiante(String nombre, String apellido, String estadoCivil, int id) {
		super(nombre, apellido, estadoCivil, id);
		cursos = new ArrayList<String> ();
	}//metodos
	public void setCursos(String c) { cursos.add(c); }
	public void imprimir() {
		System.out.print("nombre: "+getNombre()+", apellido: "+getApellido()+", estado civil: "
		+getEstadoCivil()+", identificación: "+getId()+", ");
		System.out.print("cursos: ");
		for(String c:cursos) System.out.print(c+" - ");
		System.out.print("\n");
	}
}
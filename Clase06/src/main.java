
public class main {
	public static void main(String[] args) {
		Estudiante es=new Estudiante("alumno","apellido","soltero",123);
		es.setCursos("Programaci�n");
		es.setCursos("Hardware");
		es.imprimir();
		Profesor p=new Profesor("profe","apellido","soltero",123, 2012, 12, "Base de datos");
		p.setDepartamento("Programaci�n");
		p.imprimir();
		PersonalServicio per=new PersonalServicio("personal","apellido","soltero",123, 2012, 12, "Base de datos");
		per.setSeccion("Base de datos");
		per.imprimir();
	}
}
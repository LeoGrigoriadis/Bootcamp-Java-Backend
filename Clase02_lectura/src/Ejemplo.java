import java.util.Vector;
public class Ejemplo {

	public static void main(String[] args) {
		int[] numeros= {4,6};
		Vector v=new Vector();
		Vector<Integer> v1 = new Vector<Integer>(20);
		Vector<String> textos = new Vector<String>(10, 2); //aumenta de a 2 espacios.
		v1.size();
		v1.capacity();
		v1.clear(); 
		v1.remove(4); //elimina el valor del espacio 4
	}

}
// {"coder", "devplace", "personas", "curso", "alumnado"}
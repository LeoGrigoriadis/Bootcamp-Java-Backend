import java.util.Scanner;

public class Minuscula {
	//private String cadena;
	public Minuscula() {
		/* Entendí mal la consigna, aca la corrijo.
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese una cadena de texto: ");
		this.cadena=teclado.next();
		Comprobar(cadena);*/
		char letra;

        for(letra = 'a'; letra<='z'; ++letra){
            System.out.println(letra + "");
        }
	}
	/*private void Comprobar(String texto) {
		char vector[], letra;
		int cont=0;
		vector= new char[texto.length()];

		for(int i=0;i<texto.length();i++) {
			letra=texto.charAt(i);
			if(Character.isLowerCase(letra)) {
				vector[cont]=letra;
				cont++;
			}
		}
		System.out.print(vector);
	}*/
	public static void main(String[] args) {
		Minuscula m=new Minuscula();
	}
}
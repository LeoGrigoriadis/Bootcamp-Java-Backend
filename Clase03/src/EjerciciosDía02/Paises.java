package EjerciciosDía02;
import java.util.Scanner;

public class Paises {
	private String[][] ciudades;
	Scanner teclado = new Scanner(System.in);
	public Paises() {
		ciudades=new String[5][4];
		mostrar(crearMatriz());
	}
	private String[][] crearMatriz() {
		String pais, ciudad;
		for(int i=0;i<=4;i++) {
			System.out.print("Ingrese el nombre del país: ");
			pais=teclado.next();
			ciudades[i][0]=pais;
			for(int j=1;j<=3;j++) {
				System.out.print("Ingrese el nombre de la "+(j)+" ciudad: ");
				ciudad=teclado.next();
				ciudades[i][j]=ciudad;
			}
		}
		return this.ciudades;
	}
	private void mostrar(String[][] matriz) {
		for(int i=0;i<=4;i++) {
			System.out.println("País: "+matriz[i][0]);
			System.out.print("Y sus ciudades son: ");
			for(int j=1;j<=3;j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	public static void main(String[] args) {
		Paises p=new Paises();
	}
}
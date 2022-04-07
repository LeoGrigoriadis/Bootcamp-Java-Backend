package FakeSporty;
import java.util.Random;
import java.util.Scanner;

public class Usuario {
	private String[] canciones= {"canción1", "canción2", "canción3", "canción4", "canción5", "canción6"};
	private int saltos=0;
	private String actual;
	private Scanner teclado = new Scanner(System.in);
	
	public String[] getCanciones() {
		return canciones;
	}

	public void setCanciones(String[] canciones) {
		this.canciones = canciones;
	}

	public int getSaltos() {
		return saltos;
	}

	public void setSaltos(int saltos) {
		this.saltos = saltos;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public Scanner getTeclado() {
		return teclado;
	}

	public void setTeclado(Scanner teclado) {
		this.teclado = teclado;
	}

	public void PausarConsole() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void repAleatorio() {
		Random random = new Random();
		int aleatorio=random.nextInt(6);
		actual=canciones[aleatorio];
		System.out.println("Se está reproduciendo: "+actual);
	}	
}

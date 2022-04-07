package creados;

public class Triangulo {

private int lado1,lado2,lado3;
	
	public Triangulo(int lado1,int lado2, int lado3) {
		this.lado1=lado1;
		this.lado2=lado2;
		this.lado3=lado3;
	
	}

	
	public float perimetro() {
		var perim=lado1+lado2+lado3;
		return perim;
	}
		
	public double superficie() {
		var superP=perimetro()/2;
		var superf= Math.sqrt(superP*(superP-lado1)*(superP-lado2)*(superP-lado3));
		return superf;
	}
	public String miNombre() {
		return "Triangulo";
	}
}
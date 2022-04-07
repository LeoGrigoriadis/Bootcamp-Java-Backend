package creados;

public class Rectangulo implements Figura {
	//atributos
		public int ladoMayor,ladoMenor;
		
		//Constructor
		public Rectangulo(int ladoMayor,int ladoMenor) {
			this.ladoMayor = ladoMayor;
			this.ladoMenor = ladoMenor;
		}
			
		public float perimetro() {
			var perim= (ladoMayor*2)+(ladoMenor*2);
			return perim;
		}
			
		public float superficie() {
			var superf=ladoMayor*ladoMenor;
			return superf;
		}
		public String miNombre() {
			
			return "Rectangulo";
		}
}
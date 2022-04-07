
public class main {

	public static void main(String[] args) {
		Remolque r=new Remolque(20);
		Particular p=new Particular("MRS432", 4);
		try {
			System.out.print(p.getMatricula()+" ");p.setAcelerar(120);
		}catch(DemasiadoRapidoException e){
			System.out.println(e.mensaje());
		}
		System.out.println(p.toString());
		Carga c=new Carga("TAS118");
		System.out.print(c.getMatricula()+" ");c.ponRemolque(r);
		try {
			System.out.print(c.getMatricula()+" ");c.setAcelerar(120);
		}catch(DemasiadoRapidoException e){
			System.out.println(e.mensaje());
		}
		
		System.out.println(c.toString());
		System.out.print(c.getMatricula()+" ");c.quitarRemolque();
		try {
			System.out.print(c.getMatricula()+" ");c.setAcelerar(80);
		}catch(DemasiadoRapidoException e){
			System.out.println(e.mensaje());
		}
		try {
			System.out.print(c.getMatricula()+" ");c.setAcelerar(-20);
		}catch(DemasiadoRapidoException e){
			System.out.println(e.mensaje());
		}
		System.out.println(c.toString());
	}
}
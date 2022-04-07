
public class index {

	public static void main(String[] args) {
		Remolque r=new Remolque(20);
		Particular p=new Particular("MRS432", 4);
		System.out.print(p.getMatricula()+" "); p.setAcelerar(150);
		System.out.println(p.toString());
		Carga c=new Carga("TAS118");
		System.out.print(c.getMatricula()+" ");c.ponRemolque(r);
		System.out.print(c.getMatricula()+" ");c.setAcelerar(120);
		System.out.println(c.toString());
		System.out.print(c.getMatricula()+" ");c.quitarRemolque();
		System.out.print(c.getMatricula()+" ");c.setAcelerar(120);
		System.out.println(c.toString());
	}
}
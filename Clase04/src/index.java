
public class index {

	public static void main(String[] args) {
		Remolque r=new Remolque(20);
		Particular p=new Particular("MRS432", 4);
		System.out.println(p.toString());
		Carga c=new Carga("TAS118");
		c.ponRemolque(r);
		c.setAcelerar(120);
		System.out.println(c.toString());
		c.quitarRemolque();
		c.setAcelerar(120);
		System.out.println(c.toString());
	}

}

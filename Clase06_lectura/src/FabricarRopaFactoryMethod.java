
public class FabricarRopaFactoryMethod {
	private IFabricacion fab;
	public IFabricacion crear(int op) {
		if(op==1) { fab=new FabricacionPantalon(); }
		else if(op==2) { fab=new FabricacionCampera(); }
		return fab;
	}
}
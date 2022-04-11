
public class AccesoAFabricacionStrategy {
	private IFabricacion fab;
	public AccesoAFabricacionStrategy(IFabricacion fab) {
		this.fab=fab;
	}
	public void fabricar(IFabricacion r) { this.fab.fabricar(r); }
}

public class DemasiadoRapidoException extends Exception{
	public DemasiadoRapidoException() {}
	public DemasiadoRapidoException(String mensaje){ super(mensaje); }
	public String mensaje() {return "ERROR: Demasiado rápido.";}
}

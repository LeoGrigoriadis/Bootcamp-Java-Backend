package Classes;

public abstract class Usuario {
	private String nombreUser, contraUser;
	private int id;
	private boolean esCliente;
	//constructor
	public Usuario(String nombreUser, String contraUser, int id, boolean esCliente) {
		this.nombreUser = nombreUser;
		this.contraUser = contraUser;
		this.id=id;
		this.esCliente=esCliente;
	}
	//setters y getters
	public void setEsCliente(boolean t) { this.esCliente=t; }
	public boolean getEsCliente() { return esCliente; }
	public String getNombreUser() { return nombreUser; }
	public String getContraUser() { return contraUser; }
	public int getId() { return id; }	
}
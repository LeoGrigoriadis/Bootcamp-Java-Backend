package Login.Request;

public class RequestLogin {
	private String email;
	private String password;
	//constructor
	public RequestLogin(String email, String password) {
		this.email = email;
		this.password = password;
	}
	//setters y getters
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}
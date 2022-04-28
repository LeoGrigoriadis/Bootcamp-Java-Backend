package Main.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="users")
public class User {
	@Id 
	private String id;
	private String username;
	private String email;
	private String name;
	private String password;
	public User(String username, String email, String name, String password) {
		this.username = username;
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	
}
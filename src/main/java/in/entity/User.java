package in.entity;

public class User {
	
	//Defining fields
	//private Integer id;
	private String username;
	private String email;
	private String password;
	private String code;
	
	
	public User() {}
	
	public User(String username,String email,String code) {
		this.username = username;
		this.email=email;
		this.code=code;
				
	}
	
	public User(String email,String code) {
		this.email=email;
		this.code=code;
				
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	//toSTring Generation
	@Override
	public String toString() {
		return "User [ username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}

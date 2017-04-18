package gea.model;

public class User {
	private String loginId;
	private String password;
	private String phone;
	private String email;
	private String name;
	
	public User() {
	}

	public User(String name, String email, String phone) {
		this.phone = phone;
		this.email = email;
		this.name = name;
		this.loginId = phone;
	}

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

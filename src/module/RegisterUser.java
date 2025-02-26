package module;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class RegisterUser extends GuestUser implements IPostCreate{ //netiks veidoti objekti, bet izmantos kaa superklasi
	
	private String username;
	private String nameAndSurname;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public String getNameAndSurname() {
		return nameAndSurname;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String inputUsername) {
		if(inputUsername != null && inputUsername.matches("[A-Za-z0-9._]{5,15}")) {
			username = inputUsername;
		}else {
			username = "No username";
		}
	}
	
	public void setNameAndSurname(String inputNameAndSurname) {
		if(inputNameAndSurname != null && inputNameAndSurname.matches("[A-Z]{1}[a-z]{2,10}([ ]{1}[A-Z]{1}[a-z]{2,10})?")) {
			nameAndSurname = inputNameAndSurname;
		}else {
			nameAndSurname = "Name Surname";
		}
	}
	
	public void setPassword(String inputPassword) {
		if(inputPassword != null && inputPassword.matches("[A-Za-z0-9!@#$%^&*()_]{8,15}")) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
			}catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		else {
			password = "localadmin";
		}
	}
	
	public RegisterUser() {
		super();
		setNameAndSurname("Testa Lietotajs");
		setUsername("testa.lietotajs");
		setPassword("123querty");
	}
	
	public RegisterUser(long id, String nameAndSurname, String username, String password) {
		super();
		setNameAndSurname(nameAndSurname);
		setUsername(username);
		setPassword(password);
	}
	
	public String toString() {
		return super.toString() + ": " + username + ", " + nameAndSurname + ", " + password;
	}
}

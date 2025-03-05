package module;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import service.MainService;

public abstract class RegisterUser extends GuestUser implements IPostCreate{ //netiks veidoti objekti, bet izmantos kaa superklasi
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
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
	
	
	public void setPassword(String inputPassword) {
		if(inputPassword != null && inputPassword.matches("[A-Za-z ]{2,15}")) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
				password = new String(md.digest());
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
		setUsername("testa.lietotajs");
		setPassword("123querty");
	}
	
	public RegisterUser(String username, String password) {
		super();
		setUsername(username);
		setPassword(password);
	}
	
	public String toString() {
		return super.toString() + ": " + username + ", " + password;
	}
	
	public void followPage(String inputTitle) throws NullPointerException{
		if (inputTitle != null) {
			for(GuestUser tempU: MainService.getAllUsers()) {
				if(tempU instanceof BusinessUser) {
					BusinessUser tempBU = (BusinessUser) tempU;
					for(Page tempP: tempBU.getListOfPages()) {
						if(tempP.getTitle().equals(inputTitle)) {
							tempP.getAllFollowersUsers().add(this);
						}
					}
				}
			}
		}else {
			throw new NullPointerException("Params should be with real reference");
		}
	}
	
	public void followPrivateUser(String inputUsername) throws NullPointerException{
		if (inputUsername != null) {
			for(GuestUser tempU: MainService.getAllUsers()) {
				if(tempU instanceof PrivateUser) {
					PrivateUser tempPU = (PrivateUser) tempU;
					if(tempPU.getUsername().equals(inputUsername)) {
						tempPU.getAllFollowers().add(this);
						
					}
				}
			}
		}else {
			throw new NullPointerException("Params should be with real reference");
		}
	}
	
	public boolean login(String inputUsername, String inputPassword) throws Exception{
		if(inputUsername == null || inputPassword == null) {
			throw new Exception("Username and password should be with real reference");
		}
		for (GuestUser tempU: MainService.getAllUsers()) {
			if (tempU instanceof RegisterUser) {
				RegisterUser tempRU = (RegisterUser) tempU;
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
				String inputPasswordEncripted = new String(md.digest());
				if(tempRU.getUsername().equals(inputUsername) && tempRU.getPassword().equals(inputPasswordEncripted)) {
					return true;
				}
			}
		}
		return false;
	}
}

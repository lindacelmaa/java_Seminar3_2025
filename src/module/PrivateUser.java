package module;

import java.util.ArrayList;

public class PrivateUser extends RegisterUser {
	
	private String name;
	private String surname;
	private ArrayList<Post> privatePosts = new ArrayList<Post>();
	private ArrayList<Post> publicPosts = new ArrayList<Post>();
	private ArrayList<RegisterUser> allFollowers = new ArrayList<RegisterUser>();
	
	
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}


	public ArrayList<Post> getPrivatePosts() {
		return privatePosts;
	}


	public ArrayList<Post> getPublicPosts() {
		return publicPosts;
	}


	public ArrayList<RegisterUser> getAllFollowers() {
		return allFollowers;
	}


	public void setName(String inputName) {
		if(inputName!= null && inputName.matches("[A-Z]{1}[a-z]{2,10}([ ]{1}[A-Z]{1}[a-z]{2,10})?")) {
			name = inputName;
		}else {
			name = "Name";
		}
	}


	public void setSurname(String inputSurname) {
		if(inputSurname != null && inputSurname.matches("[A-Z]{1}[a-z]{2,10}([ ]{1}[A-Z]{1}[a-z]{2,10})?")) {
			surname = inputSurname;
		}else {
			surname = "Surname";
		}
	}
	
	public PrivateUser() {
		super();
		setName("Testa");
		setSurname("Persona");
		
	}
	
	public PrivateUser(String inputUsername, String inputPassword, String name, String surname) {
		super(inputUsername, inputPassword);
		setName(name);
		setName(surname);
	}

	public String toString() {
		return super.toString() + ": " + name + " " + surname;
	}


	@Override
	public void createPost(PostType postType, String... params) {
		
	}
}

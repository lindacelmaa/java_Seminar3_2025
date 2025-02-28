package module;

import java.util.ArrayList;

public class Page {
	private String title;
	private String description;
	private ArrayList<Post> postsInPage = new ArrayList<Post>();
	private ArrayList<RegisterUser> allFollowersUsers = new ArrayList<RegisterUser>();
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public ArrayList<Post> getPostsInPage() {
		return postsInPage;
	}
	
	public ArrayList<RegisterUser> getAllFollowersUsers() {
		return allFollowersUsers;
	}
	
	public void setTitle(String inputTitle) {
		if(inputTitle!= null && inputTitle.matches("[A-Z]{1}[a-z]{2,10}([ ]{1}[A-Z]{1}[a-z]{2,10})?")) {
			title = inputTitle;
		}else {
			title = "Title";
		}
	}
	
	public void setDescription(String inputDescription) {
		if(inputDescription != null && inputDescription.matches("[A-Za-z0-9!@#$%^&*()_ ]{5,500}")) {
			description = inputDescription;
		}else {
			description = "This is description";
		}
	}
	
	public Page() {
		setTitle("Title");
		setDescription("Description");
	}
	
	public Page(String title, String description) {
		setTitle(title);
		setDescription(description);
	}
	
	public String toString() {
		return "Title: " + title + "; Description: " + description;
	}
	
}

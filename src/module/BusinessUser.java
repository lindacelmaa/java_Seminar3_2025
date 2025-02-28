package module;

import java.util.ArrayList;

public class BusinessUser extends RegisterUser {
	
	private String businessName;
	private ArrayList<Page> listOfPages = new ArrayList <Page>();
	
	
	
	public String getBusinessName() {
		return businessName;
	}

	public ArrayList<Page> getListOfPages() {
		return listOfPages;
	}
	
	public void setBusinessName(String inputBusinessName) {
		if(inputBusinessName != null && inputBusinessName.matches("[A-Z]{1}[a-z]{2,10}([ ]{1}[A-Z]{1}[a-z]{2,10})?")) {
			businessName = inputBusinessName;
		}else {
			businessName = "Surname";
		}
	}

	public BusinessUser() {
		super();
		setBusinessName("Business Name");
	}
	
	public BusinessUser(String inputUsername, String inputPassword, String inputBusinessName) {
		super(inputUsername, inputPassword);
		setBusinessName(inputBusinessName);
	}
	
	public String toString() {
		return super.toString() + ": " + businessName+ ", " + listOfPages;
	}

	@Override
	public void createPost(PostType postType, String... params) throws Exception {
		if(postType != null && params != null) {
			if(params.length > 1) {
				Post newPost = new Post(params[0]);
				for (int i = 1; i < params.length; i++) {
					for(Page tempP: listOfPages) {
						if(params[i].equals(tempP.getTitle())){
							tempP.getPostsInPage().add(newPost);
						}
					}
				}
			}
			else {
				throw new Exception("Message text is necessary");
			}
		}else {
			throw new NullPointerException("Params should be with real reference");
		}
	}
	
	public void createPage(String inputTitle, String inputDescription) {
		if(inputTitle != null && inputDescription != null) {
			Page newPage = new Page(inputTitle, inputDescription);
			listOfPages.add(newPage);
		}else {
			throw new NullPointerException("Params should be with real reference");
		}
	}
	
	
}

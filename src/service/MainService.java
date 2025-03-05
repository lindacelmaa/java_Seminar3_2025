package service;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

import module.BusinessUser;
import module.GuestUser;
import module.Page;
import module.PostType;
import module.PrivateUser;
import module.RegisterUser;

public class MainService {
	
	private static ArrayList<GuestUser> allUsers = new ArrayList<GuestUser>();

	public static void main(String[] args) {
		
		GuestUser u1 = new GuestUser();
		GuestUser u2= new GuestUser();
		
		PrivateUser u3 = new PrivateUser("lindacelma", "Aaaaa", "Linda", "Celma");
		BusinessUser u4 = new BusinessUser("ziedu.veikals","localuser", "Ziedu Veikals");
		
		allUsers.addAll(Arrays.asList(u1, u2, u3, u4));
		for(GuestUser tempU: allUsers) {
			System.out.println(tempU.getClass().getName() + "->" + tempU);
		}
		
		try {
			if(u3.login("lindacelma", "Aaaaa")) {
				u3.createPost(PostType.publicPost, "Man patik JAVA!");
				u3.createPost(PostType.privatePost, "Man gribas majas!!");
			
				System.out.println(u3.getSurname() + " privatas zi'nas: " + u3.getPrivatePosts());
				System.out.println(u3.getSurname() + " publiskas zi'nas: " + u3.getPublicPosts());
			
				u4.createPage("Ziedi Ventspili", "Mana lapa par ziediem Ventspili");
				u4.createPage("Ziedi Ugaalee", "Mana lapa par ziediem Ugaalee");
				
				u4.createPost(PostType.publicPost, "20% atlaide visiem ziediem", "Ziedi Ventspili");
				u4.createPost(PostType.publicPost, "Cau rau", "Ziedi Ventspili", "Ziedi Ugaalee");
			
				for(Page temp4: u4.getListOfPages()) {
				System.out.println(temp4);
				}
			
				u3.followPage("Ziedi Ventspili");
				System.out.println(u4.getListOfPages().get(0).getAllFollowersUsers());
			
				u4.followPrivateUser("lindacelma");
				System.out.println(u3.getSurname() + " sekotaji ir -> " + u3.getAllFollowers());
			
				System.out.println("Mekleju (linda) -> " + u4.findUser("Linda"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<GuestUser> getAllUsers() {
		return allUsers;
	}
	
	
	
	
	

}

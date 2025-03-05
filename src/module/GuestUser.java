package module;

import java.util.ArrayList;

import service.MainService;

public class GuestUser {
	private long id;
	
	private static long counter = 0;

	public long getId() {
		return id;
	}

	public void setId() {
		id = counter++;
	}
	
	public GuestUser() {
		setId();
	}
	
	public String toString() {
		return id + "";
	}
	
	//TODO meklet lietotaju pec varda vai uzvarda vai nosaukumu
	
	public ArrayList<RegisterUser> findUser(String searchText) throws Exception{
		if (searchText == null) {
			throw new Exception("Input text should be with real reference");
		}
		
		
		ArrayList<RegisterUser> result = new ArrayList<RegisterUser>();
		
		for (GuestUser tempU : MainService.getAllUsers()) {
			if(tempU instanceof PrivateUser) {
				PrivateUser tempPU = (PrivateUser) tempU;
				if(tempPU.getName().contains(searchText) || tempPU.getSurname().contains(searchText)) {
					result.add(tempPU);
				}
				else if(tempU instanceof BusinessUser) {
					BusinessUser tempBU = (BusinessUser) tempU;
					if(tempBU.getBusinessName().contains(searchText) || tempBU.getUsername().contains(searchText)){
						result.add(tempBU);
					}
				}
			}
		}
		if(result.isEmpty()) {
			throw new Exception("Not found");
		}
		return result;
		
	}	
}

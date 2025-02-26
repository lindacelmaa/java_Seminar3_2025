package module;

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
	
	//TODO pabeigt ar filtr'acijas funkcijaam
	
}

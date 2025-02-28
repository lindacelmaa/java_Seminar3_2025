package module;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
	private String msg;
	private LocalDateTime date;
	private int countOfLikes = 0;

	
	public String getMsg() {
		return msg;
	}
	
	public LocalDateTime getDate() {
		return date;
	}
	
	public int getCountOfLikes() {
		return countOfLikes;
	}
	
	public void setMsg(String inputMsg) {
		if (inputMsg != null && inputMsg.matches("[A-Za-b .0-9!@#$%^&*(),]{3,150}")) {
			msg = inputMsg;
		}else {
			msg = "Hello world!";
		}
	}
	
	public void setDate() {
		date= LocalDateTime.now();
	}
	
	public void setCountOfLikes() {
		countOfLikes++;
	}
	
	public Post() {
		setMsg("Hello world");
		setDate();
	}
	
	public Post(String inputMsg) {
		setMsg(inputMsg);
		setDate();
	}
	
	public String toString() {
		return msg + " (" + date + ") " + countOfLikes; 
	}
}

package module;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Post {
	private String msg;
	private LocalDate date;
	private int countOfLikes = 0;

	
	public String getMsg() {
		return msg;
	}
	
	public LocalDate getDate() {
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
	
	public void setDate(LocalDate inputDate) {
		if (inputDate != null && !inputDate.isBefore(LocalDate.now())) {
			date = inputDate;
		}
		else {
			date = LocalDate.now();
		}
	}
	
	public void setCountOfLikes() {
		countOfLikes++;
	}
	
	public Post() {
		setMsg("Hello world");
		setDate(LocalDate.now());
	}
	
	public Post(String inputMsg, LocalDate date) {
		setMsg(inputMsg);
		setDate(date);
	}
	
	public String toString() {
		return msg + " (" + date + ") " + countOfLikes; 
	}
}

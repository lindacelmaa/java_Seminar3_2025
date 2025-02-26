package module;

import java.util.Date;

public class Post {
	private String msg;
	private Date date;
	private int countOfLikes;
	
	public String getMsg() {
		return msg;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getCountOfLikes() {
		return countOfLikes;
	}
	
	public void setMsg(String inputMsg) {
		if (inputMsg != null) {
			msg = inputMsg;
		}else {
			msg = "Hello world!";
		}
	}
	
	public void setDate(Date inputDate) {
		if (inputDate != null && !inputDate);
	}
	
	public void setCountOfLikes(int countOfLikes) {
		this.countOfLikes = countOfLikes;
	}
	
	
}

package client;

import org.json.JSONException;
import org.json.JSONObject;

public class Message {
	
	private int user_id;
	private int group_id;
	private String message;
	private JSONObject json;
	
	public Message() {}
	
	Message(Object msg) {
		try {
			this.json = new JSONObject(msg);
			setUser_id(json.getInt("user_id"));
			setGroup_id(json.getInt("group_id"));
			setMessage(json.getString("message"));
		} catch (JSONException err){
		     System.out.print("Error");
		}
	}

	public int getUser_id() {
		return user_id;
	}

	private void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGroup_id() {
		return group_id;
	}

	private void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}
}

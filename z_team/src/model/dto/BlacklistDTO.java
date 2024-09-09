package model.dto;

public class BlacklistDTO {
	private String reason;
	private String userid;
	private String userphone;
	
	public BlacklistDTO(String reason, String userid, String userphone) {
		super();
		this.reason = reason;
		this.userid = userid;
		this.userphone = userphone;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	
	
}

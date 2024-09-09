package model.dto;

public class RoomDTO {
	private int roomnum;
	private String type;
	private int price;
	
	public RoomDTO(int roomnum, String type, int price) {
		super();
		this.roomnum = roomnum;
		this.type = type;
		this.price = price;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

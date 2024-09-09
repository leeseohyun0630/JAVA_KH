package model.dto;

public class ReservationDTO {
	private int resnum;
	private String userid;
	private int hotelnum;
	private int roonum;
	private String checkin;
	private String checkout;
	private int days;
	private int usepoolcnt;
	private int usehealthcnt;
	private int price;
	
	public ReservationDTO(int resnum, String userid, int hotelnum, int roonum, String checkin, String checkout,
			int days, int usepoolcnt, int usehealthcnt, int price) {
		super();
		this.resnum = resnum;
		this.userid = userid;
		this.hotelnum = hotelnum;
		this.roonum = roonum;
		this.checkin = checkin;
		this.checkout = checkout;
		this.usepoolcnt = usepoolcnt;
		this.usehealthcnt = usehealthcnt;
		this.price = price;
	}

	public int getResnum() {
		return resnum;
	}

	public void setResnum(int resnum) {
		this.resnum = resnum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getHotelnum() {
		return hotelnum;
	}

	public void setHotelnum(int hotelnum) {
		this.hotelnum = hotelnum;
	}

	public int getRoonum() {
		return roonum;
	}

	public void setRoonum(int roonum) {
		this.roonum = roonum;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public int getUsepoolcnt() {
		return usepoolcnt;
	}

	public void setUsepoolcnt(int usepoolcnt) {
		this.usepoolcnt = usepoolcnt;
	}

	public int getUsehealthcnt() {
		return usehealthcnt;
	}

	public void setUsehealthcnt(int usehealthcnt) {
		this.usehealthcnt = usehealthcnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
}

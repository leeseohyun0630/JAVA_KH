package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import model.dao.ReservationDAO;
import model.dao.UserDAO;
import model.dto.ReservationDTO;
import model.dto.RoomDTO;

public class ReservationController {
	public ArrayList<String> getReservationInfo(String userid) {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<String> reservation = rdao.getReservationInfoByUserid(userid);
		return reservation;
	}
	
	public ArrayList<Integer> dateCheck(int hotelNum, int inNum, int outNum) {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<RoomDTO> list = rdao.getRoom();
		ArrayList<Integer> room = new ArrayList<>();
		for(int i = 0; i<list.size();i++) {
			room.add(list.get(i).getRoomnum());
		}
		room = rdao.dateCheckbyDate(hotelNum, inNum, outNum, room);
		return room;
	}
	public ArrayList<Integer> dateCheck_modify(int resNum, int hotelNum, int inNum, int outNum) {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<RoomDTO> list = rdao.getRoom();
		ArrayList<Integer> room = new ArrayList<>();
		for(int i = 0; i<list.size();i++) {
			room.add(list.get(i).getRoomnum());
		}
		room = rdao.dateCheckbyDate_modify(resNum,hotelNum, inNum, outNum, room);
		return room;
	}

	public boolean reservaion(String userid, String checkin, String checkout, int roomNum, int hotelNum, int usepoolcnt, int usehealthcnt,int price,int days) {
		ReservationDAO rdao = new ReservationDAO();
		return rdao.insertReservaion(userid, checkin, checkout, roomNum, hotelNum, usepoolcnt, usehealthcnt,price,days);
	}
	
	public boolean checktoday(String date) {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter fm = DateTimeFormatter.ofPattern("yyyyMMdd");
		String today = now.format(fm);
		String dateFormatType = "yyyyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType);
		Date checkin;
		Date todayDate;
		date = date.replace("-", "");
		try {
			checkin = simpleDateFormat.parse(date);
			todayDate = simpleDateFormat.parse(today);
			if (checkin.getTime() <= todayDate.getTime()) {
				return false;
			}
		} catch (ParseException e) {
		}
		return true;
	}

	public int claculateDate(String checkin, String checkout) {
		String dateFormatType = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormatType);
		Date from;
		Date to;
		try {
			from = simpleDateFormat.parse(checkin);
			to = simpleDateFormat.parse(checkout);
			long diff = to.getTime() - from.getTime();
			long date = diff/86400000L+1;
			return (int)date;
		} catch (ParseException e) {
		}
		return 0;
	}
	
	public int price(int date, int roomNum, int usepoolcnt, int usehealthcnt) {
		ReservationDAO rdao = new ReservationDAO();
		int price = 0;

		ArrayList<RoomDTO> room = rdao.getRoom();
		for(int i =0; i<room.size(); i++) {
			if(roomNum == room.get(i).getRoomnum()) {
				price += room.get(i).getPrice()*date;
			}
		}
		price = price + 500000*usepoolcnt + 800000*usehealthcnt;
		
		return price;
	}
	public String makeDate(int year, int month, int day) {
		String year2 ="";
		year2 = year+"";
		String month2 = "";
		if(month<10) {
			month2 = month+"";
			month2 = "0"+month2;
		}
		else{
			month2= month+"";
		}
		String day2 = "";
		if(day<10) {
			day2 = day+"";
			day2 = 0+day2;
		}
		else {
			day2 = day+"";
		}
		String date = year2+"-"+month2+"-"+day2;
		return date;
	}
	
	public boolean isDate(String date) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		dt.setLenient(false);
		try {
			dt.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	public boolean deleteReservation(int resNum) {
		ReservationDAO rdao = new ReservationDAO();
		return rdao.deleteReservationByResnum(resNum);
	}
	
	
	
	public int getPrice(int resNum) {
		ReservationDAO rdao = new ReservationDAO();
		int price = rdao.getReservationByresNum(resNum).get(0).getPrice();
		return price;
	}
	
	public ArrayList<Integer> getResnum(String userid) {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<ReservationDTO> list = rdao.getReservationByUserid(userid);
		ArrayList<Integer> resNum = new ArrayList<>();
		for(int i = 0; i<list.size();i++) {
			resNum.add(list.get(i).getResnum());
		}
		return resNum;
	}

	public ArrayList<String> getHotel() {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<String> hotel = rdao.getHotel();
		return hotel;
	}

	public int getHotelNum(String hotelName) {
		ReservationDAO rdao = new ReservationDAO();
		int hotelNum = rdao.getHotelNumByHotelName(hotelName);
		return hotelNum;
	}


}

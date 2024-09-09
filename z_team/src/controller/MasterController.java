package controller;

import java.util.ArrayList;

import model.dao.MasterDAO;
import model.dao.ReservationDAO;
import model.dao.UserDAO;
import model.dto.BlacklistDTO;
import model.dto.RoomDTO;
import model.dto.UserDTO;

public class MasterController {

	public ArrayList<String> getblacklist() {
		MasterDAO mdao = new MasterDAO();
		ArrayList<String> list = mdao.getBlacklist();
		return list;
	}

	public void insertBlacklist(String addBlack, String reason) {
		MasterDAO mdao = new MasterDAO();
		UserDAO udao = new UserDAO();
		try {
			int check = Integer.parseInt(addBlack);
			
			UserDTO user = udao.getUserByUserphone(addBlack);
			String userid = user.getUserid();
			if(mdao.insertBlacklistByUserphone(userid, addBlack, reason)) {
				System.out.println("블랙리스트가 추가되었습니다.");
			}
			
		} catch (NumberFormatException e) {
			UserDTO user = udao.getUserByUserid(addBlack);
			String userphone = user.getUserphone();
			if(mdao.insertBlacklistByUserid(addBlack, userphone, reason)) {
				System.out.println("블랙리스트가 추가되었습니다.");
			}
		}
	}

	public void deleteBlacklist(String deleteBlack) {
		MasterDAO mdao = new MasterDAO();
		try {
			int check = Integer.parseInt(deleteBlack);
			
			if(mdao.deleteBlacklistByUserphone(deleteBlack)) {
				System.out.println("블랙리스트가 해제되었습니다.");
			}
		} catch (NumberFormatException e) {
			if(mdao.deleteBlacklistByUserid(deleteBlack)) {
				System.out.println("블랙리스트가 해제되었습니다.");
			}
		}
	}

	public boolean inserthotel(String hotelname) {
		MasterDAO mdao = new MasterDAO();
		return mdao.inserthotel(hotelname);
	}

	public boolean deletehotel(String hotelname) {
		MasterDAO mdao = new MasterDAO();
		return mdao.deletehotel(hotelname);
	}

	public ArrayList<String> roomList() {
		ReservationDAO rdao = new ReservationDAO();
		ArrayList<RoomDTO> list = rdao.getRoom();
		ArrayList<String> room = new ArrayList<>();
		for(int i = 0; i<list.size();i++) {
			room.add(String.format("%d\t%s\t%d", list.get(i).getRoomnum(), list.get(i).getType(),list.get(i).getPrice()));
		}
		return room;
	}

	public boolean insertRoom(int roomnum, String type, int price) {
		MasterDAO mdao = new MasterDAO();
		return mdao.insertRoom(roomnum, type, price);
	}

	public boolean deleteRoom(int roomnum) {
		MasterDAO mdao = new MasterDAO();
		return mdao.deleteRoom(roomnum);
	}

	public boolean isUser(String addBlack) {
		UserDAO udao = new UserDAO();
		try {
			int check = Integer.parseInt(addBlack);
			
			ArrayList<UserDTO> list = udao.getUserlistbyUserphone(addBlack);
			boolean flag = false;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getUserphone().equals(addBlack)) {
					flag = true;
					return flag;
				}
			}
			return flag;
		} catch (NumberFormatException e) {
			ArrayList<UserDTO> list = udao.getUserlistbyUserid(addBlack);
			boolean flag = false;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getUserid().equals(addBlack)) {
					flag = true;
					return flag;
				}
			}
			return flag;
		}
	}

	public boolean isBlacklist(String deleteBlack) {
		UserDAO udao = new UserDAO();
		try {
			int check = Integer.parseInt(deleteBlack);
			
			ArrayList<BlacklistDTO> list = udao.getBlacklistbyUserphone(deleteBlack);
			boolean flag = false;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getUserphone().equals(deleteBlack)) {
					flag = true;
					return flag;
				}
			}
			return flag;
		} catch (NumberFormatException e) {
			ArrayList<BlacklistDTO> list = udao.getBlacklistbyUserid(deleteBlack);
			boolean flag = false;
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getUserid().equals(deleteBlack)) {
					flag = true;
					return flag;
				}
			}
			return flag;
		}
	}
}

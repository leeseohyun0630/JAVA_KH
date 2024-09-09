package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.DBConnection;
import model.dto.ReservationDTO;
import model.dto.RoomDTO;

public class ReservationDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public ReservationDAO() {
		conn = DBConnection.getConnection();
	}
	
	public ArrayList<Integer> dateCheckbyDate(int hotelNum,int inNum, int outNum, ArrayList<Integer> list) {
		String sql = "select * from reservationInfo where hotelnum = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hotelNum);
			rs = ps.executeQuery();
			ArrayList<Integer> fullroom = new ArrayList<>();
			
			while(rs.next()) {
				String checkin = rs.getString("checkin");
				String checkout = rs.getString("checkout");
				checkin = checkin.substring(0,10).replace("-", "");
				checkout = checkout.substring(0,10).replace("-", "");
				int num1 = Integer.parseInt(checkin);
				int num2 = Integer.parseInt(checkout);
				
				if((inNum >= num1 && inNum <= num2 )||(outNum>=num1 && outNum<=num2)) {
					int room = rs.getInt("roomnum");
					fullroom.add(room);
				}
				else if(num1>=inNum && num1<= outNum) {
					int room = rs.getInt("roomnum");
					fullroom.add(room);
				}
			}
			for(int i =0;i<fullroom.size();i++) {
				list.remove(fullroom.get(i));
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
//	public ArrayList<RoomDTO> dateCheckbyDate(int hotelNum,int inNum, int outNum, ArrayList<RoomDTO> list) {
//		String sql = "select * from reservationInfo where hotelnum = ?";
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, hotelNum);
//			rs = ps.executeQuery();
//			ArrayList<Integer> fullroom = new ArrayList<>();
//			
//			while(rs.next()) {
//				String checkin = rs.getString("checkin");
//				String checkout = rs.getString("checkout");
//				checkin = checkin.substring(0,10).replace("-", "");
//				checkout = checkout.substring(0,10).replace("-", "");
//				int num1 = Integer.parseInt(checkin);
//				int num2 = Integer.parseInt(checkout);
//				
//				if((inNum >= num1 && inNum <= num2 )||(outNum>=num1 && outNum<=num2)) {
//					int room = rs.getInt("roomnum");
////					System.out.println(room+"번 방에 이미 예약이 되어있습니다.");
//					fullroom.add(room);
//				}
//				else if(num1>=inNum && num1<= outNum) {
//					int room = rs.getInt("roomnum");
////					System.out.println(room+"번 방에 이미 예약이 되어있습니다.");
//					fullroom.add(room);
//				}
//			}
//			int size = list.size();
//			System.out.println("check2");
//			for (int i =0; i<size; i++) {
//				for(int j= 0; j<fullroom.size();j++) {
//					if(list.get(i).getRoomnum() == fullroom.get(j)) {
//						list.remove(i);
//					}
//				}
//			}
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("check3");
//		return list;
//	}
	public ArrayList<Integer> dateCheckbyDate_modify(int resNum, int hotelNum, int inNum, int outNum,
			ArrayList<Integer> list) {
		String sql = "select * from reservationInfo where hotelnum = ? and resnum != ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, hotelNum);
			ps.setInt(2, resNum);
			rs = ps.executeQuery();
			ArrayList<Integer> fullroom = new ArrayList<>();
			
			while(rs.next()) {
				String checkin = rs.getString("checkin");
				String checkout = rs.getString("checkout");
				checkin = checkin.substring(0,10).replace("-", "");
				checkout = checkout.substring(0,10).replace("-", "");
				int num1 = Integer.parseInt(checkin);
				int num2 = Integer.parseInt(checkout);
				
				if((inNum >= num1 && inNum <= num2 )||(outNum>=num1 && outNum<=num2)) {
					int room = rs.getInt("roomnum");
//					System.out.println(room+"번 방에 이미 예약이 되어있습니다.");
					fullroom.add(room);
				}
				else if(num1>=inNum && num1<= outNum) {
					int room = rs.getInt("roomnum");
//					System.out.println(room+"번 방에 이미 예약이 되어있습니다.");
					fullroom.add(room);
				}
			}
			for(int i =0;i<fullroom.size();i++) {
				list.remove(fullroom.get(i));
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<RoomDTO> getRoom() {
		String sql = "select * from room";
		ArrayList<RoomDTO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				RoomDTO room = new RoomDTO(rs.getInt("roomnum"),rs.getString("type"),rs.getInt("price"));
				list.add(room);
			}
		} catch (SQLException e) {
		}
		return list;
	}

	public boolean insertReservaion(String userid, String checkin, String checkout, int roomNum, int hotelNum, int usepoolcnt, int usehealthcnt,int price,int days) {
		String sql = "insert into reservationInfo(userid, hotelnum, roomnum, checkin, checkout, days, usepoolcnt, usehealthcnt, price) values"
				+ "(?, ?, ?, ?, ?, ? ,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, userid);
			ps.setInt(2, hotelNum);
			ps.setInt(3, roomNum);
			ps.setString(4, checkin);
			ps.setString(5, checkout);
			ps.setInt(6, days);
			ps.setInt(7, usepoolcnt);
			ps.setInt(8, usehealthcnt);
			ps.setInt(9, price);
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			System.out.println("예약실패"+e);
		}
		return false;
	}

	public ArrayList<String> getReservationInfoByUserid(String userid) {
		String sql = "select * from reservationInfo join hotel using(hotelnum) where userid = ? order by resnum";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			ArrayList<String> reservation = new ArrayList<>();
			
			while(rs.next()) {
				reservation.add(String.format("예약번호 : %d\n호텔 이름 : %s\n방 번호 : %d\n체크인 : %.10s\n체크아웃 : %.10s\n"
						+ "숙박일수 : %d일\n수영장 이용가능 일수 : %d\n헬스장 이용가능 일수 : %d\n결제 금액 : %d원", 
						rs.getInt("resnum"), 
						rs.getString("hotelname"), 
						rs.getInt("roomnum"), 
						rs.getString("checkin"), 
						rs.getString("checkout"),
						rs.getInt("days"),
						rs.getInt("usepoolcnt"), 
						rs.getInt("usehealthcnt"),
						rs.getInt("price")));
			}
			return reservation;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	public ArrayList<ReservationDTO> getReservationByUserid(String userid) {
		String sql = "select * from reservationInfo where userid = ? order by resnum";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			ArrayList<ReservationDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				ReservationDTO reservation = new ReservationDTO(
						rs.getInt("resnum"), rs.getString("userid"), rs.getInt("hotelnum"), rs.getInt("roomnum"),rs.getString("checkin"), 
						rs.getString("checkout"), rs.getInt("days"), rs.getInt("usepoolcnt"), rs.getInt("usehealthcnt"), rs.getInt("price"));
				list.add(reservation);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	public ArrayList<ReservationDTO> getReservationByresNum(int resNum) {
		String sql = "select * from reservationInfo where resnum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, resNum);
			rs = ps.executeQuery();
			ArrayList<ReservationDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				ReservationDTO reservation = new ReservationDTO(
						rs.getInt("resnum"), rs.getString("userid"), rs.getInt("hotelnum"), rs.getInt("roomnum"),rs.getString("checkin"), 
						rs.getString("checkout"), rs.getInt("days"), rs.getInt("usepoolcnt"), rs.getInt("usehealthcnt"), rs.getInt("price"));
				list.add(reservation);
			}
			return list;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public boolean deleteReservationByResnum(int resNum) {
		String sql = "delete from reservationInfo where resnum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, resNum);
			int result = ps.executeUpdate();
			
			return result ==1;
		} catch (SQLException e) {
		}
		return false;
	}
	
	public ArrayList<String> getHotel() {
		String sql = "select * from hotel";
		ArrayList<String> hotel = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
//				hotel.add(String.format("%d.%s", rs.getInt("hotelnum"), rs.getString("hotelname")));
				hotel.add(String.format("%s", rs.getString("hotelname")));
			}
			return hotel;
		} catch (SQLException e) {
		}
		return null;
	}

	public int getHotelNumByHotelName(String hotelName) {
		String sql ="select hotelnum from hotel where hotelname = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelName);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("hotelnum");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

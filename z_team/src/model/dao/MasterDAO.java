package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.DBConnection;

public class MasterDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	public MasterDAO() {
		conn = DBConnection.getConnection();
	}

	public ArrayList<String> getBlacklist() {
		String sql = "select * from blacklist";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<String> list = new ArrayList<>();
			while(rs.next()) {
				list.add(String.format("%s\t%s\t%s", rs.getString("userid"),rs.getString("userphone"), rs.getString("reason")));
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

	public boolean insertBlacklistByUserphone(String userid, String addBlack, String reason) {
		String sql = "insert into blacklist values (?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reason);
			ps.setString(2, userid);
			ps.setString(3, addBlack);
			
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertBlacklistByUserid(String addBlack, String userphone, String reason) {
		String sql = "insert into blacklist values (?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reason);
			ps.setString(2, addBlack);
			ps.setString(3, userphone);
			
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteBlacklistByUserphone(String deleteBlack) {
		String sql = "delete from blacklist where userphone = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, deleteBlack);
			
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean deleteBlacklistByUserid(String deleteBlack) {
		String sql = "delete from blacklist where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, deleteBlack);
			
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean inserthotel(String hotelname) {
		String sql = "insert into hotel(hotelname) values (?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelname);
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletehotel(String hotelname) {
		String sql = "delete from hotel where hotelname = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hotelname);
			
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertRoom(int roomnum, String type, int price) {
		String sql = "insert into room values(?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomnum);
			ps.setString(2, type);
			ps.setInt(3, price);
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteRoom(int roomnum) {
		String sql = "delete from room where roomnum = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roomnum);
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

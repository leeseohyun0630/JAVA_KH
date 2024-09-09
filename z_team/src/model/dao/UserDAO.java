package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.BlacklistDTO;
import model.dto.UserDTO;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}

	public UserDTO getUserByUserid(String userid) {
		String sql = "select * from user where userid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				UserDTO user = new UserDTO(
						rs.getString("userid"),
						rs.getString("userpw"),
						rs.getString("username"),
						rs.getString("userphone"),
						rs.getInt("userage"),
						rs.getString("gender"),
						rs.getInt("credit")
				);
				return user;
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : "+e);
		}
		return null;
	}

	public UserDTO getUserByUserphone(String addBlack) {
		String sql = "select * from user where userphone = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, addBlack);
			rs = ps.executeQuery();
			if(rs.next()) {
				UserDTO user = new UserDTO(
						rs.getString("userid"),
						rs.getString("userpw"),
						rs.getString("username"),
						rs.getString("userphone"),
						rs.getInt("userage"),
						rs.getString("gender"),
						rs.getInt("credit")
				);
				return user;
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : "+e);
		}
		return null;
	}
	
	public boolean insertUser(UserDTO user) {
		String sql = "insert into user values (?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3,	user.getUsername());
			ps.setString(4, user.getUserphone());
			ps.setInt(5, user.getUserage());
			ps.setString(6, user.getGender());
			ps.setInt(7, user.getCredit());
			
			int result = ps.executeUpdate();
			
			return result ==1;
		} catch (SQLException e) {
		}
		return false;
	}
	public boolean chargeCredit(int charge, String userid) {
		String sql = "update user set credit = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, charge);
			ps.setString(2, userid);
			int result = ps.executeUpdate();
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public ArrayList<UserDTO> getUserlistbyUserphone(String addBlack) {
		String sql ="select * from user where userphone = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, addBlack);
			
			rs = ps.executeQuery();
			
			ArrayList<UserDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				UserDTO user = new UserDTO(
						rs.getString("userid"),
						rs.getString("userpw"),
						rs.getString("username"),
						rs.getString("userphone"),
						rs.getInt("userage"),
						rs.getString("gender"),
						rs.getInt("credit")
				);
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<UserDTO> getUserlistbyUserid(String addBlack) {
		String sql ="select * from user where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, addBlack);
			
			rs = ps.executeQuery();
			
			ArrayList<UserDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				UserDTO user = new UserDTO(
						rs.getString("userid"),
						rs.getString("userpw"),
						rs.getString("username"),
						rs.getString("userphone"),
						rs.getInt("userage"),
						rs.getString("gender"),
						rs.getInt("credit")
				);
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<BlacklistDTO> getBlacklistbyUserphone(String deleteBlack) {
		String sql = "select * from blacklist where userphone = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, deleteBlack);
			
			rs = ps.executeQuery();
			
			ArrayList<BlacklistDTO> list = new ArrayList<>();
			while(rs.next()) {
				BlacklistDTO black = new BlacklistDTO(rs.getString("reason"), rs.getString("userid"), rs.getString("userphone"));
				list.add(black);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<BlacklistDTO> getBlacklistbyUserid(String deleteBlack) {
		String sql = "select * from blacklist where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, deleteBlack);
			
			rs = ps.executeQuery();
			
			ArrayList<BlacklistDTO> list = new ArrayList<>();
			while(rs.next()) {
				BlacklistDTO black = new BlacklistDTO(rs.getString("reason"), rs.getString("userid"), rs.getString("userphone"));
				list.add(black);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.dto.UserDTO;

public class UserDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public UserDAO() {
		conn = DBConnection.getConnection();
	}
	
	public UserDTO getUserByUserid(String userid) {
		//데이터 로직은 순수하게 데이터에 관련된 로직만 구성되어 있다.
		//뭔진 몰라도 넘겨진 userid로 User객체 찾아서 돌려주기만 하면 끝
		//목표 : API 이용해서 데이터베이스 접근 후 객체로 리턴
		
		//검색
		String sql = "select * from user where userid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			
			//결과가 있다면 한 줄 꺼내서
			if(rs.next()) {
				//객체로 만들고
				UserDTO user = new UserDTO(
						rs.getString("userid"),
						rs.getString("userpw"),
						rs.getString("username"),
						rs.getInt("userage"),
						rs.getString("userphone"),
						rs.getString("useraddr")
				);
				//리턴
				return user;
			}
		} catch (SQLException e) {
			System.out.println("예외발생 : "+e);
		}
		//결과가 없다면 null 리턴
		return null;
	}

	public boolean insertUser(UserDTO user) {
		String sql = "insert into user values(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.setInt(4, user.getUserage());
			ps.setString(5, user.getUserphone());
			ps.setString(6, user.getUseraddr());
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	//											"userphone"
	public boolean updateUser(String loginUser, String col, String newData) {
		/*
		 update user
		 set userphone = '01011111111'
		 where userid = 'apple'
		*/
		String sql = "update user set "+col+" = ? where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, loginUser);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}

	public void deleteUser(String loginUser) {
		String sql = "delete from user where userid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginUser);
			
			ps.executeUpdate();
		} catch (SQLException e) {
		}
	}
}














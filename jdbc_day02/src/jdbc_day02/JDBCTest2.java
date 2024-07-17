package jdbc_day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest2 {
	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
		String data1 = "Hello JDBC";
		
		
//		String sql = "insert into test (strdata, timedata) values('"+data1+"', now())";
//		String sql = String.format("insert into test (strdata, timedata) values('%s', now())", data1);
	
		String sql = "insert into test (strdata, timedata) values(?, now())";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data1);
			
			int result = ps.executeUpdate();
			
			if(result == 1) {
				System.out.println("성공");
			}
			else {
				System.out.println("실패");
				
			}
		} catch (SQLException e) {
		}
	
	
	
	}
}

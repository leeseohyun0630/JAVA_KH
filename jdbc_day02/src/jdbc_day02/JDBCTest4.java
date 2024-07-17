package jdbc_day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색하실 strData : ");
		String strdata = sc.nextLine();
		
		String sql = "select * from test where strdata = ?";
		Connection conn = DBConnection.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, strdata);
			
			ResultSet rs = ps.executeQuery();
			
			String result = "";
			while(rs.next()) {
				result += rs.getInt("num")+"/";
				result += rs.getString("strdata")+"/";
				result += rs.getDouble("doubledata")+"/";
				result += rs.getString("timedata")+"\n";
			}
			
			System.out.println(result);
			
		} catch (SQLException e) {
		}
		
	}
}

package jdbc_day01;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class JDBCTest1 {
	public static void main(String[] args) {
		Scanner sc = Scanner(System.in);
		try {
//			설계도 불러오기, 설계도 준비시키기
			Class.forName("com.mysql.cj.jdbc.Driver");
//			다리를 짓기 위한 정보들
//			"127.0.0.1:3306/gb"
//			"localhost:3306/gb"
//			목적지
			String url = "jdbc:mysql://localhost:3306/gb";
//			연결을 위한 계정 정보들
			String user = "root";
			String password = "1234";
			
//			다리 만들기
			Connection conn =  DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			
			String strdata = "JDBC Test data1";
			double doubledata = 10.0;
			String timedata = "1111-11-11 11:11:11";
			
			String sql = "insert into test(strdata, doubledata, timedata) "
					+ "values('"+strdata+"','"+doubledata+"','"+timedata+"');";
			System.out.println(sql);
			
//			전달 준비
			PreparedStatement ps = conn.prepareStatement(sql);
//			전달 시작
			int result = ps.executeUpdate();
			if(result == 1) {
				System.out.println("워크벤치에서 확인하기");
			}
			else {
				System.out.println("오타3");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("오타1"+e);
		} catch (SQLException sqle) {
			System.out.println("오타2"+sqle);
		}
		
		
	}

	private static Scanner Scanner(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
}

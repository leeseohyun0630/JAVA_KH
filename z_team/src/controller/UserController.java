package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.Session;
import model.dao.UserDAO;
import model.dto.UserDTO;

public class UserController {
	public boolean checkId(String userid) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		return user == null;
	}
	
	public boolean join(UserDTO user) {
		UserDAO udao = new UserDAO();
		return udao.insertUser(user);
	}
	
	public boolean login(String userid, String userpw) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		if (user != null) {
			if(user.getUserpw().equals(userpw)) {
			
				Session.setData("loginUser", user.getUserid());
				return true;
			}
		}
		return false;
	}
	
	public int getCredit(String userid) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		int credit = user.getCredit();
		return credit;
	}

	public void charge(int charge, String userid) {
		UserDAO udao = new UserDAO();
		if(udao.chargeCredit(charge,userid)) {
			System.out.println("충전에 성공하셨습니다!");
		}
	}
	
	public void creditUpdate(int credit, String userid) {
		UserDAO udao = new UserDAO();
		udao.chargeCredit(credit,userid);
	}

	public String getUserInfo(String userid) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		
		String userInfo = String.format("아이디 : %s\n비밀번호 : %s\n이름 : %s\n전화번호 : %s\n나이 : %d\n성별 %s\n잔액 : %d",
				user.getUserid(), user.getUserpw(), user.getUsername(), user.getUserphone(), user.getUserage(),user.getGender(),user.getCredit());
		return userInfo;
	}
	
	
	
}

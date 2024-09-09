package view;

import java.util.Scanner;

import controller.UserController;
import model.Session;

public class LoginView {
	public LoginView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		
		System.out.print("아이디 : ");
		String userid = sc.next();
		System.out.print("비밀번호 : ");
		String userpw = sc.next();
		
		if(controller.login(userid,userpw)) {
			System.out.println(Session.getData("loginUser")+"님 환영합니다!");
			new MainView(userid);
		}
		else {
			System.out.println("로그인 실패 / 아이디 혹은 비밀번호가 맞지 않습니다.");
		}
	}
}
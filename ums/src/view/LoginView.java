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
//			System.out.println(userid+"님 어서오세요~");
			System.out.println(Session.getData("loginUser")+"님 어서오세요~");
			//메인으로 이동
			new MainView();
		}
		else {
			System.out.println("로그인 실패 / 아이디 혹은 비밀번호를 다시 확인해주세요~");
		}
	}
}





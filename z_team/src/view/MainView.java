package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ReservationController;
import controller.UserController;
import model.Session;
import model.dao.UserDAO;
import model.dto.UserDTO;

public class MainView {
	public MainView(String userid){
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		ReservationController rescon = new ReservationController();
		System.out.println("---메뉴화면---");
		
		while(true) {
			System.out.println("1. 호텔예약\n2. 예약확인\n3. 예약변경\n4. 회원정보\n5. 로그아웃");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				System.out.println(Session.getData("loginUser")+"님 로그아웃 되었습니다.");
				Session.setData("loginUser", null);
				break;
			}
			
			switch(choice) {
			case 1:
				new ReservationView(userid);
				break;
			case 2:
				ArrayList<String> reservation = rescon.getReservationInfo(userid);
				
				if(reservation.size() == 0) {
					System.out.println("예약된 호텔이 없습니다.");
					break;
				}
				System.out.println("----------------------------");
				for(String s : reservation) {
					System.out.println(s);
					System.out.println("----------------------------");
				}
				break;
			case 3:
				new ModifyView(userid);
				break;
			case 4:
				String userInfo = controller.getUserInfo(userid);
				System.out.println("----------------------------");
				System.out.println(userInfo);
				System.out.println("----------------------------");
			}
		}
	}
}

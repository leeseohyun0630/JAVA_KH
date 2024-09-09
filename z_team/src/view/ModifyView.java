package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ReservationController;
import controller.UserController;

public class ModifyView {
	public ModifyView(String userid) {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		ReservationController rescon = new ReservationController();
		
		
		while(true) {
			System.out.println("1. 예약수정\n2. 예약취소 \n3. 뒤로가기");
			int choice = sc.nextInt();
			if(choice == 1) {
				ArrayList<String> reservation = rescon.getReservationInfo(userid);
				System.out.println("----------------------------");
				for(String s : reservation) {
					System.out.println(s);
					System.out.println("----------------------------");
				}
				System.out.println("수정하실 예약의 번호를 입력해주세요 : ");
				
				int resNum = sc.nextInt();
				ArrayList<Integer> list = rescon.getResnum(userid);
				boolean flag = false;
				for(Integer l : list) {
					if(resNum == l) {
						flag = true;
					}
				}
				if(flag) {
					new ModyfyReservationView(userid,resNum);
					break;
				}
				else {
					System.out.println("잘못된 예약번호를 입력하셨습니다.");
				}
			}
			else if(choice == 2) {
				ArrayList<String> reservation = rescon.getReservationInfo(userid);
				System.out.println("----------------------------");
				for(String s : reservation) {
					System.out.println(s);
					System.out.println("----------------------------");
				}
				System.out.println("취소하실 예약의 번호를 입력해주세요 : ");
				int resNum = sc.nextInt();
				ArrayList<Integer> list = rescon.getResnum(userid);
				boolean flag = false;
				for(Integer l : list) {
					if(resNum == l) {
						flag = true;
					}
				}
				if(flag) {
					int credit = controller.getCredit(userid);
					int price = rescon.getPrice(resNum);
					credit += price;
					if(rescon.deleteReservation(resNum)) {
						System.out.println("예약이 취소되었습니다!");
						controller.creditUpdate(credit, userid);
						break;
					}
				}
				else {
					System.out.println("잘못된 예약번호를 입력하셨습니다.");
				}
			}
			else if(choice == 3) {
				break;
			}
		}
	}
}

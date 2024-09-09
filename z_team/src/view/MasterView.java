package view;

import java.util.Scanner;

import controller.MasterController;

public class MasterView {
	public MasterView() {
		Scanner sc = new Scanner(System.in);
		MasterController master = new MasterController();
		while(true) {
			System.out.println("1. 블랙리스트 관리\n2. 호텔 관리\n3. 방 관리\n4. 종료");
			int choice = sc.nextInt();
			if (choice == 4) {
				break;
			}
			if (choice == 1) {
				new BlacklistView();
			}
			else if(choice == 2) {
				new HotelView();
				
			}
			else if(choice == 3) {
				new RoomView();
			}
		}
	}
}

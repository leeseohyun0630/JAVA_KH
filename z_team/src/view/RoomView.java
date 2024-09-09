package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MasterController;
import controller.ReservationController;

public class RoomView {
	public RoomView() {
		Scanner sc = new Scanner(System.in);
		MasterController master = new MasterController();
		ReservationController rescon = new ReservationController();
		
		while(true) {
			System.out.println("1. 방 목록\n2. 방 추가\n3. 방 삭제\n4. 뒤로가기");
			int choice = sc.nextInt();
			
			if(choice == 4) {
				break;
			}
			else if(choice == 1) {
				ArrayList<String> roomList = master.roomList();
				if(roomList.size() != 0) {
					System.out.println("방번호\t분류\t가격");
					for(String s : roomList) {
						System.out.println(s);
					}
				}
			}
			else if(choice == 2) {
				System.out.print("추가할 방 번호를 입력하세요 : ");
				int roomnum = sc.nextInt();
				System.out.print("추가할 방의 분류를 입력하세요 : ");
				String type = sc.nextLine();
				type = sc.nextLine();
				System.out.println("추가할 방의 가격을 입력하세요 : ");
				int price = sc.nextInt();
				
				if(master.insertRoom(roomnum, type, price)) {
					System.out.println("추가에 성공하셨습니다!");
				}
			}
			else if(choice == 3) {
				System.out.print("삭제할 방 번호를 입력하세요 : ");
				int roomnum = sc.nextInt();
				
				if(master.deleteRoom(roomnum)) {
					System.out.println("삭제에 성공하셨습니다!");
				}
			}
		}
	}
}

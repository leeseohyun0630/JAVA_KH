package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MasterController;
import controller.ReservationController;

public class HotelView {
	public HotelView() {
		Scanner sc = new Scanner(System.in);
		MasterController master = new MasterController();
		ReservationController rescon = new ReservationController();
		
		while(true) {
			System.out.println("1. 호텔목록\n2. 호텔추가\n3. 호텔삭제\n4. 뒤로가기");
			int choice = sc.nextInt();
			
			if(choice == 4 ) {
				break;
			}
			else if(choice == 1) {
				ArrayList<String> hotel = rescon.getHotel();
				for(String s : hotel) {
					System.out.print(s+"\t");
				}
				System.out.println();
			}
			else if(choice == 2) {
				System.out.print("추가할 호텔의 이름을 입력하세요 : ");
				String hotelname = sc.nextLine();
				hotelname = sc.nextLine();
				if(master.inserthotel(hotelname)) {
					System.out.println("추가가 완료되었습니다!");
				}
			}
			else if(choice == 3) {
				sc.nextLine();
				System.out.print("삭제할 호텔의 이름을 입력하세요 : ");
				String hotelname = sc.nextLine();
				if(master.deletehotel(hotelname)) {
					System.out.println("호텔이 목록에서 제거되었습니다.");
				}
			}
		}
	}
}

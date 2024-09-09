package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ReservationController;
import controller.UserController;
import model.dao.ReservationDAO;
import model.dto.RoomDTO;
import model.dto.UserDTO;

public class ReservationView {
	public ReservationView(String userid) {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		ReservationController rescon = new ReservationController();
		ReservationDAO rdao = new ReservationDAO();
		
		String checkin;
		String checkout;
		System.out.println("체크인 날짜를 입력해 주세요");
		try {
			System.out.print("예약 년도 : ");
			int year = sc.nextInt();
			System.out.print("예약 월 : ");
			int month = sc.nextInt();
			System.out.print("예약 일 : ");
			int day = sc.nextInt();
			checkin = rescon.makeDate(year, month, day);
			if(rescon.isDate(checkin) == false) {
				System.out.println("잘못된 날짜를 입력하셨습니다!");
				return;
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요!");
			return;
		}
		System.out.println("체크인 날짜 : "+checkin);
		if(rescon.checktoday(checkin) == false) {
			System.out.println("현재시점보다 이전 날짜에는 예약할 수 없습니다.");
			return;
		}
		System.out.println("체크아웃 날짜를 입력해 주세요");
		try {
			System.out.print("예약 년도 : ");
			int year = sc.nextInt();
			System.out.print("예약 월 : ");
			int month = sc.nextInt();
			System.out.print("예약 일 : ");
			int day = sc.nextInt();
			checkout = rescon.makeDate(year, month, day);
			if(rescon.isDate(checkout) == false) {
				System.out.println("잘못된 날짜를 입력하셨습니다!");
				return;
			}
		} catch (Exception e) {
			System.out.println("숫자를 입력해주세요!");
			return;
		}
		System.out.println("체크아웃 날짜 : "+checkout);
		String temp1 = "";
		String temp2 = "";
		temp1 = checkin.replace("-", "");
		temp2 = checkout.replace("-", "");
		int inNum = Integer.parseInt(temp1);
		int outNum = Integer.parseInt(temp2);
		if(inNum>outNum) {
			System.out.println("체크아웃 날짜는 체크인 날짜 이후로 입력해주세요!");
			return;
		}
		ArrayList<String> hotel = rescon.getHotel();
		System.out.println("예약할 호텔 이름을 입력해 주세요");
		for(String s : hotel) {
			System.out.print(s+"\t");
		}
		System.out.println();
		
		sc.nextLine();
		String hotelName = sc.nextLine();
		int hotelNum = rescon.getHotelNum(hotelName);
		
		ArrayList<Integer> list = rescon.dateCheck(hotelNum, inNum, outNum);
		ArrayList<RoomDTO> room = rdao.getRoom();
		
		System.out.println("예약이 가능한 방 목록");
		int[] roomtype = {0, 0, 0};
		for(int i=0; i<list.size(); i++) {
			for(int j = 0; j<room.size(); j++) {
				if(list.get(i) == room.get(j).getRoomnum()) {
					if((room.get(j).getType()).equals("싱글룸") && roomtype[0] ==  0){
						System.out.println("\n -싱글룸-");
						System.out.print(list.get(i)+"\t");
						roomtype[0]++;
					}
					else if((room.get(j).getType()).equals("싱글룸")) {
						System.out.print(list.get(i)+"\t");
					}
					else if((room.get(j).getType()).equals("더블룸") && roomtype[1] ==  0) {
						System.out.println("\n -더블룸-");
						System.out.print(list.get(i)+"\t");
						roomtype[1]++;
					}
					else if((room.get(j).getType()).equals("더블룸")) {
						System.out.print(list.get(i)+"\t");
					}
					else if((room.get(j).getType()).equals("스위트룸") && roomtype[2] ==  0) {
						System.out.println("\n -스위트룸-");
						System.out.print(list.get(i)+"\t");
						roomtype[2]++;
					}
					else if((room.get(j).getType()).equals("스위트룸")) {
						System.out.print(list.get(i)+"\t");
					}
				}
			}
		}
		System.out.println();
		System.out.print("예약할 방을 선택하세요 : ");
		int roomNum = sc.nextInt();
		
		System.out.print("수영장을 이용하시겠습까?(y/n) : ");
		String usepool = sc.next();
		int usepoolcnt = 0;
		if(usepool.equals("y")||usepool.equals("Y")) {
			System.out.println("며칠간 이용하시겠습니까? : ");
			usepoolcnt = sc.nextInt();
		}
		System.out.print("헬스장을 이용하시겠습까?(y/n) : ");
		String usehealth = sc.next();
		int usehealthcnt = 0;
		if(usehealth.equals("y")||usehealth.equals("Y")) {
			System.out.println("며칠간 이용하시겠습니까? : ");
			usehealthcnt = sc.nextInt();
		}
		int lodgment = rescon.claculateDate(checkin, checkout);
		int price = rescon.price(lodgment, roomNum, usepoolcnt,usehealthcnt);
		System.out.println("예약 금액 : "+price+"원");
		int credit = controller.getCredit(userid);
		System.out.println("현재 잔액 : "+credit+"원");
		System.out.println("결제를 진행하시겠습니까?(y/n) : ");
		boolean flag = true;
		String payment = sc.next();
		if(payment.equals("y") || payment.equals("Y") ) {
			while(credit < price) {
				System.out.println("잔액이 부족합니다. 충전하시겠습니까?(y/n) : ");
				String charge = sc.next();
				if(charge.equals("y")||charge.equals("Y")) {
					new ChargeView(userid);
				}
				else {
					break;
				}
				credit = controller.getCredit(userid);
				if(credit<price){
					System.out.println("현재 잔액 : "+credit+"원");
				}
				flag = false;
			}
		}
		else {
			System.out.println("예약을 취소하셨습니다. 메인화면으로 돌아갑니다.");
			return;
		}
		if(credit<price) {
			System.out.println("예약을 취소하셨습니다. 메인화면으로 돌아갑니다.");
			return;
		}
		if (flag == false) {
			System.out.println("결제를 진행하시겠습니까?(y/n) : ");
			payment = sc.next();
			if(!(payment.equals("y") || payment.equals("Y")) ) {
				System.out.println("예약을 취소하셨습니다. 메인화면으로 돌아갑니다.");
				return;
			}
		}
		if(rescon.reservaion(userid, checkin, checkout, roomNum, hotelNum, usepoolcnt, usehealthcnt,price, lodgment)) {
			System.out.println("예약에 성공하셨습니다!");
		}
		credit -= price;
		System.out.println("현재 잔액 : " +credit+"원");
		controller.creditUpdate(credit, userid);
	}
}

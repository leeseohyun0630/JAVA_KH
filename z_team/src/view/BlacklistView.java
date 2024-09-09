package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.MasterController;

public class BlacklistView {
	public BlacklistView() {
		Scanner sc = new Scanner(System.in);
		MasterController master = new MasterController();
		while(true) {
			System.out.println("1. 블랙리스트 목록\n2. 블랙리스트 추가\n3. 블랙리스트 해제\n4. 뒤로가기");
			int choice = sc.nextInt();
			
			if(choice == 4) {
				break;
			}
			if(choice == 1) {
				ArrayList<String> list = master.getblacklist();
				if(list.size() != 0) {
					System.out.println("아이디\t전화번호\t\t사유");
				}
				for(String s : list) {
					System.out.println(s);
				}
			}
			else if(choice == 2) {
				sc.nextLine();
				System.out.print("추가할 회원의 아이디 또는 전화번호를 입력해주세요 : ");
				String addBlack = sc.nextLine();
				boolean flag = master.isUser(addBlack);
				if(flag) {
					System.out.print("블랙리스트 사유를 적어주세요 : ");
					String reason = sc.nextLine();
					master.insertBlacklist(addBlack, reason);
				}
				else {
					System.out.println("잘못된 정보를 입력하셨습니다.");
				}
			}
			else if(choice == 3) {
				sc.nextLine();
				System.out.print("차단해제할 아이디 또는 전화번호를 입력해주세요 : ");
				String deleteBlack = sc.nextLine();
				boolean flag = master.isBlacklist(deleteBlack);
				if(flag) {
					master.deleteBlacklist(deleteBlack);
				}
				else {
					System.out.println("잘못된 정보를 입력하셨습니다.");
				}
			}
		}
	}
}

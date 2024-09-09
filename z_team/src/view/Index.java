package view;

import java.util.Scanner;

public class Index {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("§☆★☆★☆★호텔 예약★☆★☆★☆§");
		while(true) {
			System.out.println("1. 회원가입\n2. 로그인\n3. 종료하기\n\n0. 관리자모드");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				new JoinView();
			}
			else if(choice == 2) {
				new LoginView();
			}
			else if(choice == 3) {
				System.out.println("이용해 주셔서 감사합니다.");
				break;
			}
			else if(choice == 0) {
				System.out.println("관리자 모드 실행");
				System.out.println("관리자 비밀번호 입력 : ");
				String password = sc.nextLine();
				password = sc.nextLine();
				if(password.equals("1234")) {
					new MasterView();
				}
				else {
					System.out.println("비밀번호가 맞지 않습니다.");
				}
			}
		}
	}
}

package view;

import java.util.Scanner;

import controller.UserController;

public class ChargeView {
	public ChargeView(String userid) {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		System.out.print("충전할 금액을 입력하세요 : ");
		try {
			int charge = sc.nextInt();
			charge += controller.getCredit(userid);
			controller.charge(charge,userid);
		} catch (Exception e) {
			System.out.println("숫자를 입력해 주세요!");
		}
	}
}

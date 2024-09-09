package view;

import java.util.Scanner;

import controller.UserController;
import model.dto.UserDTO;

public class JoinView {
	public JoinView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		System.out.println("======회원가입 페이지 입니다======");
		System.out.print("아이디 : ");
		String userid = sc.nextLine();
		try {
			int checkid = Integer.parseInt(userid);
			System.out.println("숫자로만 구성된 아이디는 생성이 불가능합니다.");
			return;
		} catch (NumberFormatException e) {
		}
		if(controller.checkId(userid)) {
			System.out.print("비밀번호 : ");
			String userpw = sc.nextLine();
			System.out.print("비밀번호 확인 : ");
			String userpw_re = sc.nextLine();
			if(userpw.equals(userpw_re)) {
				System.out.print("이름 : ");
				String username = sc.nextLine();
				System.out.print("나이 : ");
				String userage = sc.nextLine();
				System.out.print("핸드폰 번호 : ");
				String userphone = sc.nextLine();
				System.out.print("성별 : ");
				String gender = sc.nextLine();
				int credit = 0;
				
				UserDTO user = new UserDTO(userid, userpw_re, username, userphone, Integer.parseInt(userage), gender, credit);
				
				if(controller.join(user)) {
					System.out.println("회원가입 성공!");
				}
				else {
					System.out.println("회원가입 실패... / 다음에 다시 시도해 주세요~");
				}
			}
			else {
				System.out.println("비밀번호 확인을 다시 해주세요!");
			}
		}
		else {
			System.out.println("중복된 아이디가 있습니다!");
		}
	}
}
package view;

import java.util.HashMap;
import java.util.Scanner;

import controller.UserController;
import model.Session;
import model.dto.UserDTO;

public class MyInfoView {
	public MyInfoView() {
		Scanner sc = new Scanner(System.in);
		UserController controller = new UserController();
		
		String loginUser = (String)Session.getData("loginUser");
		HashMap<String, Object> datas = controller.getDetail(loginUser);
		UserDTO user = (UserDTO)datas.get("user");
		int prodCnt = (Integer)datas.get("prodCnt");
		
		System.out.println("====="+loginUser+"님의 회원 정보 =====");
		System.out.println("아이디 : "+user.getUserid());
		System.out.println("비밀번호 : "+user.getUserpw());
		System.out.println("핸드폰 번호 : "+user.getUserphone());
		System.out.println("주소 : "+user.getUseraddr());
		System.out.println("올린 상품의 개수 : "+prodCnt);
		System.out.println("==================================");
		System.out.println("1. 비밀번호 수정\n2. 핸드폰 번호 수정\n3. 주소 수정\n4. 수정 취소\n5. 회원 탈퇴");
		int choice = sc.nextInt();
		if(choice == 4) {
			System.out.println("메인으로 돌아갑니다.");
		}
		else if(choice == 5) {
			// 회원 탈퇴
			System.out.print("비밀번호 재 입력 : ");
			String userpw = sc.next();
			if(user.getUserpw().equals(userpw)) {
				if(controller.leaveId(loginUser)) {
					System.out.println(loginUser+"님 회원 탈퇴 성공");
				}
				else {
					System.out.println("회원 탈퇴 실패");
				}
			}
		}
		else {
			System.out.print("새로운 정보 : ");
			sc = new Scanner(System.in);
			String newData = sc.nextLine();
//			Read를 제외한 Create, Update, Delete의 경우에는 그 엔티티의 컨트롤러를 요청한다.
			if(controller.modifyUser(loginUser, choice, newData)){
				System.out.println("정보 수정 완료");
			}
			else {
				System.out.println("정보 수정 실패");
			}
		}
		
		
	}
}

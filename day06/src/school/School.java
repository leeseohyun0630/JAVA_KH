package school;

import java.util.Scanner;

public class School {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		View view = new View();
		
		while(true) {
			System.out.println("1. 학생 추가\n2. 학생 목록\n3. 학생 삭제\n4. 학생 수정"
					+ "\n5. 성적 입력\n6. 석차 보기\n7. 나가기");
			int choice = sc.nextInt();
			if(choice == 7) {
				// 종료
				System.out.println("안녕히 가세요.");
				break;
			}
			switch(choice) {
			case 1:
				view.addStudent();
				break;
				
			case 2:
				view.showList();
				break;
				
			case 3:
				view.removeStudent();
				break;
				
			case 4:
				view.modifyStudent();
				break;
				
			case 5:
				view.recordScore();
				break;
				
			case 6:
//				manager = new Manager();
//				System.out.println(manager.getRanking());
//				
//				// temp1 = 6, temp2 =10
//				// int temp3 = temp1;
//				// temp1 = temp2;
//				// temp2 = temp3;
//				for (int i = 0; i < studCnt; i++) {
//					Student temp1 = list[i];
//					for (int j = 0; j <studCnt; j++) {
//						Student temp2 = list[j];
//						if(temp1.tot<temp2.tot) {
//							Student temp3 = temp1;
//							temp1 = temp2;
//							temp2 = temp3;
//						}
//					}
//					String data = String.format("%s(%d반 %d번) - 총점 : %d점",temp1.name,temp1.ban,temp1.bun,temp1.tot);
//					System.out.println(data);
//				}
////				for (int i = 0; i < studCnt; i++) {
////					Student temp1 = list[i];
////					String data = String.format("%s(%d반 %d번) - 총점 : %d점",temp1.name,temp1.ban,temp1.bun,temp1.tot);
////					System.out.println(data);
////				}
//				break;
			default:
				System.out.println("잘못된 번호를 입력하셨습니다.");
				break;
			}
		}
	}
}

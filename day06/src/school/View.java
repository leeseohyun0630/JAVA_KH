package school;

import java.util.Scanner;

public class View {
	
	void addStudent() {
		String name;
		int ban;
		int bun;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름 입력 : ");
		name = sc.next();
		System.out.println("반 입력 : ");
		ban = sc.nextInt();
		System.out.println("번호 입력 : ");
		bun = sc.nextInt();
		
		Manager manager = new Manager();
		manager.insert(name, ban, bun);
		
		System.out.println(name+" 학생 등록 완료!");
	}
	
	void showList() {
		System.out.println("============ KH 고등학교 학생목록 =============");
		Manager manager = new Manager();
		manager = new Manager();
		System.out.println(manager.selectAll());
		System.out.println("===========================================");
	}
	
	void removeStudent() {
		int ban;
		int bun;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반 입력 : ");
		ban = sc.nextInt();
		System.out.println("번호 입력 : ");
		bun = sc.nextInt();
		
		Manager manager = new Manager();
		manager = new Manager();
		int idx = manager.selectIdx(ban, bun);
		
		if(idx == -1) {
			System.out.println("일치하는 학생을 찾을 수 없습니다!");
		}
		else {
			// 삭제 진행
			manager.delete(idx);
			
			System.out.println("학생 삭제 완료!");
		}
	}
	
	void modifyStudent() {
		int ban;
		int bun;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반 입력 : ");
		ban = sc.nextInt();
		System.out.println("번호 입력 : ");
		bun = sc.nextInt();
		
		Manager manager = new Manager();
		manager = new Manager();
		Student temp = manager.select(ban, bun);
		
		if(temp == null) {
			System.out.println("일치하는 학생을 찾을 수 없습니다!");
		}
		else {
			System.out.print("새로운 이름 : ");
			temp.name = sc.next();								// 원래는 처리기 때문에 여기에 이렇게 입력하면 안됨.
//			name = sc.next();
//			manager.update(temp, name);
			System.out.println("학생 수정 성공!");
		}
	}
	
	void recordScore() {
		int ban;
		int bun;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("반 입력 : ");
		ban = sc.nextInt();
		System.out.println("번호 입력 : ");
		bun = sc.nextInt();
		
		Manager manager = new Manager();
		manager = new Manager();
		Student temp1 = manager.select(ban, bun);
		
		if(temp1 == null) {
			System.out.println("일치하는 학생을 찾을 수 없습니다!");
		}
		else {
			System.out.println("국어 점수 입력 : ");
			temp1.kor = sc.nextInt();
			System.out.println("영어 점수 입력 : ");
			temp1.eng = sc.nextInt();
			System.out.println("수학 점수 입력 : ");
			temp1.math = sc.nextInt();
			
			temp1.tot = temp1.kor+temp1.eng+temp1.math;
			System.out.println("성적 입력 성공!");
		}
	}
}

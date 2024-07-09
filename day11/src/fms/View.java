package fms;

import java.util.Scanner;

public class View {
	public static void main(String[] args) {
		index();
	}
	static void index() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 데이터 추가\n2. 데이터 수정\n3. 데이터 삭제\n4. 데이터 전체 조회\n5. 나가기");
			int choice = sc.nextInt();
			
			if(choice == 5) {
				break;
			}
			switch (choice) {
			case 1: 
				addView();
				break;
			case 2: 
				modifyView();
				break;
			case 3: 
				deleteView();
				break;
			case 4: 
				checkView();
				break;
			default : 
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		}
	}
	
	static void addView() {
		Scanner sc = new Scanner(System.in);
		System.out.print("추가할 데이터  : ");
		String data = sc.nextLine();
		
		// 데이터 포장
		Model model = new Model();
		model.data = data;
		
		// 추가
		Controller controller = new Controller();
		controller.insert(model);
		
		System.out.println(data+" 데이터가 추가 되었습니다.");
	}
	
	static void modifyView() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 데이터 : ");
		String data1 = sc.nextLine();
		System.out.print("변경할 데이터 : ");
		String data2 = sc.nextLine();
		
		Controller controller = new Controller();
		controller.modify(data1, data2);
		
		System.out.println(data1+"이 "+data2+"로 데이터가 수정 되었습니다.");
	}
	
	static void deleteView() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 데이터  : ");
		String data = sc.nextLine();
		
		Controller controller = new Controller();
		controller.delete(data);
		
		System.out.println(data+" 데이터가 삭제 되었습니다.");
	}
	
	static void checkView() {
		System.out.println("데이터 전체 조회 창");
		System.out.println("==============");
		
		Controller controller = new Controller();
		controller.check();
		System.out.println("==============");
	}
	
}

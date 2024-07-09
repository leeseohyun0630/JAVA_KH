package day04;

import java.util.Date;
import java.util.Scanner;

public class MethodTest {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		sc.next();
		
		MethodTest m = new MethodTest();
		System.out.println("f(3) 호출 결과 : "+m.f(3));
		System.out.println();
		
		m.sayHello();
		System.out.println();
		
		m.printName();
		System.out.println();
		
		System.out.println(m.getGift("착한일"));
		System.out.println();
		
		System.out.println(m.getTime());
		System.out.println();
		
		m.printDan(7);
		System.out.println();
										
	}
	// f(x) = 2x+1
	int f(int x) {						
		System.out.println("Hello!");	
		return 2*x+1;					
	}
	
	// Hello라고 인사해주는 메소드	
	
	void sayHello() {
		System.out.println("Hello");
	}
	
	// 내 이름을 10번 출력하는 메소드
	
	void printName() {
		for (int i = 0; i < 10; i++) {
			System.out.println("LSH "+(i+1));
		}
	}
	
	// 착한 일을 하면 선물을 돌려주는 메소드
	// 메소드 이름이 get~~이다 : ~~를 받아오기 위해 호출하는 메소드(보통 return 값이 있다는 뜻)
	
	String getGift(String action) {
		String result ="";
		if(action.equals("착한일")) {
			result ="선물";
			return result;
		}
		else {
			result =" ";
			return result;
		}
	}
	
	// 현재 시간정보를 알려주는 메소드
	Date getTime() {
		return new Date();
	}
	
	//구구단의 한 단을 출력해주는 메소드
	void printDan(int dan) {
		for (int i = 1; i <=9; i++) {
			System.out.printf("%d X %d = %d\n", dan, i, dan*i);
		}
	}
}

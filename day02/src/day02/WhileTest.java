package day02;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String choice = "";
//		// 1. while
//		while(!choice.equals("3")) {
//			System.out.println("다음 중 프로그래밍 언어가 아닌것은? \n1. C언어\n2. Java\n3. 망둥어\n4. 파이썬");
//			choice = sc.next();
//			
//			// 문자열은 == 으로 비교불가. 문자열1.equals("문자열2") -> 일치시 true
//			if(choice.equals("3")) {
//				System.out.println("정답입니다.");
//			}
//			else if(choice.equals("1")||choice.equals("2")||choice.equals("4")) {
//				System.out.println("오답입니다.");
//			}
//			else {
//				System.out.println("잘못 입력하셨습니다.");
//			}
//		}
//		String choice = "";
//		// 2. do ~ while
//		do {
//			System.out.println("다음 중 프로그래밍 언어가 아닌것은? \n1. C언어\n2. Java\n3. 망둥어\n4. 파이썬\n0. 나가기");
//			choice = sc.next();
//			
//			// 문자열은 == 으로 비교불가. 문자열1.equals("문자열2") -> 일치시 true
//			if(choice.equals("3")) {
//				System.out.println("정답입니다.");
//			}
//			else if(choice.equals("1")||choice.equals("2")||choice.equals("4")) {
//				System.out.println("오답입니다.");
//			}
//			else if(choice.equals("0")) {
//				System.out.println("안녕히가세요.");
//			}
//			else {
//				System.out.println("잘못 입력하셨습니다.");
//			}
//		}
//		while(!choice.equals("0"));
		
		String choice = "";
		// 3. while(true) 무한반복
		while(true) {
			System.out.println("다음 중 프로그래밍 언어가 아닌것은? \n1. C언어\n2. Java\n3. 망둥어\n4. 파이썬\n0. 나가기");
			choice = sc.next();
			
			// 문자열은 == 으로 비교불가. 문자열1.equals("문자열2") -> 일치시 true
			if(choice.equals("3")) {
				System.out.println("정답입니다.");
			}
			else if(choice.equals("1")||choice.equals("2")||choice.equals("4")) {
				System.out.println("오답입니다.");
			}
			else if(choice.equals("0")) {
				System.out.println("안녕히가세요.");
				break;
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}

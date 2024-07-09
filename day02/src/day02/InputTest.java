package day02;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성함을 입력해주세요 : ");
		
		String name = sc.next();
		System.out.println(name+"님 환영합니다.");
		
		System.out.print("주소를 입력해주세요 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		System.out.println("거주지는 \""+addr+"\" 입니다.");
		
		System.out.print("나이를 입력해주세요 : ");
		int age = sc.nextInt();
		System.out.println("당신은 5년 뒤에 "+(age+5) +"살입니다.");
		
	}

}

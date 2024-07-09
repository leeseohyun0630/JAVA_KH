package day01;

import java.util.Scanner;

public class InputTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성함을 입력해주세요 : ");
		
		String name = sc.next();
		System.out.println(name+"님 환영합니다.");
	}

}

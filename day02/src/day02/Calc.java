package day02;

import java.util.Scanner;

public class Calc {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 :");
		String num1 = sc.nextLine();
		System.out.print("두번째 정수 :");
		String num2 = sc.nextLine();
		
		// 처리
		// 입력받은 문자열을 정수로 변환
		int realNum1 = Integer.parseInt(num1);
		int realNum2 = Integer.parseInt(num2);
		// Double.parseDouble();
		// 정수로 변환한 수를 더하여 결과값에 대입
		int result = realNum1+realNum2;
		
		// 출력
		System.out.println("결과 값은 : "+result+"입니다.");
	}

}

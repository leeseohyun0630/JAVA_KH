package day02;

public class CastingTest {
	public static void main(String[] args) {
		// 정수와 정수의 연산 결과 -> 정수
		System.out.println(10/3);
		// 정수와 실수의 연산 결과 -> 실수
		System.out.println(10/3.0);
		
		System.out.println("==============================");
		System.out.println(10/(3+0.0));
		System.out.println(10/(3*1.0));
		
		System.out.println("==============================");
		// 아스키 코드 'A' = 65, 'a' = 97, '0' = 48
		System.out.println('A'+5);
		System.out.println((char)('A'+5));
		
	}
}

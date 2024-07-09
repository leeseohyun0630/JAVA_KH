package day02;

import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {		
		//사용자에게 정수 하나 입력 받아서 양수 음수 0을 판단하고 출력하기
		System.out.print("정수 입력 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("입력하신 "+num+"은 양수입니다.");
		}
		else if(num<0) {
			System.out.println("입력하신 "+num+"은 음수입니다.");
		}
		else{
			System.out.println("입력하신 "+num+"은 0입니다.");
		}
			
		String result = "";

		if(num > 0) {
			result = "입력하신 "+num+"은 양수입니다.";
		}
		else if(num<0) {
			result = "입력하신 "+num+"은 음수입니다.";
		}
		else{
			result = "입력하신 "+num+"은 0입니다.";
		}
		System.out.println(result);
	}
}

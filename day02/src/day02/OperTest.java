package day02;

import java.util.Scanner;

public class OperTest {
	public static void main(String[] args) {
		//System.out.println(10>3? "참입니다.": "거짓입니다.");
		
		//사용자에게 정수 하나 입력 받아서 양수 음수 0을 판단하고 출력하기
		System.out.print("정수 입력 : ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// if문 구조로 	   조건1  ? 조건2 ?  조건1만족+조건2만족           :  조건1만족+조건2불만족        :  조건1불만족
		System.out.println(num!=0? num>0? "입력하신 "+num+"은 양수입니다.":"입력하신 "+num+"은 음수입니다.":"입력하신 "+num+"은 0입니다.");
		//                 조건1 ?        조건1만족             :  조건2?          조건1불만족+조건2만족 : 조건1불만족+조건2불만족
		System.out.println(num>0? "입력하신 "+num+"은 양수입니다.":(num<0? "입력하신 "+num+"은 음수입니다.":"입력하신 "+num+"은 0입니다."));
		
		if(num!=0) {
			if(num>0) {
				System.out.println("입력하신 "+num+"은 양수입니다.");
			}
			else {
				System.out.println("입력하신 "+num+"은 음수입니다.");
			}
		}
		else{
			System.out.println("입력하신 "+num+"은 0입니다.");
		}
	}
}

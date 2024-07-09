package day03;

import java.util.Scanner;

public class ArTest1 {

	public static void main(String[] args) {
		int data0 = 10;
		int data1 = 5;
		int data2 = -7;
		int data3 = -17;
		int data4 = 22;
		
		// 각 방은 변수나 마찬가지(값을 사용)
//		System.out.println(data0);
//		System.out.println(data1);
//		System.out.println(data2);
//		System.out.println(data3);
//		System.out.println(data4);
		
		int[] arData1 = {10, 5, -7, -17, 22, 2000};
		
		//for의 반복 횟수를 해당하는 배열의 길이로 해놓으면 유지보수 편함
		for (int i = 0; i < arData1.length; i++) {
			System.out.println(arData1[i]);
		}
		
		int[] arData2 = new int[3];
		// 각 방은 변수나 마찬가지(공간으로 사용)
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arData2.length; i++) {
			System.out.print((i+1)+"번째 숫자를 입력하십시오 : ");
			arData2[i] = sc.nextInt();
		}
		for (int i = 0; i < arData2.length; i++) {
			System.out.print(arData2[i]+" ");
		}
	}

}

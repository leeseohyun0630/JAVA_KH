//package day03;
//
//import java.util.Scanner;
//
//public class ForTask {
//	public static void main(String[] args) {
//		// 초기식은 int i=0; 증감식은 i++
//		
//		// 1부터 10까지 출력하기
//		for(int i = 0; i<10 ; i++) {
//			System.out.println(i+1);
//		}
//		System.out.println("========================");
//		
//		// 10부터 1까지 출력하기
//		for(int i = 0; i<10 ; i++) {
//			System.out.println(10-i);
//		}
//		System.out.println("========================");
//	
//		
//		// 12부터 3씩 증가하며 13번 출력하기
//		for(int i = 0; i<13 ; i++) {
//			System.out.println(12+i*3);
//		}
//		System.out.println("========================");
//		// 100 94 88 ... 28 출력하기
//		for(int i = 0; i<13 ; i++) {
//			System.out.println(100-i*6);
//		}
//		System.out.println("========================");
//		
//		
//		// 1부터 10까지의 총 합 구하기
//		int sum = 0;
//		for(int i = 0; i<10 ; i++) {
//			sum += i+1;
//		}
//		System.out.println("1~10까지의 총합 : "+sum);
//		System.out.println("========================");
//		// n하나 입력받아서 1부터 n까지의 총 합 구하기
//		int sum = 0;
//		Scanner sc = new Scanner(System.in);
//		System.out.print("n을 입력해주십시오 : ");
//		int num = sc.nextInt();
//		for(int i = 0; i<num ; i++) {
//			sum += i+1;
//		}
//		System.out.println("1부터 입력해주신 "+num+"까지의 합은 "+sum+"입니다.");
//		System.out.println("========================");
//		// 1부터 100까지 중 짝수만 출력하기
//		for(int i=0;i<=100;i++) {
//			if((i+1)%2==0) {
//				System.out.println(i+1);
//			}
//		}
//		System.out.println("========================");
//		// A부터 F 출력하기 A 65, B 66, C 67, D 68, E 69, F70 
//		for(int i=0;i<6;i++) {
//			System.out.println((char)(65+i));
//		}
//		System.out.println("========================");
//		
//		// n, m 입력받아서 n부터 m까지 출력하기
//		Scanner sc = new Scanner(System.in);
//		System.out.print("n을 입력해주십시오 : ");
//		int n1 = sc.nextInt();
//		System.out.print("m을 입력해주십시오 : ");
//		int m1 = sc.nextInt();
//		for(int i=0;i<m1-n1+1;i++) {
//			System.out.println(n1+i);
//		}
//		System.out.println("========================");
//		// 1부터 100까지 중 3과 5의 공배수만 출력하기
//		 
//		for(int i=1; i<=100; i++) {
//			if(i%3==0 && i%5==0 && i!=0)
//				System.out.println(i);
//		}
//		System.out.println("========================");
//
//		
//		// 1부터 100까지 중 3과 5의 배수를 출력하되 공배수는 제외하고 출력하기
//		for(int i=1; i<=100; i++) {
//			if(i%3==0 || i%5==0) {
//				if(i%3==0 && i%5==0) {
//					continue;
//				}
//				else{
//					System.out.println(i);
//				}
//			}
//		}
//		System.out.println("========================");
////		for(int i=1; i<=100; i++) {
////			if(i%3==0 || i%5==0) {
////				if(!(i%3==0 && i%5==0)) {
////					System.out.println(i);
////				}
////			}
////		}
////		System.out.println("========================");
//		
//		// AbCdEf...Yz출력하기 A 65, Z 90,		a 97, z 122 
//		// i%2==0 i+65 i+97
//		for(int i=0; i<26;i++) {
//			if(i%2==0) {
//				System.out.print((char)(i+65));
//			}
//			else {
//				System.out.print((char)(i+97));
//			}
//		}
//		System.out.println();
//		System.out.println("========================");
//		for(int i=0; i<26;i++) {
//			System.out.print((char)((i%2==0?65:97)+i));
//		}
//		System.out.println();
//		System.out.println("========================");
//		String result = "";
//		for(int i=0; i<26;i++) {
//			result += ((char)((i%2==0?65:97)+i));
//		}
//		System.out.println(result);
//		System.out.println("========================");
//
//		
//		// 중첩반복문 사용하지 않고 구구단 전부 출력하기
//		for(int i=0;i<81;i++) {
//			System.out.println((i/9+1)+"X"+(i%9+1)+"="+(i/9+1)*(i%9+1));
//		}
//		System.out.println("========================");
//		
//		// 10진수 숫자 입력받아서 2진수로 출력하기
//		Scanner sc = new Scanner(System.in);
//		System.out.print("숫자를 입력해주십시오 : ");
//		int num = sc.nextInt();	//받아오는 10진수 수
//		String A = "";				//나머지를 넣어줄 문자열
//		for(int i=0; ;i++) {
//			if(num==0) {			
//				break;				//넣은 값이 0이되면 종료 -> for문이 무한반복임
//			}
//			A = num%2+A;
//			num /=2;
//		}
//		System.out.println(A);
//		
//
//		// ABCD		0,1,2,3			65,66,67,68		
//		// efgh		4,5,6,7			101,102,103,104
//		// IJKL		8,9,10,11		73,74,75,76
//		// mnop		12,13,14,15		109,110,111,112
//		// QRST		16,17,18,19		81,82,83,84
//		// uvwx		20,21,22,23		117,118,119,120
//		// YZ		24,25			89,90
//		for(int i=0;i<26;i++) {
//			if(i<4) {
//				System.out.println((char)(65+i));
//			}
//			else if(i<8){
//				System.out.println((char)(97+i));
//			}
//			else if(i<12){
//				System.out.println((char)(65+i));
//			}
//			else if(i<16){
//				System.out.println((char)(97+i));
//			}
//			else if(i<20){
//				System.out.println((char)(65+i));
//			}
//			else if(i<24){
//				System.out.println((char)(97+i));
//			}
//			else {
//				System.out.println((char)(65+i));
//			}
//		}
//
//		// A		65
//		// b 		98
//		// CD 		67,68
//		// ef 		101,102
//		// GHI 		71,72,73
//		// jkl 		106,107,108
//		// MNOP 	77,78,79,80
//		// qrst 	113,114,115,116
//		// UVWXY 	85,86,87,88,89
//		// z 출력하기	121
//		for(int i=0;i<26;i++) {
//			int cnt = 0;
//			
//		}
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//

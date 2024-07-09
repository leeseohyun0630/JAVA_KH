package day02;

public class ForTest {
	public static void main(String[] args) {
		//0. LSH
		//1. LSH
		//2. LSH
		// ...
		//9. LSH
		System.out.println("0. LSH");
		System.out.println("1. LSH");
		System.out.println("2. LSH");
		System.out.println("3. LSH");
		System.out.println("4. LSH");
		System.out.println("5. LSH");
		System.out.println("6. LSH");
		System.out.println("7. LSH");
		System.out.println("8. LSH");
		System.out.println("9. LSH");
		
		System.out.println("=======================");
		
		int i = 0;
		while(i<10) {
			System.out.println(i+". LSH");
			i++;
		}
		
		System.out.println("=======================");
		
		for(int j=0; j<10; j++) {
			System.out.println(j+". LSH");
		}
		
		// 반복횟수는 (끝값-초기값)/증감값
		// 10 = (x-4)/-4
		// -40 = x-4
		// x = -36
		// 10번 반복하는 반복문
		for(int k =4;k>-36;k-=4) {
			System.out.println(k+36);
		}
		
		// 100 부터 -3씩 13번 반복
		// 13 = (x-100)/-3
		// -39 = x-100
		// x = 61
		for(int a=100 ; a>61 ; a-=3) {
			
		}
//		//for문도 조건식이 참일동안 반복
//		for(;true;) {
//			//무한 반복 +조건식 생략시도 무한반복임
//		}
		
		// 2 4 6 8 10 12 14 16 18 20
		for(int j =2; j<=20; j+=2) {
			System.out.println(j);
		}
		for(int j =0;j<10;j++) {
			System.out.println((j+1)*2);
		}
		for(int j =0;j<13;j++) {
			System.out.println(-3*j+26);
		}
		
		//2 3 / 4 6 / 6 9 / 8 12 / 10 15
		for(int j=0; j<5;j++) {
			System.out.println(2*(j+1));
			System.out.println(3*(j+1));
		}
	}
}

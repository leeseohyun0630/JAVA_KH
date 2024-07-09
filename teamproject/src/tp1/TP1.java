package tp1;

import java.util.Random;
import java.util.Scanner;

public class TP1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = 0;
		int n2 = 0;
		int n3 = 0;

		int sum = 0;

		String name = "";
		int age = 0;
		String gender = "";
		String personality = "";

		int grade = 0;
		int ban = 0;
		int bun = 0;
		double score = 0.00;
		char mark = ' ';

		String yn = "";

		while(true) {
			System.out.print("1. 간단 계산기\n2. 작은 수에서 큰 수까지 합계"
					+ "\n3. 신상 정보 확인\n4. 학생 정보 확인"
					+ "\n5. 별과 숫자 출력\n6. 난수까지의 합계\n7. 구구단"
					+ "\n8. 주사위 숫자 맞히기 게임\n9. 프로그램 종료\n메뉴 번호 : ");
			int choice = sc.nextInt();
			// 9일 경우 종료.
			if(choice == 9) {
				System.out.println("종료합니다.");
				break;
			}
			switch(choice) {
			// 간단 계산기
			case 1:
				System.out.print("첫번째 정수 입력 : ");
				n1 = sc.nextInt();
				System.out.print("두번째 정수 입력 : ");
				n2 = sc.nextInt();
				System.out.print("연산자(+, -, x, /) 입력 : ");
				String ch1 = sc.next();

				if(ch1.charAt(0) == '+') {
					System.out.println(n1+" + "+n2+" = "+(n1+n2));
				}
				else if(ch1.charAt(0) == '-') {
					System.out.println(n1+" - "+n2+" = "+(n1-n2));
				}
				else if(ch1.charAt(0) == 'x') {
					System.out.println(n1+" x "+n2+" = "+(n1*n2));
				}
				else if(ch1.charAt(0) == '/') {
					if(n2 == 0) {
						System.out.println("0으로 나눌 수 없습니다.");
					}
					else {
						System.out.println(n1+" / "+n2+" = "+((double)n1/n2));
					}
				}
				else {
					System.out.println("잘못된 연산자를 입력하였습니다.");
				}

				break;
				// 작은 수에서 큰 수까지 합계
			case 2:
				System.out.print("첫번째 정수 입력 : ");
				n1 = sc.nextInt();
				System.out.print("두번째 정수 입력 : ");
				n2 = sc.nextInt();
				if(n1>n2) {
					for (int i = n2; i <=n1; i++) {
						sum += i;
					}
					System.out.println(n2+"부터 "+n1+"까지 정수들의 합 : "+sum);
				}
				else if(n1<n2){
					for (int i = n1; i <=n2; i++) {
						sum += i;
					}
					System.out.println(n1+"부터 "+n2+"까지 정수들의 합 : "+sum);
				}
				else {
					System.out.println("첫번째 정수와 두번째 정수가 "+n1+"로 같은 수입니다.");
				}
				break;
				// 신상 정보 확인
			case 3:
				System.out.print("이름 : ");
				name = sc.next();
				System.out.print("나이 : ");
				age = sc.nextInt();
				System.out.print("성별 : ");
				gender = sc.next();
				System.out.print("성격 : ");
				personality = sc.next();

				System.out.println("이름 : "+name);
				System.out.println("나이 : "+age);
				System.out.println("성별 : "+gender);
				System.out.println("성격 : "+personality);
				break;
				// 학생 정보 확인
				//				String gender = "";
				//				String personality = "";
				//				
				//				int grade = 0;
				//				int ban = 0;
				//				int bun = 0;
				//				String score = "";
			case 4:
				System.out.print("이름 : ");
				name = sc.next();
				System.out.print("학년 : ");
				grade = sc.nextInt();
				System.out.print("반 : ");
				ban = sc.nextInt();
				System.out.print("번호 : ");
				bun = sc.nextInt();
				System.out.print("성별(M/F) : ");
				gender = sc.next();
				System.out.print("성적 : ");
				score = sc.nextDouble();

				if(gender.charAt(0)=='F') {
					gender = "여학생";
				}
				else if(gender.charAt(0)=='M') {
					gender = "남학생";
				}

				if(score>=90) {
					mark = 'A';
				}
				else if(score>=80) {
					mark = 'B';
				}
				else if(score>=70) {
					mark = 'C';
				}
				else if(score>=60) {
					mark = 'D';
				}
				else {
					mark = 'F';
				}

				System.out.printf("%d학년 %d반 %d번 %s %s의 점수는 "
						+ "%.2f이고 %c학점입니다.\n", grade, ban, bun, gender, name, score, mark);
				break;
				// 별과 숫자 출력
			case 5:
				System.out.print("정수 : ");
				n1 = sc.nextInt();
				if(n1<1) {
					System.out.println("양수가 아닙니다.");
				}
				else {
					for (int i = 0; i <n1; i++) {
						for (int j = 0; j < i; j++) {
							System.out.print("*");
						}
						System.out.println(i+1);
					}
				}
				break;
				// 난수까지의 합계
			case 6:
				n1 = new Random().nextInt(100);
				System.out.println("생성된 난수의 값 : "+n1);
				for (int i = 1; i <= n1; i++) {
					sum += i;
				}
				System.out.println("1부터 "+n1+"까지의 합 : "+sum);

				break;
				// 구구단
			case 7:
				System.out.print("정수 : ");
				n1 = sc.nextInt();
				if(n1<1) {
					System.out.println("양수가 아닙니다.");
				}
				else {
					for (int i = 1; i <10; i++) {
						if(i%n1==0) {
							continue;
						}
						else {
							System.out.printf("%d X %d = %d\n" ,n1, i, n1*i );
						}
					}
				}

				break;
				// 주사위 숫자 맞히기 게임

				//두개의 합을 맞춰보세요 : 
				//만약 정답일 경우 -> 정답 + 주사위의 합 출력
				//이후 계속 하시겠습니까 출력
				//정답이 아닐경우 -> 틀렸습니다 + 계속 맞춰보는 것.
			case 8:
				do{
					n1 = (int)(Math.random()*(6-1+1)+1);
					n2 = (int)(Math.random()*(6-1+1)+1);
					sum = n1+n2;
					System.out.println(sum);
					System.out.print("주사위 두 개의 합을 맞춰보세요(1~12입력) : ");
					n3 = sc.nextInt();

					if(sum == n3) {
						System.out.println("정답입니다.");
						System.out.println("주사위의 합 : "+sum);
					}
					else {
						System.out.println("틀렸습니다.");
					}

					System.out.println("계속 하시겠습니까?(y/n)");
					yn = sc.next();
					if(yn.equals("n") || yn.equals("N")) {
						System.out.println("종료합니다.");
						break;
					}
					else {
						continue;
					}
				}
				while(true);

			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
	}
}

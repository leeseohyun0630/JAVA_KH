package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumTest {
	public static void main(String[] args) {
		// 줄 선택 > Alt + Shift + Z > ↓ > Enter : try ~ catch 블럭 만들기
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.print("정수  : ");
			int num1 = sc.nextInt();
			System.out.print("정수  : ");
			int num2 = sc.nextInt();
			
			int result = num1/num2;
			
			System.out.println("결과 : "+result);
		} catch (ArithmeticException ae) {
			System.out.println("0으로는 나눌 수 없습니다.");
//			ae.getCause();
//			ae.getMessage();
//			ae.getStackTrace();
		} catch (InputMismatchException ime) {
			System.out.println("정수만 입력하세요.");
		}
		
		catch (Exception e) {
//			System.out.println("알 수 없는 오류 발생 / 개발자에게 알려주세요");
			System.out.println(e);
		}
	}
}

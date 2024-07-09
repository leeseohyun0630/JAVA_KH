package day01;

public class VariableTest {

	public static void main(String[] args) {
		// ============ 홍길동 님의 개인정보 ============= 
		// 이름 : 홍길동
		// 나이 : 10살
		// 키 : 180.22cm
		// 몸무게 : 79.15kg
		// 성적 : C
		// \0/
		
		System.out.printf("============ %s 님의 개인정보 =============\n", "홍길동");
		System.out.printf("이름 : %s \n", "홍길동");
		System.out.printf("나이 : %d살 \n", 10);
		// .2f -> 소수점 2번째 자리까지 출력
		System.out.printf("키 : %.2fcm \n", 180.22);
		System.out.printf("몸무게 : %.2fkg \n", 79.15);
		System.out.printf("성적 : %s \n", 'C');
		System.out.println("\\0/");
		
		String name = "홍길동";
		int age = 10;
		float height = 180.22f;
		double weight = 79.15;
		char score = 'C';
		
		System.out.println("============ "+name+" 님의 개인정보 =============");
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age+"살");
		System.out.println("키 : "+height+"cm");
		System.out.println("몸무게 : "+weight+"kg");
		System.out.println("성적 : "+score);
		System.out.println("\\0/");
	}

}

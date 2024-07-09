package generic;

public class GenericMain {
	public static void main(String[] args) {
//		Save save1 = new Save();
//		save1.data = "Hello";
//		
//		Save save2 = new Save();
//		save1.data = 10;
//		
//		System.out.println(((String)save1.data).length());
		
//		1. 제네릭 클래스
		Save<String> save = new Save<>();
		save.data = "Hello";
		save.data.length();
		
		GClassTest<Integer> obj1 = new GClassTest<Integer>(10);
		obj1.f(10);
		
//		2. 제네릭 메소드
		GMethodTest obj2 = new GMethodTest();
		obj2.<Integer>f(10);
		obj2.<String>f("Hello");
//		지정한 타입과 다른 타입을 사용하면 오류
//		obj2.<Integer>f("Hello");]
		
		
//		제네릭 메소드들은 암묵적으로 타입을 알 수 있는 경우가 대부분이다.
//		이 때에는 꺽쇠 괄호를 이용해서 타입을 직접 적지 않아도 된다.
		obj2.f(20);
		obj2.f("Hello");
		
//		3. 제너릭 인터페이스
		GInterTest<Integer, Double> obj3 = new GInterTest<Integer, Double>() {
			
			@Override
			public Double div(Integer num1, Double num2) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Integer add(Integer num1, Integer num2) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		
				
	}
}

package obj;

public class ObjectTest2 {
	public static void main(String[] args) {
		String msg1 = "Hello";
		String msg2 = "Hello";
		String msg3 = new String("Hello");
		
		System.out.println(msg1 == msg2);
		System.out.println(msg1.equals(msg3));
		System.out.println(msg1 == msg3);
		System.out.println(msg1.equals(msg2));
		
		// 동위(위치나 상태) 객체를 동일 객체로 보도록 재정의 필요
		// TestData에서 equals 재정의 필요
		TestData obj1 = new TestData(10, 0.0);
		TestData obj2 = new TestData(10, 0.0);
		
		System.out.println(obj1 == obj2);
		
		// Object 클래스의 equals()는 동위 객체를 동일 객체로 보지 않는다.
		// 개발을 하다보면 필요에 의해 동위 객체를 동일 객체로 봐야하는 경우가 생기기 때문에
		// 우리가 만든 클래스(특히 데이터를 포장하는 클래스)에서 재정의 해야한다.
		System.out.println(obj1.equals(obj2));
	}
}

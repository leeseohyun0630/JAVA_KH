package wrapper;

public class WrapperTest2 {
	public static void main(String[] args) {
		Integer obj = 10;
//		f1(obj.intValue());			// 원래 문법
		f1(obj);					// 오토 언박싱
		
		int data = 10;
		f2(data);					// 오토 박싱
		
		g(obj);						
		g(obj.intValue());		
		g(data);					
		g((Integer)data);			
		
		g(obj.intValue());			
		g((Integer)data);			
		
	}
	static void f1(int data) {
		System.out.println("int 타입으로 호출한 메소드 : "+data);
	}
	
	static void f2(Integer obj) {
		System.out.println("Integer 타입으로 호출한 메소드 : "+obj);
	}
	
	static void g(int data) {
		System.out.println("int 타입으로 호출한 메소드 : "+data);
	}
	
//	static void g(Integer obj) {
//		System.out.println("Integer 타입으로 호출한 메소드 : "+obj);
//	}
	
	// Object 타입의 매개변수가 선언되어 있다.
	// 1. 아무 타입이나 넘겨라
	// 2. 객체 하나 넘겨라
	
	static void g(Object obj) {
		System.out.println("Object 타입으로 호출한 메소드 : "+obj);
	}
	
	
}

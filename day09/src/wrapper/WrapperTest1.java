package wrapper;

public class WrapperTest1 {
	public static void main(String[] args) {
//		Integer obj = new Integer(10);
		
		// 박싱
		Integer obj = (Integer)10;
		System.out.println(obj);
		
		// 언박싱
		int data = obj.intValue();
		System.out.println(data);
		
		// 오토박싱, 오토언박싱
		obj = 10;
		data = obj;
	}
}

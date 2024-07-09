package obj;

public class MathTest {
	public static void main(String[] args) {
		// Math.ceil(실수) : 소수점 첫째 자리에서 올림
		System.out.println(Math.ceil(19.11));
		System.out.println(Math.ceil(-19.11));
		
		// Math.floor(실수) : 소수점 첫째 자리에서 내림
		System.out.println(Math.floor(19.11));
		System.out.println(Math.floor(-19.11));
		
		// Math.round(실수) : 소수점 첫째 자리에서 반올림
		System.out.println(Math.round(19.4999999));
		System.out.println(Math.round(19.4999999999999999999));
		System.out.println(Math.round(19.6));
		
		System.out.println(Math.pow(10,2));
		System.out.println(Math.sqrt(16));
		
		// 특정한 자리에서 하고 싶은 경우
		// 11.484 -> 11.5
		// Math.floor(11.484*10)/10.0 
		
		// 10의 제곱수를 곱해준다(남겨둘 자리만큼)
		// 반올림 진행 후 곱해준 제곱수로 나눠준다.
		
	}
}

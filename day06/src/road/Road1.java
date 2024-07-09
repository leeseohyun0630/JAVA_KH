package road;

import java.util.Iterator;

public class Road1 {
	public static void main(String[] args) {
//		Car mycar = new Car("Ferrari", "Red", 70000);
//		Car momcar = new Car("K7", "White", 4000);
//		Car dadcar = new Car(26000);
		
//		Car[] garage = {mycar, momcar, dadcar};
//		
//		garage[0].engineStart();
		
//		int data1 = 10;
//		int data2 = 20;
//		int data3 = 30;
//		
//		int[] arData = {10, 20, 30};
		
		// 선언 방법 1
		Car[] garage = {
				new Car("Ferrari", "Red", 70000),
				new Car("K7", "White", 4000),
				new Car(26000)
		};
		for (int i = 0; i < garage.length; i++) {
			garage[i].engineStart();
		}
		
		
		// 선언 방법 2
		Car[] cars = new Car[10];
		// 비어있는 배열(칸 수 지정 배열)은 각 방이 객체인데 해당 객체의 필드를 생성하지 않았으므로
		// (new 생성자() 호출을 안했으므로) 각 방에는 주소값의 초기값인 null이 담겨있다.
//		for (int i = 0; i < cars.length; i++) {
//			cars[i].engineStart();
//		}
		// 사용하려면 필드를 먼저 생성해서 주소값을 연결해준 후 사용한다.
		cars[0] = new Car();
		cars[0].engineStart();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

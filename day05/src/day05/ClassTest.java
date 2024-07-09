package day05;

public class ClassTest {
	public static void main(String[] args) {
//		Car mycar = new Car();						// 객체화
//		mycar.model = "Ferrari";
//		mycar.color = "Red";
//		mycar.price = 70000;
//		System.out.println(mycar.model);
//		System.out.println(mycar.color);
//		System.out.println(mycar.price);
		
		Car mycar = new Car("Ferrari", "Red", 70000);	
		System.out.println(mycar.model);
		
		Car momcar = new Car("K7", "White", 4000);	
		System.out.println(momcar.color);
		
		Car dadcar = new Car("G80", "Black", 7000);	
		System.out.println(dadcar.price);
		
		mycar.engineStart();
		momcar.engineStart();
		dadcar.engineStart();
		mycar.engineStop();
		momcar.engineStop();
		dadcar.engineStop();
	}
}

class Car{
	// 속성, 성질들은 변수로 선언
	String carNum;
	String model;
	String color;
	int price;
	
	public Car(String model, String color, int price) {
		this.model = model;
		this.color = color;
		this.price = price;
	}
	
	
	// 기능, 행위들은 메소드로 선언
	void engineStart() {
		// 지역 변수 model이 선언된 것이 없으므로 this. 은 생략이 가능하다.
		System.out.println(this.model+"시동 켜기");						
	}
	
	void engineStop() {
		System.out.println(model+"시동 끄기");								// this. 생략 가능.
	}
}
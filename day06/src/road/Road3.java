package road;

public class Road3 {
	public static void main(String[] args) {
		SuperCar mycar = new SuperCar("Ferrari", "Red", 70000, "우주모드");
		Car momcar = new Car("K7", "White", 4000);
		
		mycar.engineStart();
		mycar.roofOpen();
		
		momcar.engineStart();
//		momcar.roofOpen();
	}
}

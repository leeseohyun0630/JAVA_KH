package pattern.factory;

public class Danawa {
	public static void main(String[] args) {
//		Computer computer = new Computer();
//		Camera camera = new Camera();
//		Dryer dryer = new Dryer();
		
		Computer computer = (Computer)Factory.getInstance("Computer");
		
//		Computer[] arComputer1 = {
//			new Computer(),	
//			new Computer(),	
//			new Computer(),	
//			new Computer()
//		};
//		
//		Computer[] arComputer2 = {
//			(Computer)Factory.getInstance("Computer"),
//			(Computer)Factory.getInstance("Computer"),
//			(Computer)Factory.getInstance("Computer"),
//			(Computer)Factory.getInstance("Computer")
//		};
	}
}

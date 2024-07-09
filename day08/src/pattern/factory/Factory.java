package pattern.factory;

public class Factory {
	public static Product getInstance(String name) {
		switch(name) {
		case "Computer":
			return new Computer();
		case "Camera":
			return new Camera();
		case "Dryer":
			return new Dryer();
		}
		return null;
	}	
}

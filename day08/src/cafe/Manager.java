package cafe;

public class Manager {
	void openCafe(Cafe cafe) {
		System.out.println("Open");
		System.out.println("원드 그라인딩");
		cafe.drip();
		cafe.sell();
		cafe.clean();
		System.out.println("Close");
	}
}

package exception;

public class ThrowsTest {
	public static void main(String[] args) throws InterruptedException, Exception {
		f();
		
	}
	static void f() throws InterruptedException {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		Thread.sleep(1000);
		
//		new FileReader("test.txt");
	}
	
}

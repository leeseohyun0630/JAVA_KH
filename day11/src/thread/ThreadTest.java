package thread;

public class ThreadTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("☆");
		MyThread t2 = new MyThread("★");
		
		MyRunnable r1 = new MyRunnable("♡"); 
		MyRunnable r2 = new MyRunnable("♥"); 
		Thread t3 = new Thread(r1);
		Thread t4 = new Thread(r2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
	}
	
}

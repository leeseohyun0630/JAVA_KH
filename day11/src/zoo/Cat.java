package zoo;

public class Cat extends Animal implements Runnable, Mammal{

	public Cat(String name, String gender, int age) {
		super(name, gender, age);
	}

	@Override
	void makeSomeNoise() {
		System.out.println("야옹");
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			makeSomeNoise();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package zoo;

public class Mosquito extends Animal {

	public Mosquito(String name, String gender, int age) {
		super(name, gender, age);
	}
	
	@Override
	void makeSomeNoise() {
		System.out.println("위이이ㅣ잉잉잉이이이잉~~ 춉");
	}
	
}

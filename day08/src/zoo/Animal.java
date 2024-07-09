package zoo;

public abstract class Animal {
	String name;
	String gender;
	int age;
	
	public Animal(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	final void init() {
		System.out.println(name+"은(는) 동물입니다.");
	}
	
	void eat() {
		System.out.println(name+"이(가) 냠냠 먹는중...");
	}
	
	void sleep() {
		System.out.println(name+"이(가) 쿨쿨 자는중...");
	}
	
	abstract void makeSomeNoise();
}











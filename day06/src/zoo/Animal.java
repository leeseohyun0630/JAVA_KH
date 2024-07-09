package zoo;

public class Animal {
//	String animalType;
//	String cryingSound;
	
	String name;
	String gender;
	int age;
	
	public Animal() {
		
	}
//	
//	// Alt+Shift+S > O : 필드(변수)를 이용해서 생성자 만들기
//	public Animal(String animalType, String cryingSound) {
//		this.animalType = animalType;
//		this.cryingSound = cryingSound;
//	}
//	
//
//	void animalType() {
//		System.out.println("동물의 종류는 "+this.animalType+" 입니다.");
//	}
//
//	void cryingSound() {
//		System.out.println(this.animalType+"의 울음소리는 "+cryingSound+"입니다.");
//	}
	
	void eat() {
		System.out.println(name+"이(가) 먹는 중");
	}
	void sleep() {
		System.out.println(name+"이(가) 자는 중");
	}
	void move() {
		System.out.println(name+"이(가) 먹는 중");
	}

	void makeSomeNoise() {
		System.out.println(name+"이(가) 소리 내는 중");
		
	}
	
}

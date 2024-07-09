package zoo;

public class GangSa extends Animal{

	public GangSa(String name, String gender, int age) {
		super(name, gender, age);
	}

//	final이 붙은 메소드는 자식에서 절대 재정의가 불가능하다.
//	@Override
//	void init() {
//		System.out.println(name+"은(는) 음식입니다.");
//	}
	
	@Override
	void makeSomeNoise() {
		System.out.println("여기까지 이해 되셨죠?");
	}
	
}

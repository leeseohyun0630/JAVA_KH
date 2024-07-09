package zoo;

public class Ground {
	public static void main(String[] args) {
		// 서로 다른 종류의 동물 세마리 울게하기 햄스터 기니피그
		// 
//		Animal gunieaPig = new Animal("Guniea Pig", "squeak");
//		Animal brid = new Animal("Brid", "chatter");
//		Animal owl = new Animal("Owl", "hoot");
		
		Australopithecus australopithecus = new Australopithecus();
		FourFiveJung fourFiveJung = new FourFiveJung();
		Lizard lizard = new Lizard();
		
		Animal[] cage = {
				new Australopithecus(),
				new FourFiveJung(),
				new Lizard()
		};
		
		for (int i = 0; i < cage.length; i++) {
			cage[i].makeSomeNoise();
		}
		
//		gunieaPig.animalType();
//		gunieaPig.cryingSound();
//		System.out.println();
//		brid.animalType();
//		brid.cryingSound();
//		System.out.println();
//		owl.animalType();
//		owl.cryingSound();
//		System.out.println();
//		
		
	}
}

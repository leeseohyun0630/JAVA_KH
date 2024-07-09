package zoo;

public class Ground {
	public static void main(String[] args) {
		GangSa gangSa = new GangSa("정다솔", "남자", 22);
		Mosquito mosquito = new Mosquito("블라디미르", "암컷", 15);
		Otter otter = new Otter("라일라", "여자", 3);
		
//		Animal obj = new Animal() {
//			
//			@Override
//			void makeSomeNoise() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
		
		Animal[] cage = {
				new GangSa("정다솔", "남자", 22),
				new Mosquito("블라디미르", "암컷", 15),
				new Otter("라일라", "여자", 3)
		};
		
		// 0번방과 2번방에 있는 객체는 Mammal 이라는 타입을 마치 마킹해 놓은듯한 효과를 낼 수 있다.
		// 마크 인터페이스(내부가 비워져 있는 경우도 있음 - 목표가 하나의 타입을 더 부여하기 위함이라서)
		for (int i = 0; i < cage.length; i++) {
			if(cage[i] instanceof Mammal) {
				((Mammal)cage[i]).breed();
			}
		}
		
//		while(true) {
//			gangSa.makeSomeNoise();
//			mosquito.makeSomeNoise();
//			otter.makeSomeNoise();
//		}
	}
}

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
		
		while(true) {
			gangSa.makeSomeNoise();
			mosquito.makeSomeNoise();
			otter.makeSomeNoise();
		}
	}
}

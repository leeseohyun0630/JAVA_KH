package zoo;

import java.util.ArrayList;

public class Ground {
	public static void main(String[] args) {
		// 동물 네 마리 만들어서 포유류들만 동시에 울게하기
		ArrayList<Animal> cage = new ArrayList<>();
		cage.add(new Dog("뽀삐", "암컷", 5));
		cage.add(new Cat("키티", "암컷", 3));
		cage.add(new Bird("짹짹", "수컷", 4));
		cage.add(new Frog("개굴", "수컷", 2));
		
		Thread[] threads = {
				new Thread((Runnable)cage.get(0)),
				new Thread((Runnable)cage.get(1)),
				new Thread((Runnable)cage.get(2)),
				new Thread((Runnable)cage.get(3)),
		};
		System.out.println("시작");
		for (int i = 0; i < threads.length; i++) {
			if(cage.get(i) instanceof Mammal) {
				threads[i].start();
			}
		}
		
//		join() 메소드는 다른 쓰레드들이 본인이 완료될 때까지 잠시 멈추는 역할을 한다.
		for (int i = 0; i < threads.length; i++) {
			if(cage.get(i) instanceof Mammal) {
				try { threads[i].join();} catch(InterruptedException e) {}
			}
		}
		System.out.println("끝");
	}
}

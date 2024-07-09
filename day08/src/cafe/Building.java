package cafe;

public class Building {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Cafe cafe1 = new Cafe() {

			@Override
			public void drip() {
				System.out.println("커피 내리기");
			}

			@Override
			public void sell() {
				System.out.println("커피 팔기");
			}

			@Override
			public void clean() {
				System.out.println("청소하기");
			}
		};
		manager.openCafe(cafe1);
		
		manager.openCafe(new Cafe( ) {

			@Override
			public void drip() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void sell() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void clean() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}

package pattern.riot;

public class Jungle extends ChampionAdapter{
	@Override
	public void seeMap() {
		System.out.println("어디에 싸움이 나는지 확인하고 끼어든다.");
	}
	
	@Override
	public void useSkill() {
		System.out.println("지나가면서 괜히 창 한 번 던진다.");
	}
}

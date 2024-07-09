package pattern.riot;

public class Top implements Champion {

	@Override
	public void hit() {
		System.out.println("묻고 따지지도 않고 때린다.");
	}

	@Override
	public void useSkill() {
		System.out.println("다 모르겠고 나는 싸움꾼이다.");
	}

	@Override
	public void seeMap() {
		System.out.println("보긴 보지만 상관없다, 1:2도 이긴다는 마인드");
	}

	@Override
	public void eatMinion() {
		System.out.println("돈은 중요하지 않다. 나는 경험치가 더 중요해.");
	}

}

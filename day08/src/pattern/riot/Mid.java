package pattern.riot;

public class Mid implements Champion {

	@Override
	public void hit() {
		System.out.println("미니언 어그로를 조심하며 아주 정교하게 때린다.");
	}

	@Override
	public void useSkill() {
		System.out.println("나의 턴을 유지하기 위해 조심스럽게 상대를 맞춘다.");
	}

	@Override
	public void seeMap() {
		System.out.println("손에 땀을 쥔 채 주변을 아주 잘 살펴본다.");
	}

	@Override
	public void eatMinion() {
		System.out.println("한 개 한 개가 소중하기 때문에 부모님이 물려주신 유산마냥 잘 챙긴다.");
	}

}

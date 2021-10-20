package 게임플레이어구현;

public class BeginnerLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("천천히 달릴 수 있다.");
	}
	
	@Override
	public void jump() {
		System.out.println("점프할 줄 모른다.");
		
	}
	
	@Override
	public void turn() {
		System.out.println("턴 할 줄 모른다.");
	}



	@Override
	public void showLevelMessage() {
		
		System.out.println("<<<초보자 레벨입니다.>>>");
	}

}

package 게임플레이어구현;


/*
 * 
 * Player 클래스의 PlayerLevel 클래스는 포함(HAS - A) 관계이다. 즉 집합(aggregation) 연관 관계이다.
 * 전체(whole)와 부분(part)를 나타낸 모델 요소이다.
 * 게임에서 모든 Player는 자신의 레벨이 있기 때문에, Player 클래스에서 PlayerLevel을 
 * 멤버변수로 갖는다. 레벨이 올라갈수록 수행할 수 있는 기능이 달라진다.
 * 그러므로 PlayerLevel 클래스를 추상 클래스로 만들어 모든 레벨에서 공통으로 수행하는
 * 기능을 구현하고, 각 레벨마다 달라지는 기능은 추상 메소드로 만들어 둔다.
 * 
 */

public class Player {
	//Player 클래스에서 PlayerLevel을 '멤버 변수'로 갖는다.
   private PlayerLevel level;
   
   //생성자
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	
	//매개변수 자료형은 모든 레벨로 변환 가능한 PlayerLevel
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}
	
	public void play(int count) {
		level.go(count);
	}
	
}

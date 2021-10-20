package 게임플레이어구현;

public class MainBoard {

	public static void main(String[] args) {
		
		Player player = new Player();
		player.play(1);
		System.out.println();
		
		AdvancedLevel aLevel = new AdvancedLevel();
		player.upgradeLevel(aLevel);
		player.play(2);
		System.out.println();
		
		SuperLevel bLevel = new SuperLevel();
		player.upgradeLevel(bLevel);
		player.play(3);
		System.out.println();
	
	}

}

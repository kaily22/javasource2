package �����÷��̾��;


/*
 * 
 * Player Ŭ������ PlayerLevel Ŭ������ ����(HAS - A) �����̴�. �� ����(aggregation) ���� �����̴�.
 * ��ü(whole)�� �κ�(part)�� ��Ÿ�� �� ����̴�.
 * ���ӿ��� ��� Player�� �ڽ��� ������ �ֱ� ������, Player Ŭ�������� PlayerLevel�� 
 * ��������� ���´�. ������ �ö󰥼��� ������ �� �ִ� ����� �޶�����.
 * �׷��Ƿ� PlayerLevel Ŭ������ �߻� Ŭ������ ����� ��� �������� �������� �����ϴ�
 * ����� �����ϰ�, �� �������� �޶����� ����� �߻� �޼ҵ�� ����� �д�.
 * 
 */

public class Player {
	//Player Ŭ�������� PlayerLevel�� '��� ����'�� ���´�.
   private PlayerLevel level;
   
   //������
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}
	
	//�Ű����� �ڷ����� ��� ������ ��ȯ ������ PlayerLevel
	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}
	
	public void play(int count) {
		level.go(count);
	}
	
}

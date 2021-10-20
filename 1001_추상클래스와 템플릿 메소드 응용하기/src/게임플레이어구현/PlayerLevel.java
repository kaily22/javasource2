package �����÷��̾��;

public abstract class PlayerLevel {
	
	//���ø� �޼ҵ� ���� => ���� �÷��̾� '�ó�����' => ��üŬ�������� ������ �� �� ����.
	final public void go(int count) {
		run();
		
		for(int i=0; i<count; i++) {
			jump();
		}
		
		turn();
	}
	
	//�߻� �޼ҵ�
	public abstract void run();
	public abstract void turn();
	public abstract void jump();
	public abstract void showLevelMessage();
	
}

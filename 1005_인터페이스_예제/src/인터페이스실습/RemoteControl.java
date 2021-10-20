package �������̽��ǽ�;


/*
 * RemoteControl �������̽���  Television Ŭ������ Audio Ŭ������ 
 * ������ �ִ� ��ɵ��� �߻� �޼ҵ�� �����صδ� �������̽��̴�.
 * 
 */

public interface RemoteControl {
	
	//'����' ������ ����� ����(public static final�� ���� ����)
	public static final int MAX_VOLUMN = 10; //�ִ� ����
	public static final int MIN_VOLUMN = 0; //�ּ� ����
	
	//'�߻� �޼ҵ�'����(�Ű������� ����x)
	//public abstract : ���� ����!
	
	public abstract void turnOn();
	public abstract void turnOff();
	//�Ű����� �޾��ֱ�
	public abstract void setVolume(int volumn);
	
	/*
	 *  �ڹ� 8�������ʹ� '����Ʈ �޼ҵ�'�� '���� �޼ҵ�'�� ���� ����� ���� ����!!
	 *  
	 */
	
	
	//'����Ʈ'�޼ҵ� ���� => ����� ���� => ���� Interface�� Ȯ���ؼ� ���ο� ����� �߰��ϱ�
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("�����Դϴ�.");
		}else {
			System.out.println("������ �����մϴ�.");
		}
	}
	
	//'����'�޼ҵ� ���� => ����� ���� => ����Ʈ �޼ҵ�ʹ� �޸� ��ü�� ��� �������̽������� ȣ���� ������
	static void changeBattery() {
		System.out.println("�������� ��ȯ�մϴ�.");
	}
	
	
	
}
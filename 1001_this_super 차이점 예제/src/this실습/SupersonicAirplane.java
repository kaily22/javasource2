package this�ǽ�;

public class SupersonicAirplane extends Airplane{
	
	//��� ����
	public static final int NORMAL = 1; //�Ϲ� ���� ����� ���
	public static final int SUPERSONICAirplane = 2; //������ ���� ����� ���
	
	public int flyMode = NORMAL;
	
	@Override //������
	public void fly() {
		if(flyMode == SUPERSONICAirplane) {
			System.out.println("������ �����մϴ�.");
		}else {
			//�θ� Ŭ������ fly�޼ҵ� ���
			super.fly();
		}
	}
	
}

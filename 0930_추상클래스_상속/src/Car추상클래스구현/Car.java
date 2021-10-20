package Car�߻�Ŭ��������;

public abstract class Car { //�߻�Ŭ����
	
	//���ø� �޼ҵ� => final ���� ����� �����Ѵ�. 'Ʋ'�� �ִ� �޼ҵ� �ǹ�!!
	/*
	 * �޼ҵ� '���� ����'�� '�ó�����'�� �����ϴ� ��
	 */
	
	final public void run() { //final ���� �Ұ� => �ڵ����� �ó�����
		startCar();
		drive();
		wiper();
		stop();
		turnOff();
	}
	
	//���� �޼ҵ� 
	public void startCar() {
		System.out.println("�õ��� �մϴ�.");
	}
	
	public void turnOff() {
		System.out.println("�õ��� ���ϴ�.");
	}
	
	//�߻�޼ҵ�(AI, MANUAL ���� �ٸ��� ����)
	public abstract void drive();
	public abstract void stop();
	public abstract void wiper();
	
}

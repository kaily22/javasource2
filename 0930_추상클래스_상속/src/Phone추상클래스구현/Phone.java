package Phone�߻�Ŭ��������;

public abstract class Phone {
	
	protected String userName;
	protected String phoneName;
	protected String number;
	
	public Phone(String userName, String phoneName, String number) {
		this.userName = userName;
		this.phoneName = phoneName;
		this.number = number;
	}
	
	final public void use() {
		turnOn();
		turnOff();
		function();
		}
	
	public void turnOn() {
		System.out.println("�ڵ����� �մϴ�.");
	}
	
	public void turnOff() {
		System.out.println("�ڵ����� ���ϴ�.");
		
	}
	
	public abstract void function();
	
	
	public String Info() {
		return phoneName+"�� ������ �ִ� ������ " +userName+ "�̸�, ��ȭ��ȣ�� " +number+"�Դϴ�.";				
	}
	
	
}

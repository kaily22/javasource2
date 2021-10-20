package Phone추상클래스구현;

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
		System.out.println("핸드폰을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("핸드폰을 끕니다.");
		
	}
	
	public abstract void function();
	
	
	public String Info() {
		return phoneName+"을 가지고 있는 유저는 " +userName+ "이며, 전화번호는 " +number+"입니다.";				
	}
	
	
}

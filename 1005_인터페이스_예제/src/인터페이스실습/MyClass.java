package 인터페이스실습;

//실행 클래스

public class MyClass {

	public static void main(String[] args) {
		
		
		RemoteControl rc = null;
		
		rc = new Television();
		rc.turnOn();
		rc.setVolume(7);
		rc.setMute(true);
		RemoteControl.changeBattery();
		rc.turnOff();
		System.out.println();
		
		
		rc = new Audio();
		rc.turnOn();
		rc.setVolume(5);
		rc.setMute(false);
		RemoteControl.changeBattery();
		rc.turnOff();
		
		//인터페이스로 만들면 -> 객체 손쉽게 가능
	}

}

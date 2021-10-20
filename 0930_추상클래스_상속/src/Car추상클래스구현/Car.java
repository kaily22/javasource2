package Car추상클래스구현;

public abstract class Car { //추상클래스
	
	//템플릿 메소드 => final 예약어를 사용해 선언한다. '틀'이 있는 메소드 의미!!
	/*
	 * 메소드 '실행 순서'나 '시나리오'를 정의하는 것
	 */
	
	final public void run() { //final 변경 불가 => 자동차의 시나리오
		startCar();
		drive();
		wiper();
		stop();
		turnOff();
	}
	
	//공통 메소드 
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	//추상메소드(AI, MANUAL 서로 다르기 때문)
	public abstract void drive();
	public abstract void stop();
	public abstract void wiper();
	
}

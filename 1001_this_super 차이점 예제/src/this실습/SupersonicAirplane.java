package this실습;

public class SupersonicAirplane extends Airplane{
	
	//상수 선언
	public static final int NORMAL = 1; //일반 비행 모드인 경우
	public static final int SUPERSONICAirplane = 2; //초음속 비행 모드인 경우
	
	public int flyMode = NORMAL;
	
	@Override //재정의
	public void fly() {
		if(flyMode == SUPERSONICAirplane) {
			System.out.println("초음속 비행합니다.");
		}else {
			//부모 클래스의 fly메소드 출력
			super.fly();
		}
	}
	
}

package 클래스생성;

//Car 클래스는 부모
public class Car { //멤버변수
	protected int speed; //현재속도
	protected int wheelNum; //바퀴의 개수
	protected String carName; //자동차 이름
	//-> private은 상속x -> protected로 해서 자식이 부모 상속 가능
	
	//디폴트 생성자 생성 해줘야한다.(상속)
	public Car() {
		
	}
	
	
	//생성자 
	public Car(String name) {
		carName = name;
	}
	
	public Car(int velocity) {
		speed = velocity;
	}
	
	public Car(String name, int velocity) {
		carName = name;
		speed = velocity;
	}
	
	//사용자 정의 메소드
	public void speedUp() {
		speed = speed + 10;
	}
	
	public void speedUp(int velocity) {
		speed = speed + velocity;
	}
	
	public void speedDown() {
		speed = speed -1 ;
		if(speed < 0) {
			speed = 0;
		}
	}
	
	public void stop() {
		speed = 0;
	}
	
//	public static void main(String[] args) {
//		Car mycar = new Car("제네시스");
//		System.out.println("마이카는 " +mycar.carName);
//		
//		
//		Car yourcar = new Car(120);
//		System.out.println("유어카의 현재 속도는 " +yourcar.speed);
//		
//		Car hiscar = new Car("체어맨",150);
//		System.out.println(hiscar.carName + "의 현재 속도는 " +hiscar.speed);
//	}

}

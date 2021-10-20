package 클래스생성;


/*
 * Taxi 클래스 => 자식(하위) 클래스
 */

public class Taxi extends Car { //default생성자x

	
	//Method overriding
	public void speedUp(int velocity) {
		speed = speed + velocity;
		
		if(speed > 100) {
			speed = 100;
		}
	}
	
	//자식 메소드->호출
	public static void main(String[] args) {
		Taxi myTaxi = new Taxi();
		myTaxi.speedUp(150);
		
		System.out.println("Taxi speed is " +myTaxi.speed);
		
	}

}

package Ŭ��������;


/*
 * Taxi Ŭ���� => �ڽ�(����) Ŭ����
 */

public class Taxi extends Car { //default������x

	
	//Method overriding
	public void speedUp(int velocity) {
		speed = speed + velocity;
		
		if(speed > 100) {
			speed = 100;
		}
	}
	
	//�ڽ� �޼ҵ�->ȣ��
	public static void main(String[] args) {
		Taxi myTaxi = new Taxi();
		myTaxi.speedUp(150);
		
		System.out.println("Taxi speed is " +myTaxi.speed);
		
	}

}

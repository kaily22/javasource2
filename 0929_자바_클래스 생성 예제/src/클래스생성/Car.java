package Ŭ��������;

//Car Ŭ������ �θ�
public class Car { //�������
	protected int speed; //����ӵ�
	protected int wheelNum; //������ ����
	protected String carName; //�ڵ��� �̸�
	//-> private�� ���x -> protected�� �ؼ� �ڽ��� �θ� ��� ����
	
	//����Ʈ ������ ���� ������Ѵ�.(���)
	public Car() {
		
	}
	
	
	//������ 
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
	
	//����� ���� �޼ҵ�
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
//		Car mycar = new Car("���׽ý�");
//		System.out.println("����ī�� " +mycar.carName);
//		
//		
//		Car yourcar = new Car(120);
//		System.out.println("����ī�� ���� �ӵ��� " +yourcar.speed);
//		
//		Car hiscar = new Car("ü���",150);
//		System.out.println(hiscar.carName + "�� ���� �ӵ��� " +hiscar.speed);
//	}

}

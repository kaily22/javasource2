package Car�߻�Ŭ��������;

public class CarTest {

	public static void main(String[] args) {
		
		System.out.println("<<<<�������� �ڵ��� �׽�Ʈ>>>>");
		Car myCar = new AICar();
		myCar.run();
		System.out.println();
		
		System.out.println("<<<����� �����ϴ� �Ϲ� �ڵ��� �׽�Ʈ >>>");
		Car hisCar = new ManualCar();
		hisCar.run();
	}

}

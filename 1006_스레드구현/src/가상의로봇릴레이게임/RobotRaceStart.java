package �����Ƿκ������̰���;


class RobotRace extends Thread {
	
	//������
	public RobotRace(String name) {
		super(name);
	}
	
	@Override
	public void run()
	{
		//���� �κ� 100m ������ => 10m�� ����
		for(int i=1; i<=10; i++) {
			System.out.println(getName() + "��"+ i*10 +"m����");
			
			try {
				sleep(2000); //0.5�� 1000=>1��
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
			
		}
		
	}	
}


//���ν�����
public class RobotRaceStart {

	public static void main(String[] args) {
		RobotRace robotA = new RobotRace("�κ�-A");
		RobotRace robotB = new RobotRace("�κ�-B");
		RobotRace robotC = new RobotRace("�κ�-C");
		
		robotA.start();
		robotB.start();
		robotC.start();

	}

}

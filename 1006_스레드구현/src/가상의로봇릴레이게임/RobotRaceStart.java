package 가상의로봇릴레이게임;


class RobotRace extends Thread {
	
	//생성자
	public RobotRace(String name) {
		super(name);
	}
	
	@Override
	public void run()
	{
		//가상 로봇 100m 릴레이 => 10m씩 전진
		for(int i=1; i<=10; i++) {
			System.out.println(getName() + "가"+ i*10 +"m전진");
			
			try {
				sleep(2000); //0.5초 1000=>1초
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			}
			
		}
		
	}	
}


//메인스레드
public class RobotRaceStart {

	public static void main(String[] args) {
		RobotRace robotA = new RobotRace("로봇-A");
		RobotRace robotB = new RobotRace("로봇-B");
		RobotRace robotC = new RobotRace("로봇-C");
		
		robotA.start();
		robotB.start();
		robotC.start();

	}

}

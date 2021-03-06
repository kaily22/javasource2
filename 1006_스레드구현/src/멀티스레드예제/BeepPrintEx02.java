package 멀티스레드예제;


/*
 * 메인 스레드(동시에 실행)
 * 
 */

public class BeepPrintEx02 {

	public static void main(String[] args) {
		
		//작업 스레드 만드는 방법(BeepTask 객체 만들기)
		Runnable beepTask = new BeepTask();
		Thread thread = new Thread(beepTask);
		
		thread.start(); //이 시점에서 작업 스레드와 메인 스레드가 동시에 실행
		
		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000); //1초간 일시 정지
			} catch (Exception e) {}
		}
		
	}

}

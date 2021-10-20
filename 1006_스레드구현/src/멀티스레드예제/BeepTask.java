package 멀티스레드예제;


/* 
 * BeepTask 구현 클래스 => '작업 스레드'역할
 */

import java.awt.Toolkit;

public class BeepTask implements Runnable {

	@Override //재정의
	public void run() {
		//정적 메소드 : 클래스 이름으로 바로 출력 가능
				//Toolkit 객체 얻어오기
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(1000); //1초간 일시 정지
					} catch (Exception e) {
						
					}
					
				}
		
	}
	
}

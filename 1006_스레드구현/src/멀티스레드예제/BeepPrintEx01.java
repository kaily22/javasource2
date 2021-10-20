package 멀티스레드예제;

import java.awt.Toolkit;

/*
 * Toolkit 객체 얻어오기
 * 
 * Toolkit클래스는 '시스템 정보'를 얻는 것으로 시스템의 자원에 접근할 수 있는 클래스이다.
 * 
 * 싱글 스레드 에플리케이션
 * (메인 스레드)
 * 
 */

public class BeepPrintEx01 {

	public static void main(String[] args) {
		
		//정적 메소드 : 클래스 이름으로 바로 출력 가능
		//Toolkit 객체 얻어오기
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i=0; i<5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000); //1초간 일시 정지
			} catch (Exception e) {}
			
		}
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000); //1초간 일시 정지
			} catch (Exception e) {}
		}
			
		}
	}


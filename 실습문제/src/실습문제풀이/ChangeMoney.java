package 실습문제풀이;

import java.util.Scanner;

public class ChangeMoney {

	public static void main(String[] args) {
		
		int[] arrayMoney = {50000,10000,5000,1000,500,100,50,10,1};
		String[] str = {"오만원권","만원권","오천원권","천원권","오백원","백원","오십원","십원","일원"};
		//화폐단위 배열 생성 -> 배열 선언 : 자동으로 0 초기화
		int[] result = new int[9];
		
		System.out.print("금액을 입력하세요 : ");
		
		Scanner in = new Scanner(System.in);
		int Money = in.nextInt(); //입력받은 문자열을 정수로 변환해서 입력받기
		
		
		//처리와 출력을 한번에 처리하자
		for(int i=0; i<arrayMoney.length;i++) {
			
			int num = Money/arrayMoney[i]; //몫이 나옴
			int remainder = Money%arrayMoney[i]; // 나머지 값
			
			//나머지를 다시 Money에 할당해서 반복하게
			Money = remainder;
			
			//지폐이면
			if(num>0 && i < 4) {
				System.out.println(str[i] + "" + num + "매");
				
			}else if(num > 0 && i >=4) {
				System.out.println(str[i] + "" + num + "개");
			}
		}
	}
}

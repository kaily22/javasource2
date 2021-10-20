package 실습문제1;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {

		int[] bill = { 50000, 5000, 1000, 500, 100, 50, 10, 1 };

		System.out.print("금액을 입력해 주세요 : ");
		Scanner sc = new Scanner(System.in);

		int money = sc.nextInt();

		for (int i = 0; i < bill.length; i++) {

			if (money / bill[i] > 0) {
				if (bill[i] == 50000 || bill[i] == 5000 || bill[i] == 1000) {
					System.out.println(bill[i] + "원권 " + (money / bill[i]) + "매");
				} else {
					System.out.println(bill[i] + "원 " + (money / bill[i]) + "개");
				}
				money %= bill[i];
			}
		}
	}
}

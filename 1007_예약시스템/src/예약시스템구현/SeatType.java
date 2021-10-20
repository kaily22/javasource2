package 예약시스템구현;

import java.util.Scanner;

public class SeatType {
	
	
	private char type;
	
	//좌석의 종류에 따라서 명수가 다름 => 배열로 만들기
	private Seat[] aSeat;  //연관관계 => 멤버변수로 참조하겠다.
	
	//생성자 만들기
	public SeatType(char type, int number) { //인자값(멤버변수로 들어와야함) :좌석유형, 좌석의 개수
		
		this.type = type;
		
		//배열 객체 생성(넘겨받은 개수만큼 만들기)
		
		aSeat = new Seat[number];	
		for(int i=0; i<aSeat.length; i++) {
			aSeat[i] = new Seat();
		}
	}
	
	//사용자 정의 메소드 구현(좌석 예약 조건)
	public boolean seatReserve() {
		
		Scanner sc = new Scanner(System.in);
		int seatNum;
		String name;
		show();
		
		System.out.print("이름  : ");
		name = sc.next();
		
		System.out.print("번호 : ");
		seatNum = sc.nextInt();
		
		if(seatNum < 1 || seatNum > aSeat.length) {
			System.out.println("잘못된 좌석번호입니다.");
			return false;
		}
		
		if(aSeat[seatNum-1].isOccupied()){
			System.out.println("이미 예약된 좌석입니다.");
			return false;
		}
		
		aSeat[seatNum-1].reserveName(name);
		return true;
	}	
	
	public void show() {
		System.out.print(type+"석 예약 ");
		
		for(int i=0; i<aSeat.length; i++) {
			
			//좌석이 예약 되어있는지 아닌지 
			if(aSeat[i].isOccupied()) {
				System.out.print(aSeat[i].getName());
			}else 
				System.out.print("---");
				System.out.print(" ");
			}
		System.out.println();
		}
	
	public boolean cancle() {

		Scanner sc = new Scanner(System.in);
		show();
		System.out.print("이름 : "); //취소할 예약자 이름 입력
		String name = sc.next();
		
		if(name != null) {
			
			for(int i=0; i<aSeat.length; i++) {
				if(aSeat[i].match(name)) {
					aSeat[i].cancel(); //이름을 null로 바꿔줌 -> cancel 메소드 가져오기
					return true;
				}
			}
		System.out.println("취소할 예약자 이름을 찾을 수 없습니다.");
		}
		
		return false;
	}

}

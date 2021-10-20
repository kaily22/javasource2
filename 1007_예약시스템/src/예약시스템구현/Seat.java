package 예약시스템구현;

public class Seat {

	//멤버변수 선언
	private String name;
	

	//생성자 만들기
	public Seat() {
		name = null;
	}
	
	public void reserveName(String name) {
		this.name = name;
	}
	
	public boolean isOccupied() {
		
		//예약자 이름이 null이면
		if(name == null) {
			return false;
		}else
			
		return true;
	}
	
	//예약자 취소할 때 이름 확인
	public boolean match(String name) {
		
		//넘겨받은 이름이 같은지
		return(name.equals(name));
	}

	
	//예약자 취소하는 메소드
	public void cancel() {
		name = null;
	}
	
	//getter 메소드만 구현
	public String getName() {
		return name;
	}
	
}

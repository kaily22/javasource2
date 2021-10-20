package 자바상속예제;



/*
 * Customer는 부모 클래스(상위,슈퍼) => Generalization => '일반적인 클래스' 성격
 * */
public class Customer {
	
	//멤버 변수 선언 => 자식(하위,서브) 클래스에서 공통으로 사용할 속성
	
	protected int customerID; //고객 ID
	protected String customerName; // 고객 Name
	protected String customerGrade; //고객 등급
	protected int bonusPoint; //적립될 보너스 포인트
	protected double bonusRatio;  //적립되는 보너스 포인트 비율
	
	//[추가] 보너스 포인트에 천 단위 마다 콤마 넣기
	String bonusPoint_value;
	
	
	//디폴트 생성자
	public Customer() {
		
	}
	
	//생성자 -> 매개변수만 가지고 있으면 default 생성자 x
	//멤버변수/ 매개변수 -> 구분 this사용 객체 내의 멤버변수 = 매개변수
	public Customer(int customerID, String customerName) {
		
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade="General"; //기본 등급인 GENERAL
		bonusRatio = 0.01; //보너스 포인트 기본 적립 비율 1%
		bonusPoint = 0; 
		
	}
	
	//제품 지불 금액 계산하는 메소드 구현(반환 type : int)
	//사용자 정의 메소드
	public int calcPrice(int price) {
		bonusPoint += bonusRatio * price;
		return price;
	}
	
	public String showCustomerInfo() {
		//[추가]
		bonusPoint_value = Utils.toNumberFormat(bonusPoint);
		return customerName+" 님의 고객등급은" +customerGrade+ "이며, 보너스 포인트는 "+bonusPoint_value+"입니다.";
	}
	
}

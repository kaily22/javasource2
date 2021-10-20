package 자바상속예제;



/*
 * Customer 클래스를 상속받고 VIP  고객에게 필요한 추가 '속성'과 '기능'을 구현
 * 
 */
public class VipCustomer extends Customer{
	
	protected double discount; //할인율
	protected int consultantID;	 //VIP 고객 상담원 아이디
	
	//생성자
	public VipCustomer(int customerID, String customerName, int consultantID) {
		
		//반드시 첫번째 line에
		super(customerID, customerName);
 		customerGrade=" VIP ";
		bonusRatio = 0.05;
		discount = 0.1;
		this.consultantID = consultantID;
	
		//부모에서 상속 받기 때문에 super() 사용이 편리
//		this.customerID=customerID;
//		this.customerName = customerName;

	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += bonusRatio * price;
		return price - (int)(discount * price);
	}
	
	//vip고객에게만 필요한 메소드 //getter적용
	public int getAgent() {
		return consultantID;
	}
	
	public String showCustomerInfo() {
		return customerName+" 님의 고객등급은"+customerGrade+"이며, 보너스 포인트는 "+bonusPoint+"입니다.";
	}
	
}

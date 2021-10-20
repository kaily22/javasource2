package 자바상속예제;


public class GoldCustomer extends Customer{
	
	protected double discount;
	
	public GoldCustomer(int customerID, String customerName) {
		
		super(customerID, customerName);
		this.customerGrade= " GOLD ";
		bonusRatio = 0.02;
		bonusPoint = 0;
		discount = 0.1;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += bonusRatio * price;
		return price - (int)(discount * price);
	}
	
	public String showCustomerInfo() {
		return customerName+" 님의 고객등급은"+ customerGrade +"이며, 보너스 포인트는 "+bonusPoint+" 입니다.";
		
	}
	
	
}

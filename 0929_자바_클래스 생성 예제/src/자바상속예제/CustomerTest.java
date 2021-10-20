package 자바상속예제;

public class CustomerTest {
	
	//[추가]
	public static String price_value;
	
	public static void main(String[] args) {
		
		//객체 생성
		Customer cs = new Customer(12345,"고객1");
		cs.bonusPoint = 10;
		
		System.out.println(cs.showCustomerInfo());
		//고객1 님의 고객등급은General이며, 보너스 포인트는 100.0입니다.
		
		int prices = cs.calcPrice(200000);
		//[추가]
		price_value = Utils.toNumberFormat(prices);
		System.out.println("상품 지불 금액 : " +price_value + "원");
		System.out.println();
		
		
		VipCustomer vip = new VipCustomer(11111,"vip고객",1000);
		vip.bonusPoint = 3000;
		System.out.println(vip.showCustomerInfo());
		
		int vip_price = vip.calcPrice(5000000);
		price_value = Utils.toNumberFormat(vip_price);
		System.out.println("상품 할인율 적용 지불 금액 : " +price_value+ "원");
		
		int agentID = vip.getAgent();
		System.out.println("VIP 고객 담당 상담원 아이디 : " +agentID);
		System.out.println();
		
		GoldCustomer gold  = new GoldCustomer(11234,"gold 고객");
		gold.bonusPoint = 100000;
		System.out.println(gold.showCustomerInfo());
		
		int gold_price = gold.calcPrice(320000000);
		price_value = Utils.toNumberFormat(gold_price);
		
		System.out.println("상품 할인율 적용 지불 금액 : " +price_value+ "원");
		
//		System.out.println("물품 구매 가격 : " +Utils.toNumberFormat(cs.calcPrice(3000)));
//		System.out.println();
//		
//		System.out.println("물품 구매 가격 : " +Utils.toNumberFormat(vip.calcPrice(15000)));
//		System.out.println(vip.showCustomerInfo());
//		System.out.println();
//		
//		System.out.println("물품 구매 가격 : " +Utils.toNumberFormat(gold.calcPrice(20000)));
//		System.out.println(gold.showCustomerInfo());
//		
	}

}

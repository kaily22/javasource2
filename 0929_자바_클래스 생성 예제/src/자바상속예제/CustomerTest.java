package �ڹٻ�ӿ���;

public class CustomerTest {
	
	//[�߰�]
	public static String price_value;
	
	public static void main(String[] args) {
		
		//��ü ����
		Customer cs = new Customer(12345,"��1");
		cs.bonusPoint = 10;
		
		System.out.println(cs.showCustomerInfo());
		//��1 ���� �������General�̸�, ���ʽ� ����Ʈ�� 100.0�Դϴ�.
		
		int prices = cs.calcPrice(200000);
		//[�߰�]
		price_value = Utils.toNumberFormat(prices);
		System.out.println("��ǰ ���� �ݾ� : " +price_value + "��");
		System.out.println();
		
		
		VipCustomer vip = new VipCustomer(11111,"vip��",1000);
		vip.bonusPoint = 3000;
		System.out.println(vip.showCustomerInfo());
		
		int vip_price = vip.calcPrice(5000000);
		price_value = Utils.toNumberFormat(vip_price);
		System.out.println("��ǰ ������ ���� ���� �ݾ� : " +price_value+ "��");
		
		int agentID = vip.getAgent();
		System.out.println("VIP �� ��� ���� ���̵� : " +agentID);
		System.out.println();
		
		GoldCustomer gold  = new GoldCustomer(11234,"gold ��");
		gold.bonusPoint = 100000;
		System.out.println(gold.showCustomerInfo());
		
		int gold_price = gold.calcPrice(320000000);
		price_value = Utils.toNumberFormat(gold_price);
		
		System.out.println("��ǰ ������ ���� ���� �ݾ� : " +price_value+ "��");
		
//		System.out.println("��ǰ ���� ���� : " +Utils.toNumberFormat(cs.calcPrice(3000)));
//		System.out.println();
//		
//		System.out.println("��ǰ ���� ���� : " +Utils.toNumberFormat(vip.calcPrice(15000)));
//		System.out.println(vip.showCustomerInfo());
//		System.out.println();
//		
//		System.out.println("��ǰ ���� ���� : " +Utils.toNumberFormat(gold.calcPrice(20000)));
//		System.out.println(gold.showCustomerInfo());
//		
	}

}

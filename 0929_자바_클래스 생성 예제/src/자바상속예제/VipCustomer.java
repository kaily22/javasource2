package �ڹٻ�ӿ���;



/*
 * Customer Ŭ������ ��ӹް� VIP  ������ �ʿ��� �߰� '�Ӽ�'�� '���'�� ����
 * 
 */
public class VipCustomer extends Customer{
	
	protected double discount; //������
	protected int consultantID;	 //VIP �� ���� ���̵�
	
	//������
	public VipCustomer(int customerID, String customerName, int consultantID) {
		
		//�ݵ�� ù��° line��
		super(customerID, customerName);
 		customerGrade=" VIP ";
		bonusRatio = 0.05;
		discount = 0.1;
		this.consultantID = consultantID;
	
		//�θ𿡼� ��� �ޱ� ������ super() ����� ��
//		this.customerID=customerID;
//		this.customerName = customerName;

	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += bonusRatio * price;
		return price - (int)(discount * price);
	}
	
	//vip�����Ը� �ʿ��� �޼ҵ� //getter����
	public int getAgent() {
		return consultantID;
	}
	
	public String showCustomerInfo() {
		return customerName+" ���� �������"+customerGrade+"�̸�, ���ʽ� ����Ʈ�� "+bonusPoint+"�Դϴ�.";
	}
	
}

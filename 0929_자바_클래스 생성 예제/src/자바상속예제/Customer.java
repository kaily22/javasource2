package �ڹٻ�ӿ���;



/*
 * Customer�� �θ� Ŭ����(����,����) => Generalization => '�Ϲ����� Ŭ����' ����
 * */
public class Customer {
	
	//��� ���� ���� => �ڽ�(����,����) Ŭ�������� �������� ����� �Ӽ�
	
	protected int customerID; //�� ID
	protected String customerName; // �� Name
	protected String customerGrade; //�� ���
	protected int bonusPoint; //������ ���ʽ� ����Ʈ
	protected double bonusRatio;  //�����Ǵ� ���ʽ� ����Ʈ ����
	
	//[�߰�] ���ʽ� ����Ʈ�� õ ���� ���� �޸� �ֱ�
	String bonusPoint_value;
	
	
	//����Ʈ ������
	public Customer() {
		
	}
	
	//������ -> �Ű������� ������ ������ default ������ x
	//�������/ �Ű����� -> ���� this��� ��ü ���� ������� = �Ű�����
	public Customer(int customerID, String customerName) {
		
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade="General"; //�⺻ ����� GENERAL
		bonusRatio = 0.01; //���ʽ� ����Ʈ �⺻ ���� ���� 1%
		bonusPoint = 0; 
		
	}
	
	//��ǰ ���� �ݾ� ����ϴ� �޼ҵ� ����(��ȯ type : int)
	//����� ���� �޼ҵ�
	public int calcPrice(int price) {
		bonusPoint += bonusRatio * price;
		return price;
	}
	
	public String showCustomerInfo() {
		//[�߰�]
		bonusPoint_value = Utils.toNumberFormat(bonusPoint);
		return customerName+" ���� �������" +customerGrade+ "�̸�, ���ʽ� ����Ʈ�� "+bonusPoint_value+"�Դϴ�.";
	}
	
}

package ����ý��۱���;

public class Seat {

	//������� ����
	private String name;
	

	//������ �����
	public Seat() {
		name = null;
	}
	
	public void reserveName(String name) {
		this.name = name;
	}
	
	public boolean isOccupied() {
		
		//������ �̸��� null�̸�
		if(name == null) {
			return false;
		}else
			
		return true;
	}
	
	//������ ����� �� �̸� Ȯ��
	public boolean match(String name) {
		
		//�Ѱܹ��� �̸��� ������
		return(name.equals(name));
	}

	
	//������ ����ϴ� �޼ҵ�
	public void cancel() {
		name = null;
	}
	
	//getter �޼ҵ常 ����
	public String getName() {
		return name;
	}
	
}

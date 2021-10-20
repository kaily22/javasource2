package Set�迭��Ŭ��������;


/*�����ڰ� � Ŭ������ ������ �� ������ �� �ֻ��� Ŭ������ 
 * Object Ŭ�����κ��� ����� �ް� �ȴ�.
 * */

public class Member extends Object { //�������Ҷ� �̹�  object�� ����� �޴´�.
	
	//�ν��Ͻ� ����(��ü ����)���� 
	private String name; //�̸�
	private int age; //����
	private String juminNum; //�ֹι�ȣ
	
	//������
	public Member(String name, int age, String juminNum) {
		this.name=name; //�ν��Ͻ�, �Ű����� �̸� ���� �� �ν��Ͻ� �տ��ٰ� this�� ���δ�/�ٸ��� x 
		this.age = age;
		this.juminNum = juminNum;
	}

	@Override //������
	public int hashCode() { //������ //����Ÿ�� 3���� �ʵ尪�� ���� �ؽð��� �� return
		return name.hashCode() + age + juminNum.hashCode();
	}
	
	@Override //������(ObjectŬ������) -> �ڽ��� ��ӹ޾Ƽ� �������ؼ� ���
	public boolean equals(Object obj) { //equals�޼ҵ�� �Ѱ��ش�.
		//��������  instanceof Ÿ��(Ŭ������)
		if(obj instanceof Member) { 
			Member member = (Member)obj; 
			return member.name.equals(name) && (member.age == age) && member.juminNum.equals(juminNum);
	}else {
		return false;
	}
//	return super.equals(obj);
 }
}


package �̸�����ȿ���˻�����;


/*
 *  �̸��� �����Ϳ� ��ȿ�� �˻� ���� ����
 */

public class EmailRegexEx {

	public static void main(String[] args) {
		
		String[] email_ex = {"king5901@naver.com","kim123@gmail.com","erin0521@partner.sk.com","asd456@partner.sk.com"};
		
		
		//�̸��� ����
		String email_pattern = "^\\w+@\\w+\\.\\w+(\\.\\w+)?";
		
		
		for(String email : email_ex) {
			boolean check = email.matches(email_pattern);
			
			if(check == true) {
				System.out.println("������ �̸��� �Դϴ�. : " +email);
			}else {
				System.out.println("�������� �̸����Դϴ�. : " +email);
			}
			
		}
		
	}

}

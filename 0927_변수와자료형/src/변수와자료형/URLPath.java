package �������ڷ���;


/*
 * �߿� ����
 * 
 * */

public class URLPath {
	public static void main(String[] args) {
		
		String url = "http://localhost:8080/Model2_Board/login.do";
		
		int lastPosition = url.lastIndexOf("/"); //������ ���ڿ� ã�� ���ؼ�
		
		String filePath = url.substring(lastPosition); //��ġ���� ã�Ƴ���
		System.out.println(filePath); //34�� ���
	}
}

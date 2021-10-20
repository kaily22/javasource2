package Set�迭��Ŭ��������;

import java.util.HashSet;
import java.util.Set;

/*
 * HashSet�� ��ü�� �����ϱ� ����
 * ���� ��ü�� hashCode() �޼ҵ带 ȣ���ؼ� �ؽ��ڵ� ���� ��´�.
 * �׸��� �̹�  ����Ǿ� �ִ� ��ü���� �ؽ��ڵ�� ���Ѵ�.
 * ���� ������ �ؽ��ڵ尡 �ִٸ� equals() �޼ҵ�� �� ��ü�� ���ؼ�
 * true�� ������ ������ ��ü�� �Ǵ��ϰ� �ߺ� ������ ���� �ʴ´�.
 * 
 * */

public class HashSetClassEx { //���� Ŭ����

	public static void main(String[] args) {
		//HashSet ��ü ����(Member��ü Ÿ���� ����)
		Set<Member> member_set = new HashSet<Member>();
		
		//member��ü ����. ������ �����
		//[���] �������� ��� �Ȱ��� ��ü�� �� ���� ������ �� ����.
 		
		Member member1 = new Member("�����", 29, "111111-1111111");
		Member member2 = new Member("�����", 29, "111111-1111111");
		
		
		member_set.add(member1);
		member_set.add(member2);
		
		System.out.println("�� ��ü�� : " +member_set.size());
		
		//������ ��ü 1��/ �ٸ��� 2�� �������
		System.out.println(member1.hashCode()); //-1166721464
		System.out.println(member2.hashCode()); //-1166721464
		
		System.out.println(member1.equals(member2)); //true
	}
} 

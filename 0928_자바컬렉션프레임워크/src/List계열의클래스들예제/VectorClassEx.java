package List�迭��Ŭ�����鿹��;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorClassEx {
	public static void main(String[] args) {
		
		String[] name = {"������","����ȣ ","������","��ȫ��","�ڰ渮"};
		
		//Vector ��ü ����. ������ �����ε�
//		List<String> list = new Vector<String>(); //�⺻�� 10���� ���� �迭�� ����
		
		//ó�� 4���� ���� ����� �����ϸ� 3���� ����(���Ϳ� ������ �ص� ����)
		//List<E>(���׸�) list = new Vector<E>(); //�Ϲ����� ���
		List<String> list = new Vector<String>(4, 3);
		
		//Vector Ŭ������ �޼ҵ� Ȱ��
		System.out.println("���Ϳ� ����� ����� ����: " +list.size());
		System.out.println("������ �뷮�� : " +((Vector<String>)list).capacity()); //4�� ���
		
		/* ��ü �߰�*/
		for(int i=0; i<name.length;i++) {
			list.add(name[i]); //��ü �߰� -> �������� �߰�
		}
		
		System.out.println("���Ϳ� ����� ����� ����: " +list.size()); //5�� ���
		System.out.println("������ �뷮�� : " +((Vector<String>)list).capacity()); //7�� ���
		
		
		System.out.println(list);
		//[������,����ȣ,������,��ȫ��,�ڰ渮]
		
		list.add(2, "������"); //���ϴ� �ε����� �߰�
		System.out.println(list);

		/* ��ü �˻� / get() �޼ҵ� / contains() �޼ҵ� */
		
		System.out.println(list.get(1));
		//����ȣ
		
		// contains() -> true/false��ȯ
		
		boolean contains_result = list.contains("��ȫ��");
		System.out.println(contains_result); //true
		
		boolean contains_result2 = list.contains("ȫ�浿");
		System.out.println(contains_result2); //true
		
		System.out.println(list.size());
		
		/* ��ü ����  set() �޼ҵ�  */
		//�������̶�� ��ü�� �̹��Ϸ� �����ϰ��� �Ѵ�.
		list.set(2, "�̹���");
		System.out.println(list);
				
		/* ��ü ����*/
		list.remove(3);
		System.out.println(list);
		
		list.remove("��ȫ��");
		System.out.println(list);

		System.out.println(); 

		/* ��ü ���� => ���� ����  */
		Collections.sort(list);
		System.out.println("[��ü �������� ����] : " +list);

		System.out.println();
		
		/* �������� */
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("[��ü �������� ����] : " +list);
	}

}

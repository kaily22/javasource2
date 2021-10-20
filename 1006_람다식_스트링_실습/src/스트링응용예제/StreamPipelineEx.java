package ��Ʈ�����뿹��;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamPipelineEx {

	public static void main(String[] args) {
		
		List<Member> list = (List)Arrays.asList(new Member("����ȣ",Member.MALE,30),
				                                new Member("�迬��",Member.FEMALE,29),
				                                new Member("������",Member.MALE,32),
				                                new Member("������",Member.MALE,27));
		
		
		//[1���] �ܺ� �ݺ��ڸ� �����Ͽ� �ذ�
		//�� iterator�� �ƴϴ��� index�� �̿��ϴ� for�� �׸��� Iterator�� �̿��ϴ� while��
		
//		int count = 0;
//		double sum = 0;
//		
//		//�� ������ �� get(i)
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getGender() == Member.MALE) {
//				sum += list.get(i).getAge();
//				count++;
//			}
//		}
//		
//		double ageAvg =  sum/count;
//		System.out.println("���� ȸ���� ��� ���� : " +ageAvg); //30,32,27
//
//		
		
		//[2���] ���� �ݺ��ڸ� �����Ͽ� �ذ�
		//�÷������κ��� ��Ʈ�� ����
		double ageAvg = list.stream() // �������� ��Ʈ��
				            .filter(m -> m.getGender() == Member.MALE) //�߰�ó����Ʈ��
				            .mapToInt(Member::getAge) //�߰� ó�� ��Ʈ��(Member ��ü�� age������ ����)
				            .average().getAsDouble(); //���� ó�� ��Ʈ��
		
		System.out.println("���� ȸ���� ��� ���� : " +Math.ceil(ageAvg));
	}

}

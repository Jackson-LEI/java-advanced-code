package classTeaching.week8;
// ����Begin-End���д����
/********** Begin **********/
// ��һ��;���������

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

// �ڶ���������HashMapTest��
public class HashMapTest {
    public static void main(String[] args) {
        // �����������ո����ַ���
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        // ���Ĳ�������HashMap���ϣ�keyΪ���ʣ�valueΪ���ʳ��ִ���
        HashMap<String, Integer> map = new HashMap<>();
        // ���岽���и��ַ���
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                //�������� �жϼ������Ƿ����и��ĵ��ʣ��еĻ���ȡ�����е��ʳ��ִ�������1֮����¼����е��ʳ��ִ���
                Integer count = map.get(arr[i]);
                map.replace(arr[i], count + 1);
            } else {
                //���߲��� �жϼ������Ƿ����и��ĵ��ʣ�û�еĻ������ʸ�ֵΪ1����ӽ�����
                map.put(arr[i], 1);
            }
        }
        //�ڰ˲��� �������ϣ��������Ԫ��
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        /********** End **********/
    }
}

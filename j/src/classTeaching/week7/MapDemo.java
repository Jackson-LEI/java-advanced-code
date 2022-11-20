package classTeaching.week7;

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        // ����HashMap����
        HashMap<String, String> map = new HashMap<>();

        // �򼯺������4��������Ϣ
        map.put("CN", "China");
        map.put("JP", "Japan");
        map.put("RU", "Russia");
        map.put("FR", "France");

        // ��ӡ������еļ���
        System.out.println("����:" + map.keySet());

        // ��ӡ������е�ֵ��
        System.out.println("ֵ��:" + map.values());

        // ��ӡ���ϴ�С
        System.out.println("���ϴ�С:" + map.size());

        // ɾ�������м�Ϊ"FR"��Ԫ�أ�����ʾԪ������
        System.out.println("ɾ����Ԫ��:" + map.remove("FR"));

        // �ֱ��ӡ�����е�ÿ��ӳ��ļ���ֵ
        for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}

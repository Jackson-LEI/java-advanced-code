package classTeaching.week3;

public class DemoPeople {
    public static void main(String[] args) {
        People p1 = new People("����", "�����Ƽ�ѧԺ", 20, "123456789");
        System.out.println("���Լ�:" + p1);

        People p2 = new People("�ഫ��", "�����Ƽ�ѧԺ", 200, "1001011");
        System.out.println("������:" + p2);

        People p3 = new People();
        p3.setName("���");
        p3.setAddress("��");
        p3.setAge(28);
        p3.setTelephone("10086");
        System.out.println("�Ҽ���:" + p3);
    }
}

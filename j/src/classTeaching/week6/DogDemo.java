package classTeaching.week6;

import java.util.ArrayList;

public class DogDemo {

    public static void main(String[] args) {
        ArrayList<Dog> list = new ArrayList<>();
        Dog huahuaDog = new Dog("����", 1);
        Dog yayaDog = new Dog("ѾѾ", 6);
        Dog meimeiDog = new Dog("����", 3);
        Dog feifeiDog = new Dog("�ɷɱ�", 200);
        Dog dafeifeiDog = new Dog("��ɷ�", 4);

        list.add(huahuaDog);
        list.add(yayaDog);
        list.add(meimeiDog);
        list.add(feifeiDog);
        list.add(dafeifeiDog);
        System.out.println("������" + list.size() + "������\n�ֱ���:");
        list.forEach(System.out::println);
        System.out.println();

        // ɾ����1��λ���ϵĹ���
        list.remove(1);
        // ɾ������
        list.remove(meimeiDog);
        System.out.println("ArrayList���д�ɷ���" + list.contains(dafeifeiDog));
        list.forEach(System.out::println);
    }

}

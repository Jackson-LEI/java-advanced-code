package classTeaching.week6;

import java.util.LinkedList;

public class DogDemo2 {

    public static void main(String[] args) {
        LinkedList<Dog> list = new LinkedList<>();
        Dog huahuaDog = new Dog("���", 100);
        Dog yayaDog = new Dog("�Ѽ�", 60);
        Dog meimeiDog = new Dog("����", 3);
        Dog feifeiDog = new Dog("����", 20);
        Dog dafeifeiDog = new Dog("�ɱ�", 4);

        list.add(huahuaDog);
        list.add(yayaDog);
        list.add(meimeiDog);
        list.add(feifeiDog);
        list.add(dafeifeiDog);
        list.forEach(System.out::println);
        System.out.println("��һ����������" + list.getFirst().getName());
        System.out.println("���һ����������" + list.getLast().getName());

        list.removeFirst();
        list.removeLast();
        System.out.println("ɾ����һ�����������һ����������ʣ��:");
        list.forEach(System.out::println);

    }

}

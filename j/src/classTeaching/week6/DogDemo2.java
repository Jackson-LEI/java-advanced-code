package classTeaching.week6;

import java.util.LinkedList;

public class DogDemo2 {

    public static void main(String[] args) {
        LinkedList<Dog> list = new LinkedList<>();
        Dog huahuaDog = new Dog("风风", 100);
        Dog yayaDog = new Dog("佳佳", 60);
        Dog meimeiDog = new Dog("马马", 3);
        Dog feifeiDog = new Dog("美美", 20);
        Dog dafeifeiDog = new Dog("飞宝", 4);

        list.add(huahuaDog);
        list.add(yayaDog);
        list.add(meimeiDog);
        list.add(feifeiDog);
        list.add(dafeifeiDog);
        list.forEach(System.out::println);
        System.out.println("第一条狗狗叫做" + list.getFirst().getName());
        System.out.println("最后一条狗狗叫做" + list.getLast().getName());

        list.removeFirst();
        list.removeLast();
        System.out.println("删除第一条狗狗和最后一条狗狗，还剩下:");
        list.forEach(System.out::println);

    }

}

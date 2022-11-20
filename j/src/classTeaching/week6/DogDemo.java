package classTeaching.week6;

import java.util.ArrayList;

public class DogDemo {

    public static void main(String[] args) {
        ArrayList<Dog> list = new ArrayList<>();
        Dog huahuaDog = new Dog("花花", 1);
        Dog yayaDog = new Dog("丫丫", 6);
        Dog meimeiDog = new Dog("美美", 3);
        Dog feifeiDog = new Dog("飞飞宝", 200);
        Dog dafeifeiDog = new Dog("大飞飞", 4);

        list.add(huahuaDog);
        list.add(yayaDog);
        list.add(meimeiDog);
        list.add(feifeiDog);
        list.add(dafeifeiDog);
        System.out.println("共计有" + list.size() + "条狗狗\n分别是:");
        list.forEach(System.out::println);
        System.out.println();

        // 删除第1个位置上的狗狗
        list.remove(1);
        // 删除美美
        list.remove(meimeiDog);
        System.out.println("ArrayList中有大飞飞吗？" + list.contains(dafeifeiDog));
        list.forEach(System.out::println);
    }

}

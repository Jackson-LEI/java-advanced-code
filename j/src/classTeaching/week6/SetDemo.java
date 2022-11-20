package classTeaching.week6;

import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(52);
        set.add(54);
        set.add(1);
        set.add(2);
        // HashSet对象的forEach()方法可以输出set中的元素
        set.forEach(System.out::println);

    }

}

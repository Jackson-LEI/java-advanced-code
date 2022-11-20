package classTeaching.week8;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTask {
    public static void main(String[] args) {
        // 请在Begin-End间编写代码
        /********** Begin **********/
        // 第1步：创建集合
        TreeSet<Student> set = new TreeSet<>();
        // 第2步：Student类的对象添加进集合
        set.add(new Student("李英迪", 20208001));
        set.add(new Student("金雷", 20209002));
        set.add(new Student("熊健柱", 20207003));
        set.add(new Student("万笑", 20205004));
        set.add(new Student("余传珏", 20206002));

        //第3步：按学号逆序顺序打印学生信息
        System.out.println("逆序输出:");
        Iterator<Student> i = set.descendingIterator();//也可以使用set.descendingSet()
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        //第4步： 输出学号最小的学生信息
        System.out.println("学号最小的学生:" + set.first());
        //第5步： 输出学号最大的学生信息
        System.out.println("学号最大的学生:" + set.last());
        //第6步： 移除学号最小的学生信息
        System.out.println("移除学号最小的学生:" + set.pollFirst());
        //第7步： 移除学号最大的学生信息
        System.out.println("移除学号最大的学生:" + set.pollLast());
        // 第8步：打印集合元素
        System.out.println("学号\t姓名\n---------------------");
        set.forEach(System.out::println);
    }
}

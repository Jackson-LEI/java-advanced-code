package classTeaching.week8;

import java.util.HashSet;

public class HashSetTask {

    public static void main(String[] args) {
        // 请在Begin-End间编写代码
        /********** Begin **********/
        // 第1步：创建集合
        HashSet<Student> set = new HashSet<>();
        // 第2步：Student类的对象添加进集合
        Student s1 = new Student("李英迪", 20208001);
        Student s2 = new Student("金雷", 20209002);
        Student s3 = new Student("熊健柱", 20207003);
        Student s4 = new Student("余传珏", 20206002);
        Student s5 = new Student("李英迪", 20205004);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        // 第3步：判断集合中元素个数是否大于4
        System.out.print("集合中的元素大于是否大于4?" + (set.size() > 4));
        // 第5步：判断集合元素中是否含有指定（例如：姓名：刘芳萍 ，学生证号：20207073），输出提示信息
        System.out.print("集合中有刘芳萍吗?" + (set.contains(new Student("刘芳萍", 20207073))));
        // 第6步：当集合中不含有指定对象（如：刘芳萍：20207073）时，把该元素添加进集合
        if (set.contains(new Student("刘芳萍", 20207073))) {
            set.add(new Student("刘芳萍", 20207073));
        }
        // 第7步：移除指定对象（例如：姓名：万笑 学生证号：20205004），并输出提示信息
        System.out.print("移除指定对象万笑" + set.remove(new Student("万笑", 20205004)));
        // 第8步：打印集合元素
        set.forEach(System.out::println);
        /********** End **********/
    }
}

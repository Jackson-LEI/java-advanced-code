package classTeaching.week8;

import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        // 请在Begin-End间编写代码
        /********** Begin **********/

        // 第1步：接收给定字符串
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        // 第2步：创建TreeMap集合，key为学生序号，value为学生姓名
        TreeMap<Integer, String> map = new TreeMap<>();
        // 第3步：切割字符串
        String[] arr = s.split("，");
        // 第4步：把元素添加到集合中
        for (int i = 0; i < arr.length; i++) {
            map.put(Integer.valueOf(arr[i].substring(0, arr[i].indexOf("："))),
                    arr[i].substring(arr[i].indexOf("：") + 1));
        }
        // 第5步：逆序输出所有学生序号
        System.out.println("逆序输出:" + map.descendingKeySet());
        // 第6步：输出学生序号最大和最小的元素
        System.out.println("学号最大的元素:" + map.lastEntry());
        System.out.println("学号最小的元素:" + map.firstEntry());

        // 第7步：删除学生序号最小的元素
        System.out.println("删除学号最小的元素:" + map.pollFirstEntry());
        //第8步：打印集合

        System.out.println(map.toString().replace("=", "："));
        /********** End **********/
    }
}

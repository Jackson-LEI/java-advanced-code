package classTeaching.week8;
// 请在Begin-End间编写代码
/********** Begin **********/
// 第一步;导入相关类

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

// 第二步：创建HashMapTest类
public class HashMapTest {
    public static void main(String[] args) {
        // 第三步：接收给定字符串
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        // 第四步：创建HashMap集合，key为单词，value为单词出现次数
        HashMap<String, Integer> map = new HashMap<>();
        // 第五步：切割字符串
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                //第六步： 判断集合中是否有切割后的单词，有的话获取集合中单词出现次数，加1之后更新集合中单词出现次数
                Integer count = map.get(arr[i]);
                map.replace(arr[i], count + 1);
            } else {
                //第七步： 判断集合中是否有切割后的单词，没有的话给单词赋值为1，添加进集合
                map.put(arr[i], 1);
            }
        }
        //第八步： 遍历集合，输出所有元素
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        /********** End **********/
    }
}

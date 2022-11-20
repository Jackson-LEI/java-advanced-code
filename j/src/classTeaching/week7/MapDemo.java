package classTeaching.week7;

import java.util.HashMap;

public class MapDemo {
    public static void main(String[] args) {
        // 创建HashMap对象
        HashMap<String, String> map = new HashMap<>();

        // 向集合中添加4个国家信息
        map.put("CN", "China");
        map.put("JP", "Japan");
        map.put("RU", "Russia");
        map.put("FR", "France");

        // 打印输出所有的键集
        System.out.println("键集:" + map.keySet());

        // 打印输出所有的值集
        System.out.println("值集:" + map.values());

        // 打印集合大小
        System.out.println("集合大小:" + map.size());

        // 删除集合中键为"FR"的元素，并显示元素内容
        System.out.println("删除的元素:" + map.remove("FR"));

        // 分别打印集合中的每个映射的键与值
        for (java.util.Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}

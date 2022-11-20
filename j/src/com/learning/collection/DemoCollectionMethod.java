package com.learning.collection;

import java.util.ArrayList;
import java.util.List;

public class DemoCollectionMethod {
    @SuppressWarnings({"all"})
    // SuppressWarnings批注可以告诉编译器对下面代码中的警告保持静默
    public static void main(String[] args) {
        // Collection类方法

        List l = new ArrayList();
        // 使用List类创建对象l，使用List的子类ArrayList将对象实例化

        // add()方法可以向集合中添加单个元素
        l.add("jack");
        l.add(10);
        l.add(true);
        /*
         * add()方法中传递了一个Object类型的参数，也就是说，添加到数组里的是一个包装过的对象， 而不是基本数据类型(自动装箱)，等同于 l.add(new
         * Integer(10)); l.add(new Boolean(true));
         */
        System.out.println(l);// 这里重写了toString()方法

        // remove()方法可以删除数组里的单个元素
        // 删除的可以是一个对象，也可以是一个下标(remove()方法的重载)
        l.remove(0);// 删除l中下标为0的元素
        l.remove("jack");// 删除内容为“jack”的元素
        System.out.println(l);

        // contains()方法可以判断元素是否存在
        System.out.println(l.contains(true));

        // size()方法可以获取元素个数
        System.out.println(l.size());

        // isEmpty()方法可以判断数组是否为空
        System.out.println(l.isEmpty());

        // clear()方法可以清空数组
        l.clear();
        System.out.println(l);

        // addAll()方法可以添加多个元素
        List l1 = new ArrayList();
        l1.add("红楼梦");
        l1.add("三国演义");
        l.addAll(l1);

        // containsAll()方法可以判断多个元素是否存在，传递的参数只能是一个collection对象
        System.out.println(l.containsAll(l1));

        // removeAll()方法可以删除多个元素，传递的参数只能是一个collection对象
        l.add("聊斋");
        l.removeAll(l1);// 从l中删除与l1中相同的元素
        System.out.println(l);
    }

}

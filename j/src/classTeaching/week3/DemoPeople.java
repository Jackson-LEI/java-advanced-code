package classTeaching.week3;

public class DemoPeople {
    public static void main(String[] args) {
        People p1 = new People("金雷", "江西科技学院", 20, "123456789");
        System.out.println("我自己:" + p1);

        People p2 = new People("余传珏", "江西科技学院", 200, "1001011");
        System.out.println("我朋友:" + p2);

        People p3 = new People();
        p3.setName("姐姐");
        p3.setAddress("家");
        p3.setAge(28);
        p3.setTelephone("10086");
        System.out.println("我家人:" + p3);
    }
}

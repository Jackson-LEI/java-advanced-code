package classTeaching.week4;

public class DemoBook {

    public static void main(String[] args) {
        Book b1 = new Book("活着", "余华", "中国出版社", 2000);
        System.out.println(b1);
        Book b2 = new Book("Java应用开发与实践", "王飞雪", "西安电子科技大学出版社", 50000);
        System.out.println(b2);
        System.out.println(b2 + "20");
    }
}

package classTeaching.week11;

public class ThreadTest extends Thread{
    private static int tickets = 20;
    @Override
    public void run() {
        while(tickets>0){
            tickets--;
            System.out.println(Thread.currentThread().getName() + "����1��Ʊ��ʣ��Ʊ��"+tickets);
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName()+"sale out.");
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadTest();
        t1.setName("��Ʊ����1");
        t1.start();
    }
}

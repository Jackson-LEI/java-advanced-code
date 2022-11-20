package classTeaching.week11;

public class ThreadRunableTest implements Runnable{
    private static int tickets = 20;
    @Override
    public void run() {
        synchronized (this){
            while(tickets>0){
                tickets--;
                System.out.println(Thread.currentThread().getName() + "����1��Ʊ��ʣ��Ʊ��"+tickets);
                try{
                    Thread.sleep(500);//����0.5��
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"sale out.");
    }

    public static void main(String[] args) {
        Runnable runable = new ThreadRunableTest();
        Thread t1 = new Thread(runable);
        Thread t2 = new Thread(runable);
        t1.setName("��Ʊ����1");
        t2.setName("��Ʊ����2");
        t1.start();
        t2.start();
    }
}

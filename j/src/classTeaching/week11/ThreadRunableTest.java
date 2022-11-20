package classTeaching.week11;

public class ThreadRunableTest implements Runnable{
    private static int tickets = 20;
    @Override
    public void run() {
        synchronized (this){
            while(tickets>0){
                tickets--;
                System.out.println(Thread.currentThread().getName() + "卖出1张票，剩余票数"+tickets);
                try{
                    Thread.sleep(500);//休眠0.5秒
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
        t1.setName("售票窗口1");
        t2.setName("售票窗口2");
        t1.start();
        t2.start();
    }
}

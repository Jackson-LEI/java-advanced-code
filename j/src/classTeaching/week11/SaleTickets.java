package classTeaching.week11;

import java.util.Random;

public class SaleTickets implements Runnable {
    private static int tickets = 1000;
    private Random r = new Random();

    public synchronized static void sale(int n){
        n = Math.min(n, tickets);
        tickets-=n;
        System.out.println(Thread.currentThread().getName() + "卖出"+n+"张票，剩余:"+tickets);
    }
    @Override
    public void run() {
        while(tickets>0){
            sale(r.nextInt(5)+1);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Runnable r = new SaleTickets();
        Thread t1 = new Thread(r);
        t1.setName("售票窗口1");
        Thread t2 = new Thread(r);
        t2.setName("售票窗口2");
        Thread t3 = new Thread(r);
        t3.setName("售票窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

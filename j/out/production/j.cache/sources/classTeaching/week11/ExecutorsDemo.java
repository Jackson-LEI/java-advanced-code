package classTeaching.week11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: ExecutorsDemo.class */
public class ExecutorsDemo {
    private static int tickets = 20;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.submit(new Runnable() { // from class: classTeaching.week11.ExecutorsDemo.1
                @Override // java.lang.Runnable
                public void run() {
                    while (ExecutorsDemo.tickets > 0) {
                        ExecutorsDemo.tickets--;
                        System.out.println(Thread.currentThread().getName() + "卖出1张票，剩余票数" + ExecutorsDemo.tickets);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "sale out.");
                }
            });
        }
        pool.shutdown();
    }
}
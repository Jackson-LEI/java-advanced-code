package classTeaching.week11;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTaskTest implements Callable<String> {
    private static int tickets = 30;
    private static Random r = new Random();

    public synchronized static void sale(int n){
        if(n>=tickets){
            n=tickets;
        }
        tickets -=n;
        System.out.println(Thread.currentThread().getName()+"卖出"+n+"张票"+tickets);
    }

    @Override
    public String call() throws Exception {
        while(tickets>0){
            sale(r.nextInt(5)+1);
            Thread.sleep(500);
        }
        return Thread.currentThread().getName()+"sale out";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new CallableFutureTaskTest();
        FutureTask<String> ft1 = new FutureTask<>(c);
        FutureTask<String> ft2 = new FutureTask<>(c);
        Thread t1 = new Thread(ft1);
        Thread t2 = new Thread(ft2);
        t1.setName("售票窗口1");
        t2.setName("售票窗口2");
        t1.start();
        t2.start();
        System.out.println(ft1.get());
        System.out.println(ft2.get());
    }
}

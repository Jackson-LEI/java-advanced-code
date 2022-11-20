package classTeaching.week11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    private  static int tickets = 20;
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    while(tickets>0){
                        tickets--;
                        System.out.println(Thread.currentThread().getName() + "����1��Ʊ��ʣ��Ʊ��"+tickets);
                        try{
                            Thread.sleep(500);//����0.5��
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+"sale out.");
                }
            });
        }
        pool.shutdown();
    }

}

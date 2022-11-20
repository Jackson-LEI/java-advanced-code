package finalExam;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for(int i=3;i<=100;i++){
            if(i%3==0){
                System.out.println(i+"能被3整除！");
            }
        }
    }

    public static void main(String[] args) {
        new ThreadDemo().start();
        for(int i=5;i<=100;i++){
            if(i%5==0){
                System.out.println(i+"能被5整除！");
            }
        }
    }
}

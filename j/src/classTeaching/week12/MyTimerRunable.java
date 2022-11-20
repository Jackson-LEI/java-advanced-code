package classTeaching.week12;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimerRunable extends JFrame implements Runnable {
    private static JLabel showTime = new JLabel();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 HH:mm:ss");

    public MyTimerRunable(){
        showTime.setFont(new Font("宋体",Font.PLAIN,29));
        showTime.setHorizontalAlignment(JLabel.CENTER);
        this.add(showTime);
        this.getContentPane().setBackground(new Color(0, 187, 255));
        this.setTitle("时间");
        this.setSize(500,200);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void run() {
        while(true){
            showTime.setText(sdf.format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Runnable runable = new MyTimerRunable();
        Thread t = new Thread(runable);
        t.start();
    }
}

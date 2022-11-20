package classTeaching.week12;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimer extends Thread{
    private static JLabel showTime = new JLabel();
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 HH:mm:ss");
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
        Thread time = new MyTimer();
        time.start();
        showTime.setFont(new Font("宋体",Font.PLAIN,25));
        showTime.setHorizontalAlignment(JLabel.CENTER);
        JFrame win = new JFrame();
        win.add(showTime);
        win.getContentPane().setBackground(Color.BLUE);
        win.setTitle("时间");
        win.setSize(500,200);
        win.setVisible(true);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

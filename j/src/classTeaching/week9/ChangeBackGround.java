package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeBackGround extends JFrame {

    public ChangeBackGround(){
        JPanel jp = new JPanel();
        JMenuBar j1 = new JMenuBar();
        JMenu j = new JMenu("选择");
        j1.add(j);
        JMenuItem ji1 = new JMenuItem("蓝色",'B');
        JMenuItem ji2 = new JMenuItem("绿色",'G');
        JMenuItem ji3 = new JMenuItem("黑色",'A');

        j.add(ji1);
        j.add(ji2);
        j.add(ji3);
        ji1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.setBackground(Color.BLUE);
            }
        });
        ji2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.setBackground(Color.GREEN);
            }
        });
        ji3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.setBackground(Color.BLACK);
            }
        });
        this.add(jp);
        this.setJMenuBar(j1);
        this.setTitle("颜色设置");
        this.setSize(300,300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        ChangeBackGround cb = new ChangeBackGround();
    }
}

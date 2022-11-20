package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class RandomColor extends JFrame {

    JButton changeColor;

    public RandomColor(){
        JPanel j = new JPanel();
        changeColor = new JButton("改变背景颜色");
        Random r = new Random();
        changeColor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                j.setBackground(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
            }
        });
        j.add(changeColor);
        this.add(j);
        this.setTitle("自由变色");
        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        RandomColor rd = new RandomColor();
    }
}

package finalExam;

import javax.swing.*;
import java.awt.*;

public class Homework1 extends Canvas {

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(150,30,200,200);
        g.setFont(new Font("Arial",Font.BOLD,55));
        g.setColor(Color.BLACK);
        g.drawString("JXUT",180,150);
    }

    public static void main(String[] args) {
        JFrame win = new JFrame("ื๗าต");
        Homework1 h = new Homework1();
        win.setSize(500,300);
        win.setLocationRelativeTo(null);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

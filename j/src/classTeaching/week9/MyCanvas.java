package classTeaching.week9;

import javax.swing.*;
import java.awt.*;

public class MyCanvas extends Canvas {
    @Override
    public void paint(Graphics g) {
        g.drawLine(100,100,300,300);
        g.drawRect(100,100,200,200);
        g.drawOval(100,100,200,200);

        g.setColor(new Color(0,0,255));
        g.fillOval(100,100,400,400);
        g.setColor(Color.CYAN);
        g.setFont(new Font("ºÚÌå",Font.BOLD,27));
        g.drawString("Kim Jackson",120,300);
//        ImageIcon ii = new ImageIcon("img\\bg.jpg");
//        g.drawImage(ii.getImage(),0,0,ii.getIconWidth()/3,ii.getIconWidth()/3,ii.getImageObserver());
    }

    public static void main(String[] args) {
        JFrame win = new JFrame("»æÍ¼»ù´¡");
        MyCanvas mc = new MyCanvas();

        win.add(mc);
        win.setSize(800,600);
        win.setVisible(true);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

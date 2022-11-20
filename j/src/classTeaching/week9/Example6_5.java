package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Example6_5 extends JFrame {
    public Example6_5() {

        setSize(180, 180);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Example6_5();
    }

    public void paint(Graphics g) {
        Graphics2D g_2d = (Graphics2D) g;
        Line2D line_1 = new Line2D.Double(50, 50, 120, 50);
        Line2D line_2 = new Line2D.Double(50, 80, 120, 80);
        Line2D line_3 = new Line2D.Double(50, 110, 120, 110);
        BasicStroke bs_1 = new BasicStroke(16, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
        BasicStroke bs_2 = new BasicStroke(16f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
        BasicStroke bs_3 = new BasicStroke(16f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        g_2d.setStroke(bs_1);
        g_2d.draw(line_1);
        g_2d.setStroke(bs_2);
        g_2d.draw(line_2);
        g_2d.setStroke(bs_3);
        g_2d.draw(line_3);
    }
}

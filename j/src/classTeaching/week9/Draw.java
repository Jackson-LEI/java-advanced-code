package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Draw extends JFrame {
    Graphics g;
    int x1, y1, x2, y2;

    public Draw() {
        this.setLocationRelativeTo(null);
        this.setSize(600, 400);
        this.setVisible(true);
        this.setTitle("×ÔÓÉ»­°å");
        g = this.getGraphics();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();

                g.drawLine(x1, y1, x2, y2);
                x1 = x2;
                y1 = y2;
            }
        });

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Draw win = new Draw();
        win.setLayout(null);
        JProgressBar j = new JProgressBar();
        j.setValue(51);
        j.setVisible(true);
        win.add(j);
        win.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

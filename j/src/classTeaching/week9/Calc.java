package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calc extends JFrame {
    public Calc() {
        this.setSize(300, 300);
        JTextField jt = new JTextField(this.getWidth());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                jt.setFont(new Font("consolas",Font.BOLD,Calc.this.getHeight()/10));
                Calc.this.validate();
            }
        });
        JPanel j = new JPanel(new BorderLayout());
//        jt.setPreferredSize(new Dimension (this.getWidth()/10,this.getHeight()/10));
        j.add(jt,BorderLayout.NORTH);
        JPanel button = new JPanel();
        button.setLayout(new GridLayout(6,4));
        String[] arr = {"a","a","a","a","a","a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a","a","a","a","a","a"};
        for(int i=0;i<arr.length;i++){
            button.add(new JButton(arr[i]));
        }
        j.add(button);
        this.add(j);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Calc c = new Calc();
    }
}

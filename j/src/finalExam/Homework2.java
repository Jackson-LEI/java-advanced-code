package finalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Homework2 extends JFrame {

    public Homework2(){
        JButton j = new JButton("Ð¡Ì©µÏ");
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ÍôÍô~ÍôÍô~~\n");
            }
        });
        this.add(j);
        this.setTitle("×÷Òµ");
        this.setLayout(new FlowLayout());
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Homework2();
    }
}

package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Win extends JFrame{

    public Win(){
        JButton j = new JButton("Ð¡Ì©µÏ");
        j.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.out.println("ÍôÍô~ÍôÍô~");
        }
		});
        this.setLayout(new FlowLayout());
        this.add(j);
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new Win();
    }
}

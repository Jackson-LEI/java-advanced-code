package classTeaching;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MySQLservices extends JFrame{
    static String serviceName = "MySQLServer";
    public MySQLservices(){
        this.setTitle("MySQL���������");
        JButton b1 = new JButton("����MySQL����");
        JLabel sName = new JLabel("����������:" + serviceName);
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Process p = Runtime.getRuntime().exec("sc start MySQLServer");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "����������!", "����MySQL����", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JButton b2 = new JButton("ֹͣMySQL����");
        b2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Process p = Runtime.getRuntime().exec("sc stop MySQLServer");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "������ֹͣ!", "ֹͣMySQL����", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JLabel jl = new JLabel("�����ť��������ر�MySQL����");
        JButton self = new JButton("�Զ��������");
        self.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String o = JOptionPane.showInputDialog("������MySQL������:",JOptionPane.OK_OPTION);

            }
        });
        JPanel j = new JPanel();
        j.add(jl, BorderLayout.CENTER);
        j.add(b1);
        j.add(b2);
        j.add(self, BorderLayout.PAGE_END);
        j.add(sName, BorderLayout.PAGE_END);
        this.add(j);
        this.setSize(300, 150);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MySQLservices win = new MySQLservices();
    }

}

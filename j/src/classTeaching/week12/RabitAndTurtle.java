package classTeaching.week12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RabitAndTurtle extends JFrame implements ActionListener {
    int rabbitX = 26, turtleX = 28; // ���������ߵ�λ��
    int rabbitSpeed = 40, turtleSpeed = 25; // ���������ߵ��ٶ�
    JLabel rabbit, turtle; // ��ɫ����
    Thread rabbitThread, turtleThread; // ��������ɫ�̶߳���
    JButton command = new JButton("������ʼ");
    Container container = this.getContentPane(); // ��������

    public RabitAndTurtle() {
        windowInit();// ����ĳ�ʼ��
        doRace(); // ��������
        command.addActionListener(this);// Ϊ���ťע�������
    }

    public void windowInit() { // ��ʼ������
        container.setLayout(null); // ʹ���岻ʹ���κβ��ֹ�����
        container.setBackground(Color.WHITE); // ���ñ���ɫ

        JLabel seprator1 = new JLabel(); // �����ָ���1
        seprator1.setOpaque(true);
        seprator1.setBackground(Color.GREEN);
        seprator1.setBounds(110, 100, 350, 10); // ���ñ�ǩ��λ�����С

        JLabel startLine = new JLabel(); // ������
        startLine.setOpaque(true);
        startLine.setBackground(Color.RED);
        startLine.setBounds(100, 0, 10, 350); // ���ñ�ǩ��λ�����С

        JLabel stopLine = new JLabel(); // ��ֹ��
        stopLine.setOpaque(true);
        stopLine.setBackground(Color.RED);
        stopLine.setBounds(460, 0, 10, 350); // ���ñ�ǩ��λ�����С

        rabbit = new JLabel(); // ����JLabel��������
        rabbit.setBounds(26, 10, 74, 75); // ���ñ�ǩ��λ�����С
        rabbit.setIcon(new ImageIcon(RabitAndTurtle.class.getResource("r1.gif"))); // ��ͼ������ڱ�ǩ��

        turtle = new JLabel(); // ����JLabel�����ڹ�1
        turtle.setBounds(28, 120, 72, 64); // ���ñ�ǩ��λ�����С
        turtle.setIcon(new ImageIcon(RabitAndTurtle.class.getResource("t1.gif")));

        command.setBounds(10, 230, 100, 30);

        // ������������������
        container.add(seprator1);
        container.add(startLine);
        container.add(stopLine);
        container.add(rabbit);
        container.add(turtle);
        container.add(command);
        setBounds(300, 200, 620, 320); // ���Զ�λ�����С��λ��
        setVisible(true); // ʹ����ɼ�
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// ���ô���Ĺرշ�ʽ
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("������ʼ")) {

            // �����߳�
            rabbitThread.start();
            turtleThread.start();
            command.setText("�����С�");
            command.setForeground(Color.RED);
        }
    }

    public void doRace() {
        rabbitThread = new Thread() {
            @Override
            public void run() {
                while (rabbitX < 490) {
                    rabbitX += rabbitSpeed;
                    rabbit.setBounds(rabbitX, 10, 74, 75);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                doEnd();
            }
        };

        turtleThread = new Thread() {
            @Override
            public void run() {
                while (turtleX < 490) {
                    turtleX += turtleSpeed;
                    turtle.setBounds(turtleX, 120, 72, 64);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                doEnd();
            }
        };
    }

    public void doEnd() {
        if(rabbitX>=490){
            JLabel j1 = new JLabel("1");
            j1.setFont(new Font("����",Font.BOLD,50));
            j1.setBounds(480, 10, 74, 75);
            this.add(j1);
        }
        if (rabbitX >= 490 && turtleX >= 490) {
            command.setText("��������");
            command.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new RabitAndTurtle();
    }
}

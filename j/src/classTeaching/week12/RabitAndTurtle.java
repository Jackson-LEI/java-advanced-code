package classTeaching.week12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RabitAndTurtle extends JFrame implements ActionListener {
    int rabbitX = 26, turtleX = 28; // 声明参赛者的位置
    int rabbitSpeed = 40, turtleSpeed = 25; // 声明参赛者的速度
    JLabel rabbit, turtle; // 角色界面
    Thread rabbitThread, turtleThread; // 声明各角色线程对象
    JButton command = new JButton("比赛开始");
    Container container = this.getContentPane(); // 声明容器

    public RabitAndTurtle() {
        windowInit();// 界面的初始化
        doRace(); // 比赛过程
        command.addActionListener(this);// 为命令按钮注册监听器
    }

    public void windowInit() { // 初始化界面
        container.setLayout(null); // 使窗体不使用任何布局管理器
        container.setBackground(Color.WHITE); // 设置背景色

        JLabel seprator1 = new JLabel(); // 赛道分割线1
        seprator1.setOpaque(true);
        seprator1.setBackground(Color.GREEN);
        seprator1.setBounds(110, 100, 350, 10); // 设置标签的位置与大小

        JLabel startLine = new JLabel(); // 起跑线
        startLine.setOpaque(true);
        startLine.setBackground(Color.RED);
        startLine.setBounds(100, 0, 10, 350); // 设置标签的位置与大小

        JLabel stopLine = new JLabel(); // 终止线
        stopLine.setOpaque(true);
        stopLine.setBackground(Color.RED);
        stopLine.setBounds(460, 0, 10, 350); // 设置标签的位置与大小

        rabbit = new JLabel(); // 声明JLabel对象，兔子
        rabbit.setBounds(26, 10, 74, 75); // 设置标签的位置与大小
        rabbit.setIcon(new ImageIcon(RabitAndTurtle.class.getResource("r1.gif"))); // 将图标放置在标签中

        turtle = new JLabel(); // 声明JLabel对象，乌龟1
        turtle.setBounds(28, 120, 72, 64); // 设置标签的位置与大小
        turtle.setIcon(new ImageIcon(RabitAndTurtle.class.getResource("t1.gif")));

        command.setBounds(10, 230, 100, 30);

        // 将各组件添加至容器中
        container.add(seprator1);
        container.add(startLine);
        container.add(stopLine);
        container.add(rabbit);
        container.add(turtle);
        container.add(command);
        setBounds(300, 200, 620, 320); // 绝对定位窗体大小与位置
        setVisible(true); // 使窗体可见
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置窗体的关闭方式
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("比赛开始")) {

            // 启动线程
            rabbitThread.start();
            turtleThread.start();
            command.setText("比赛中…");
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
            j1.setFont(new Font("宋体",Font.BOLD,50));
            j1.setBounds(480, 10, 74, 75);
            this.add(j1);
        }
        if (rabbitX >= 490 && turtleX >= 490) {
            command.setText("比赛结束");
            command.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new RabitAndTurtle();
    }
}

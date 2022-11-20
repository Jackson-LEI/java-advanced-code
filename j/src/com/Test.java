package com;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class Test extends JFrame {
    JTextField nametxt;
    JPasswordField passwordtxt;
    JButton registbt, exitbt;
    JTextArea resume;
    JCheckBox[] hobbybox;

    public Test() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.pink);
        nametxt = new JTextField(15);
        passwordtxt = new JPasswordField(15);
        //设置回显字符
        passwordtxt.setEchoChar('#');

        //标签
        JLabel la1 = new JLabel("姓名：");
        JLabel la2 = new JLabel("密码：");
        //将标签添加到面板上
        panel.add(la1);
        panel.add(nametxt);
        panel.add(la2);
        panel.add(passwordtxt);


        //JRadioButton(按钮）组件的使用
        panel.add(new JLabel("性别："));
        JRadioButton male = new JRadioButton("男", true);
        JRadioButton female = new JRadioButton("女");
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        panel.add(male);
        panel.add(female);


        //JComboBox(组合框)组件的使用
        JComboBox<Integer> years = new JComboBox<>();
        for (int y = 1900; y < Calendar.getInstance().get(Calendar.YEAR); y++) {
            years.addItem(y);
        }
        years.setSelectedIndex(2000);
        panel.add(new JLabel("出生年月："));
        panel.add(years);


        //JCheckBox(多选按钮)组件的使用
        panel.add(new JLabel("爱好："));
        String[] hobbystr = {"逛街", "旅游", "运动", "看书", "上网"};
        hobbybox = new JCheckBox[hobbystr.length];
        //利用for循环补充内容
        for (int i = 0; i < hobbystr.length; i++) {
            hobbybox[i] = new JCheckBox(hobbystr[i]);
            panel.add(hobbybox[i]);
        }


        //JTextArea(文本域)组件的使用   设置简介，并设有滑动条
        JTextArea resume = new JTextArea();
        JScrollPane jp = new JScrollPane(resume);//设置滚动条
        jp.setPreferredSize(new Dimension(160, 80));
        resume.setFont(new Font("方正幼圆", Font.PLAIN, 24));//设置字体
        resume.setLineWrap(true);//设置自动换行
        resume.setWrapStyleWord(true);//设置换行不断字
        panel.add(new JLabel("个人简介："));
        panel.add(jp);


        //JList(列表)组件的使用
        String[] edus = {"高中", "高职", "博士", "硕士", "本科", "专科"};
        JList edulist = new JList(edus);
        edulist.setSelectedIndex(3);
        JScrollPane jp1 = new JScrollPane(edulist);
        jp1.setPreferredSize(new Dimension(80, 80));
        panel.add(new JLabel("学历："));
        panel.add(jp1);


        registbt = new JButton("注册");
        exitbt = new JButton("退出");
        panel.add(registbt);
        panel.add(exitbt);
    }


    public static void main(String[] args) {
        //创建窗口
        JFrame win = new JFrame();
        //创建窗口标题栏标题
        win.setTitle("会员信息采集");
        //设置窗口大小为800*800
        win.setSize(800, 800);
        //为窗体设置图标
        ImageIcon iconD = new ImageIcon("/myjava/src/Img/1650533866(1).png");
        //设置窗体居中
        win.setLocationRelativeTo(null);
        //设置窗体可见性
        win.setVisible(true);
        //设置关闭窗口退出程序
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
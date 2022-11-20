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
        //���û����ַ�
        passwordtxt.setEchoChar('#');

        //��ǩ
        JLabel la1 = new JLabel("������");
        JLabel la2 = new JLabel("���룺");
        //����ǩ��ӵ������
        panel.add(la1);
        panel.add(nametxt);
        panel.add(la2);
        panel.add(passwordtxt);


        //JRadioButton(��ť�������ʹ��
        panel.add(new JLabel("�Ա�"));
        JRadioButton male = new JRadioButton("��", true);
        JRadioButton female = new JRadioButton("Ů");
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        panel.add(male);
        panel.add(female);


        //JComboBox(��Ͽ�)�����ʹ��
        JComboBox<Integer> years = new JComboBox<>();
        for (int y = 1900; y < Calendar.getInstance().get(Calendar.YEAR); y++) {
            years.addItem(y);
        }
        years.setSelectedIndex(2000);
        panel.add(new JLabel("�������£�"));
        panel.add(years);


        //JCheckBox(��ѡ��ť)�����ʹ��
        panel.add(new JLabel("���ã�"));
        String[] hobbystr = {"���", "����", "�˶�", "����", "����"};
        hobbybox = new JCheckBox[hobbystr.length];
        //����forѭ����������
        for (int i = 0; i < hobbystr.length; i++) {
            hobbybox[i] = new JCheckBox(hobbystr[i]);
            panel.add(hobbybox[i]);
        }


        //JTextArea(�ı���)�����ʹ��   ���ü�飬�����л�����
        JTextArea resume = new JTextArea();
        JScrollPane jp = new JScrollPane(resume);//���ù�����
        jp.setPreferredSize(new Dimension(160, 80));
        resume.setFont(new Font("������Բ", Font.PLAIN, 24));//��������
        resume.setLineWrap(true);//�����Զ�����
        resume.setWrapStyleWord(true);//���û��в�����
        panel.add(new JLabel("���˼�飺"));
        panel.add(jp);


        //JList(�б�)�����ʹ��
        String[] edus = {"����", "��ְ", "��ʿ", "˶ʿ", "����", "ר��"};
        JList edulist = new JList(edus);
        edulist.setSelectedIndex(3);
        JScrollPane jp1 = new JScrollPane(edulist);
        jp1.setPreferredSize(new Dimension(80, 80));
        panel.add(new JLabel("ѧ����"));
        panel.add(jp1);


        registbt = new JButton("ע��");
        exitbt = new JButton("�˳�");
        panel.add(registbt);
        panel.add(exitbt);
    }


    public static void main(String[] args) {
        //��������
        JFrame win = new JFrame();
        //�������ڱ���������
        win.setTitle("��Ա��Ϣ�ɼ�");
        //���ô��ڴ�СΪ800*800
        win.setSize(800, 800);
        //Ϊ��������ͼ��
        ImageIcon iconD = new ImageIcon("/myjava/src/Img/1650533866(1).png");
        //���ô������
        win.setLocationRelativeTo(null);
        //���ô���ɼ���
        win.setVisible(true);
        //���ùرմ����˳�����
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
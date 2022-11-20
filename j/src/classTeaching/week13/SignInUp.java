package classTeaching.week13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Calendar;

/**
 * @author Kim Jackon(JinLei)
 */
public class SignInUp extends JFrame {
    JTextField jt;
    JPasswordField jpf;
    JRadioButton male, female;
    ButtonGroup bg;
    JComboBox<Integer> years, months;
    JCheckBox[] jb;
    JTextArea jta;
    JScrollPane jsp;
    JList<String> list;
    JScrollPane jspList;
    JButton signIn, find, exit;
    ResultSet rs;
    String findName;
    MyDB db = new MyDB();

    public SignInUp() {
        findName = JOptionPane.showInputDialog(null, "请输入要查询的用户名：");
        String sqlCheckNull = "select * from member where name = '" + findName + "';";
        rs = db.doQuery(sqlCheckNull);
        try {
            if(rs.next()){
                showResult();
            }else{
                JOptionPane.showMessageDialog(null,"该用户未注册！","错误",JOptionPane.ERROR_MESSAGE);
                new SignInUp();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showResult() {
        JPanel j = new JPanel();
        j.add(new JLabel("姓名："));
        jt = new JTextField(12);
        try {
            jt.setText((String)rs.getObject("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        j.add(jt);

        j.add(new JLabel("密码："));
        jpf = new JPasswordField(12);
        jpf.setEchoChar('*');
        j.add(jpf);

        j.add(new JLabel("性别："));
        male = new JRadioButton("男", true);
        female = new JRadioButton("女");
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        j.add(male);
        j.add(female);

        j.add(new JLabel("出生年月："));
        years = new JComboBox<>();
        for (int y = 2000; y <= Calendar.getInstance().get(Calendar.YEAR); y++) {
            years.addItem(y);
        }
        j.add(years);
        j.add(new JLabel("年"));
        months = new JComboBox<>();
        for (int m = 1; m <= 12; m++) {
            months.addItem(m);
        }
        j.add(months);
        j.add(new JLabel("月"));

        j.add(new JLabel("爱好"));
        String[] hobby = {"学Java", "旅游", "运动", "看书", "学英语"};
        jb = new JCheckBox[hobby.length];
        for (int i = 0; i < hobby.length; i++) {
            jb[i] = new JCheckBox(hobby[i]);
            j.add(jb[i]);
        }

        j.add(new JLabel("简介"));
        jta = new JTextArea(6, 15);
        jta.setText("请输入你的简介");
        jta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (jta.getText().equals("")) {
                    jta.setText("请输入你的简介");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (jta.getText().equals("请输入你的简介")) {
                    jta.setText("");
                }
            }
        });
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jsp = new JScrollPane(jta);
        j.add(jsp);

        j.add(new JLabel("学历"));
        String[] edu = {"小学", "初中", "中专", "高中", "专科", "本科", "研究生"};
        list = new JList<>(edu);
        jspList = new JScrollPane(list);
        jspList.setPreferredSize(new Dimension(70, 110));
        j.add(jspList);

        signIn = new JButton("查找");
        j.add(signIn);
        exit = new JButton("退出");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "确实要退出么？", "确认", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    System.exit(0);
                }
            }
        });
        j.add(exit);

        this.add(j);
        this.setTitle("系统注册(金雨田版)");
        this.setIconImage(new ImageIcon("D:\\icon.jpg").getImage());
        this.setSize(370, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SignInUp sip = new SignInUp();
    }
}

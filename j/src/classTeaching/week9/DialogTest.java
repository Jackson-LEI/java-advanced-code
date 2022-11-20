package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * 这是{@code JFrame}、{@code JButton}、{@code JTextField}、{@code JPasswordField}、{@code JTextArea}、{@code JCheckBox}、
 * {@code JRadioButton}、{@code JList}、{@code JComboBox}的测试类
 * @author Kim Jackon(JinLei)
 */
public class DialogTest extends JFrame {

    JButton loginButton, exitButton;
    JTextField nametext;
    JPasswordField passwordtext;
    JTextArea resume;
    JCheckBox[] hobby;
    JRadioButton radmale, radfemale;
    JList<String> list;
    JComboBox<Integer> years;
    public DialogTest(){
        JPanel j = new JPanel();
//        j.setBackground(Color.cyan);
        nametext = new JTextField(20);
        passwordtext = new JPasswordField(20);
        passwordtext.setEchoChar('*');
        loginButton = new JButton("登录");
        exitButton = new JButton("退出");
        JLabel l1 = new JLabel("用户名：");
        JLabel l2 = new JLabel("密    码：");
        j.add(l1);
        j.add(nametext);
        j.add(l2);
        j.add(passwordtext);
        j.add(loginButton);
        j.add(exitButton);
//        resume = new JTextArea(3,8);
//        j.add(new JLabel("个人简介："));
        j.add(new Label("学历"));
        String[] edus = {"小学","初中","中专","高中","专科","本科","研究生"};
        list = new JList<>(edus);
        list.setSelectedIndex(0);
        j.add(list);

        l1.setFont(new Font("微软雅黑",Font.PLAIN,12));
//        l1.setOpaque(true);
//        l1.setBackground(Color.lightGray);

        l2.setFont(new Font("微软雅黑",Font.PLAIN,12));
        JScrollPane sp1 = new JScrollPane(resume);
        sp1.setPreferredSize(new Dimension(160,80));
        j.add(sp1);

        j.add(new Label("性别"));
        radmale = new JRadioButton("男",true);
        radfemale = new JRadioButton("女");
        j.add(radmale);
        j.add(radfemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radmale);
        bg.add(radfemale);

        years = new JComboBox<>();
        for(int y=1900;y<=Calendar.getInstance().get(Calendar.YEAR);y++){
            years.addItem(y);
        }
        j.add(new Label("出生年月"));
        j.add(years);

        j.add(new Label("爱好"));
        String[] hobbyString = {"编程","学英语"};
        hobby = new JCheckBox[hobbyString.length];
        for(int i=0;i<hobbyString.length;i++){
            hobby[i] = new JCheckBox(hobbyString[i]);
            j.add(hobby[i]);
        }

        this.add(j);
        this.setTitle("系统登录");
        this.setSize(400,200);
        this.setVisible(true);
//        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        DialogTest d = new DialogTest();
//        JOptionPane.showMessageDialog(null,"今天上课","友情提示",JOptionPane.INFORMATION_MESSAGE);
//        int choic = JOptionPane.showConfirmDialog(null,"今天迟到了么？","确认",JOptionPane.YES_NO_OPTION);
//        String name = JOptionPane.showInputDialog(null,"请输入XXX");
//        if(choic == JOptionPane.YES_NO_OPTION){
//            JOptionPane.showMessageDialog(null, "下次别迟到了！");
//        }
    }
}

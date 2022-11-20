package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 类LoginGUI模拟了登录界面与其过程
 * @author Kim Jackon(JinLei)
 */
public class LoginGUI extends JFrame {
    JTextField nametxt;
    JPasswordField passwordtxt;
    JButton registbt, exitbt;

    public LoginGUI() {
        JPanel panel = new JPanel();
        nametxt = new JTextField(20);
        passwordtxt = new JPasswordField(20);
        passwordtxt.setEchoChar('*');//设置回显字符
        JLabel la1 = new JLabel("用户名:");
        la1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        JLabel la2 = new JLabel("密    码:");
        la2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        panel.add(la1);
        panel.add(nametxt);
        panel.add(la2);
        panel.add(passwordtxt);

        registbt = new JButton("登录");
        exitbt = new JButton("退出");
        exitbt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(null,"确实要退出吗？","确认",JOptionPane.YES_NO_OPTION);
                if(option==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        registbt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                check();
            }
        });

        panel.add(registbt);
        panel.add(exitbt);

        this.add(panel);
        this.setTitle("系统登录");
        this.setSize(300, 140);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void check() {
        String password = new String(passwordtxt.getPassword());
        if (nametxt.getText().equals("jinlei") && password.equals("102030")) {
            JOptionPane.showMessageDialog(null, "登录成功！", "信息", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误，请重新输入！", "错误", JOptionPane.ERROR_MESSAGE);
            nametxt.setText("");
            passwordtxt.setText("");
        }
    }

    public static void main(String[] args) {
        LoginGUI lg = new LoginGUI();
    }
}

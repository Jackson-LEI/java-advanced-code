package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * ��LoginGUIģ���˵�¼�����������
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
        passwordtxt.setEchoChar('*');//���û����ַ�
        JLabel la1 = new JLabel("�û���:");
        la1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        JLabel la2 = new JLabel("��    ��:");
        la2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        panel.add(la1);
        panel.add(nametxt);
        panel.add(la2);
        panel.add(passwordtxt);

        registbt = new JButton("��¼");
        exitbt = new JButton("�˳�");
        exitbt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(null,"ȷʵҪ�˳���","ȷ��",JOptionPane.YES_NO_OPTION);
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
        this.setTitle("ϵͳ��¼");
        this.setSize(300, 140);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void check() {
        String password = new String(passwordtxt.getPassword());
        if (nametxt.getText().equals("jinlei") && password.equals("102030")) {
            JOptionPane.showMessageDialog(null, "��¼�ɹ���", "��Ϣ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "�û���������������������룡", "����", JOptionPane.ERROR_MESSAGE);
            nametxt.setText("");
            passwordtxt.setText("");
        }
    }

    public static void main(String[] args) {
        LoginGUI lg = new LoginGUI();
    }
}

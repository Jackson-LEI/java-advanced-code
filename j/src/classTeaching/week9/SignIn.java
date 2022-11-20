package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

/**
 * @author Kim Jackon(JinLei)
 */
public class SignIn extends JFrame {
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
    JButton signIn, exit;

    public SignIn() {
        JPanel j = new JPanel();
        j.add(new JLabel("������"));
        jt = new JTextField(12);
        j.add(jt);

        j.add(new JLabel("���룺"));
        jpf = new JPasswordField(12);
        jpf.setEchoChar('*');
        j.add(jpf);

        j.add(new JLabel("�Ա�"));
        male = new JRadioButton("��", true);
        female = new JRadioButton("Ů");
        bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        j.add(male);
        j.add(female);

        j.add(new JLabel("�������£�"));
        years = new JComboBox<>();
        for (int y = 2000; y <= Calendar.getInstance().get(Calendar.YEAR); y++) {
            years.addItem(y);
        }
        j.add(years);
        j.add(new JLabel("��"));
        months = new JComboBox<>();
        for (int m = 1; m <= 12; m++) {
            months.addItem(m);
        }
        j.add(months);
        j.add(new JLabel("��"));

        j.add(new JLabel("����"));
        String[] hobby = {"ѧJava", "����", "�˶�", "����", "ѧӢ��"};
        jb = new JCheckBox[hobby.length];
        for (int i = 0; i < hobby.length; i++) {
            jb[i] = new JCheckBox(hobby[i]);
            j.add(jb[i]);
        }

        j.add(new JLabel("���"));
        jta = new JTextArea(6, 15);
        jta.setText("��������ļ��");
        jta.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(jta.getText().equals("")){
                    jta.setText("��������ļ��");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if(jta.getText().equals("��������ļ��")){
                    jta.setText("");
                }
            }
        });
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jsp = new JScrollPane(jta);
        j.add(jsp);

        j.add(new JLabel("ѧ��"));
        String[] edu = {"Сѧ", "����", "��ר", "����", "ר��", "����", "�о���"};
        list = new JList<>(edu);
        jspList = new JScrollPane(list);
        jspList.setPreferredSize(new Dimension(70, 110));
        j.add(jspList);

        signIn = new JButton("ע��");
        signIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                inforDialog();
            }
        });
        j.add(signIn);
        exit = new JButton("�˳�");
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "ȷʵҪ�˳�ô��", "ȷ��", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    System.exit(0);
                }
            }
        });
        j.add(exit);

        this.add(j);
        this.setTitle("ϵͳע��(�������)");
        this.setIconImage(new ImageIcon("D:\\icon.jpg").getImage());
        this.setSize(370, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void inforDialog() {
        JDialog jd = new JDialog();
        JTextArea jta = new JTextArea();
        jta.setEditable(false);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        JScrollPane jsp = new JScrollPane(jta);
        jsp.setPreferredSize(new Dimension(250, 350));

        jta.append("���������Ϣ�ǣ�\n");
        jta.append("����������" + jt.getText() + "\n");
        String password = new String(jpf.getPassword());
        jta.append("�������룺" + password + "\n");
        if (male.isSelected()) {
            jta.append("�����Ա���\n");
        } else {
            jta.append("�����Ա�Ů\n");
        }
        jta.append("���ĳ������£�" + years.getSelectedItem() + "��" + months.getSelectedItem() + "��\n");
        jta.append("����ѧ����" + list.getSelectedValue() + "\n");
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < jb.length; i++) {
            if (jb[i].isSelected()) {
                bf.append(jb[i].getText()).append(" ");
            }
        }
        String hobby = String.join("��", new String(bf).split(" "));
        jta.append("���İ��ã�" + hobby + "\n");
        jta.append("���ļ�飺" + this.jta.getText());

        jd.add(jsp);
        jd.setTitle("ע����Ϣ");
        jd.setVisible(true);
        jd.setSize(250, 350);
        jd.setLocation(this.getX() + this.getWidth(), this.getY());
        jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args){
        SignIn si = new SignIn();
    }
}

package classTeaching.week9;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 * ����{@code JFrame}��{@code JButton}��{@code JTextField}��{@code JPasswordField}��{@code JTextArea}��{@code JCheckBox}��
 * {@code JRadioButton}��{@code JList}��{@code JComboBox}�Ĳ�����
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
        loginButton = new JButton("��¼");
        exitButton = new JButton("�˳�");
        JLabel l1 = new JLabel("�û�����");
        JLabel l2 = new JLabel("��    �룺");
        j.add(l1);
        j.add(nametext);
        j.add(l2);
        j.add(passwordtext);
        j.add(loginButton);
        j.add(exitButton);
//        resume = new JTextArea(3,8);
//        j.add(new JLabel("���˼�飺"));
        j.add(new Label("ѧ��"));
        String[] edus = {"Сѧ","����","��ר","����","ר��","����","�о���"};
        list = new JList<>(edus);
        list.setSelectedIndex(0);
        j.add(list);

        l1.setFont(new Font("΢���ź�",Font.PLAIN,12));
//        l1.setOpaque(true);
//        l1.setBackground(Color.lightGray);

        l2.setFont(new Font("΢���ź�",Font.PLAIN,12));
        JScrollPane sp1 = new JScrollPane(resume);
        sp1.setPreferredSize(new Dimension(160,80));
        j.add(sp1);

        j.add(new Label("�Ա�"));
        radmale = new JRadioButton("��",true);
        radfemale = new JRadioButton("Ů");
        j.add(radmale);
        j.add(radfemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radmale);
        bg.add(radfemale);

        years = new JComboBox<>();
        for(int y=1900;y<=Calendar.getInstance().get(Calendar.YEAR);y++){
            years.addItem(y);
        }
        j.add(new Label("��������"));
        j.add(years);

        j.add(new Label("����"));
        String[] hobbyString = {"���","ѧӢ��"};
        hobby = new JCheckBox[hobbyString.length];
        for(int i=0;i<hobbyString.length;i++){
            hobby[i] = new JCheckBox(hobbyString[i]);
            j.add(hobby[i]);
        }

        this.add(j);
        this.setTitle("ϵͳ��¼");
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
//        JOptionPane.showMessageDialog(null,"�����Ͽ�","������ʾ",JOptionPane.INFORMATION_MESSAGE);
//        int choic = JOptionPane.showConfirmDialog(null,"����ٵ���ô��","ȷ��",JOptionPane.YES_NO_OPTION);
//        String name = JOptionPane.showInputDialog(null,"������XXX");
//        if(choic == JOptionPane.YES_NO_OPTION){
//            JOptionPane.showMessageDialog(null, "�´α�ٵ��ˣ�");
//        }
    }
}

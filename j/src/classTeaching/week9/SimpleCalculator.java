package classTeaching.week9;

import javax.swing.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ʵ���˴�������ܵļ򵥼�������{@code SimpleCalculator}
 * @author Kim Jackson(JinLei)
 */
public class SimpleCalculator extends JFrame {

    JTextField jtf1;
    JTextField jtf2;
    JTextField ans;
    JButton plus, minus, multiply, divid;
    String[] formatValue;
    public SimpleCalculator() {//�������ڶ��󲢽������ӵ������С�Ϊ��ťע��������������������
        this.setSize(250, 200);
        JPanel j = new JPanel();
        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divid = new JButton("/");
        JPanel button = new JPanel();
        button.add(plus);
        button.add(minus);
        button.add(multiply);
        button.add(divid);
        j.add(button);

        JPanel input1 = new JPanel();
        input1.add(new JLabel("������:"));
        jtf1 = new JTextField(12);
        input1.add(jtf1);
        j.add(input1);

        JPanel input2 = new JPanel();
        input2.add(new JLabel("������:"));
        jtf2 = new JTextField(12);
        input2.add(jtf2);
        j.add(input2);

        JPanel result = new JPanel();
        result.add(new JLabel("��    ��:"));
        ans = new JTextField(12);
        ans.setEditable(false);
        result.add(ans);
        j.add(result);

        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formatValue = format(jtf1.getText(), jtf2.getText());
                ans.setText(plus());
            }
        });

        minus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                formatValue = format(jtf1.getText(), jtf2.getText());
                ans.setText(minus());
            }
        });

        multiply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                formatValue = format(jtf1.getText(), jtf2.getText());
                ans.setText(multiply());
            }
        });

        divid.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                formatValue = format(jtf1.getText(), jtf2.getText());
                ans.setText(divid());
            }
        });

        this.add(j);
        this.setTitle("���׼�����");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //ʹ����BigInteger�������м��������߾���
    //����
    private String divid() {
        if (!(checkEmpty())) {//���������Ƿ�Ϊ��
            if(checkValid()){//���������Ƿ�Ϸ�
                try {
                    return String.valueOf(new BigDecimal(formatValue[0])
                            .divide(new BigDecimal(formatValue[1]), 15, RoundingMode.DOWN).stripTrailingZeros());
                } catch (ArithmeticException a) {
                    return "��������Ϊ0";
                }
            }else{
                return "�������д��ڷǷ��ַ�";
            }
        } else {
            return "�������д��ڿ�ֵ";
        }
    }
    //�˷�
    private String multiply() {
        if (!(checkEmpty())) {
            if(checkValid()){
                return String.valueOf(new BigDecimal(formatValue[0]).multiply(new BigDecimal(formatValue[1])).stripTrailingZeros());
            }else{
                return "�������д��ڷǷ��ַ�";
            }
        } else {
            return "�������д��ڿ�ֵ";
        }
    }
    //���
    private String minus() {
        if (!(checkEmpty())) {
            if(checkValid()){
                return String.valueOf(new BigDecimal(formatValue[0]).subtract(new BigDecimal(formatValue[1]).stripTrailingZeros()));
            }else{
                return "�������д��ڷǷ��ַ�";
            }
        } else {
            return "�������д��ڿ�ֵ";
        }
    }
    //���
    private String plus() {
        if (!(checkEmpty())) {
            if(checkValid()){
                return String.valueOf(new BigDecimal(formatValue[0]).add(new BigDecimal(formatValue[1]).stripTrailingZeros()));
            }else{
                return "�������д��ڷǷ��ַ�";
            }
        }else {
            return "�������д��ڿ�ֵ";
        }
    }
    //�������������JTextField�Ƿ�Ϊ��
    private boolean checkEmpty() {
        return jtf1.getText().isBlank() || jtf2.getText().isBlank();
    }

    //��������������Ƿ���ڷǷ��ַ�
    private boolean checkValid() {
        int count = 0;
        //����������������С����ĸ���
        for(int i=0;i<jtf1.getText().length();i++){
            if(jtf1.getText().charAt(i)=='.'){
                count++;
            }
        }
        for(int i=0;i<jtf2.getText().length();i++){
            if(jtf2.getText().charAt(i)=='.'){
                count++;
            }
        }
        for(int i=0;i<jtf1.getText().length();i++){
            //ֻҪ��һ���ַ��������֣���С�����������2�����ж����Ϸ�
            if(!(Character.isDigit(jtf1.getText().charAt(i)))){
                if(jtf1.getText().charAt(i)=='.'){
                    return false;
                }else{
                    if(count>2){
                        return false;
                    }
                }
            }
        }
        for(int i=0;i<jtf2.getText().length();i++){
            if(!(Character.isDigit(jtf2.getText().charAt(i)))){
                if(jtf2.getText().charAt(i)=='.'){
                    return false;
                }else{
                    if(count>2){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     * �����Ա����ʵ�������¹��ܣ�
     * <ul>
     *    <li><p>�������������ж����л�����һ������С����ʱ���ж���С�����������Ƿ������壬������Ļ���ɾ��.���磺3.0+2������ʽ��
     *   ��Ӧ�����5��������5.0��������7.0+6.0������ʽ��֮��Ӧ�����13��������13.0.</p></li>
     *    <li><p>������ֻ��С���㵫����û�����ֵ�����������Զ���С����ɾ����</p></li>
     *    <li><p>�����������������ֱ����С���㿪ʼ�����Զ����������ֲ�0.</p></li>
     * </ul>
     * @return һ���ַ������飬������ʽ��������ְ�˳������
     */
    private String[] format(String jtf1, String jtf2) {
        String[] arr = new String[2];
        if (jtf1.contains(".") || jtf2.contains(".")) {
            if(jtf1.endsWith(".") || jtf2.endsWith(".")){//��������С���㣬����û�м�������С�����ֵ�����ʱ����С����ɾ��
                arr[0] = jtf1.substring(0, jtf1.indexOf("."));
                arr[1] = jtf1.substring(0, jtf1.indexOf("."));
                return arr;
            }
            int decimalPart1 = Integer.parseInt(jtf1.substring(jtf1.indexOf(".") + 1));
            int decimalPart2 = Integer.parseInt(jtf2.substring(jtf2.indexOf(".") + 1));
            if (jtf1.contains(".") && jtf2.contains(".")) {
                if(decimalPart1 == 0 && decimalPart2 == 0){//��������С��������������С�����ֶ�û�����壬������ǿ��ת��������
                    arr[0] = String.valueOf((int) Double.parseDouble(jtf1));
                    arr[1] = String.valueOf((int) Double.parseDouble(jtf2));
                }else{
                    arr[0] = jtf1;
                    arr[1] = jtf2;
                }
                return arr;
            }
            if (jtf1.contains(".")) {//��������1��С���㣬�ж���С��������û�����壬������ֱ�ӷ��أ�����ǿ��ת��������
                arr[1] = jtf2;
                if (decimalPart1 == 0) {
                    arr[0] = String.valueOf((int) Double.parseDouble(jtf1));
                } else {
                    arr[0] = jtf1;
                }
            }

            if (jtf2.contains(".")) {//ͬ��
                arr[0] = jtf1;
                if (decimalPart2 == 0) {
                    arr[1] = String.valueOf((int) Double.parseDouble(jtf2));
                } else {
                    arr[1] = jtf2;
                }
            }
        }else{//�����������С���㣬ֱ�ӷ���
            arr[0] = jtf1;
            arr[1] = jtf2;
        }
        return arr;
    }

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
    }
}

package classTeaching.week9;

import javax.swing.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 实现了大多数功能的简单计算器类{@code SimpleCalculator}
 * @author Kim Jackson(JinLei)
 */
public class SimpleCalculator extends JFrame {

    JTextField jtf1;
    JTextField jtf2;
    JTextField ans;
    JButton plus, minus, multiply, divid;
    String[] formatValue;
    public SimpleCalculator() {//创建窗口对象并将组件添加到窗口中、为按钮注册监听器，最后启动窗口
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
        input1.add(new JLabel("操作数:"));
        jtf1 = new JTextField(12);
        input1.add(jtf1);
        j.add(input1);

        JPanel input2 = new JPanel();
        input2.add(new JLabel("操作数:"));
        jtf2 = new JTextField(12);
        input2.add(jtf2);
        j.add(input2);

        JPanel result = new JPanel();
        result.add(new JLabel("结    果:"));
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
        this.setTitle("简易计算器");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //使用了BigInteger类对象进行计算可以提高精度
    //除法
    private String divid() {
        if (!(checkEmpty())) {//检查操作数是否为空
            if(checkValid()){//检查操作数是否合法
                try {
                    return String.valueOf(new BigDecimal(formatValue[0])
                            .divide(new BigDecimal(formatValue[1]), 15, RoundingMode.DOWN).stripTrailingZeros());
                } catch (ArithmeticException a) {
                    return "除数不能为0";
                }
            }else{
                return "操作数中存在非法字符";
            }
        } else {
            return "操作数中存在空值";
        }
    }
    //乘法
    private String multiply() {
        if (!(checkEmpty())) {
            if(checkValid()){
                return String.valueOf(new BigDecimal(formatValue[0]).multiply(new BigDecimal(formatValue[1])).stripTrailingZeros());
            }else{
                return "操作数中存在非法字符";
            }
        } else {
            return "操作数中存在空值";
        }
    }
    //相减
    private String minus() {
        if (!(checkEmpty())) {
            if(checkValid()){
                return String.valueOf(new BigDecimal(formatValue[0]).subtract(new BigDecimal(formatValue[1]).stripTrailingZeros()));
            }else{
                return "操作数中存在非法字符";
            }
        } else {
            return "操作数中存在空值";
        }
    }
    //相加
    private String plus() {
        if (!(checkEmpty())) {
            if(checkValid()){
                return String.valueOf(new BigDecimal(formatValue[0]).add(new BigDecimal(formatValue[1]).stripTrailingZeros()));
            }else{
                return "操作数中存在非法字符";
            }
        }else {
            return "操作数中存在空值";
        }
    }
    //检查两个操作数JTextField是否为空
    private boolean checkEmpty() {
        return jtf1.getText().isBlank() || jtf2.getText().isBlank();
    }

    //检查两个操作数是否存在非法字符
    private boolean checkValid() {
        int count = 0;
        //计算两个操作数中小数点的个数
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
            //只要有一个字符不是数字，或小数点个数大于2，就判定不合法
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
     * 这个成员方法实现了以下功能：
     * <ul>
     *    <li><p>当两个操作数中都含有或其中一个含有小数点时，判断其小数点后的数字是否有意义，无意义的话则删除.例如：3.0+2经过格式化
     *   后应该输出5，而不是5.0。再例如7.0+6.0经过格式化之后应该输出13，而不是13.0.</p></li>
     *    <li><p>当出现只有小数点但后面没有数字的情况，将会自动将小数点删除。</p></li>
     *    <li><p>如果不输入整数部分直接以小数点开始，将自动在整数部分补0.</p></li>
     * </ul>
     * @return 一个字符串数组，两个格式化后的数字按顺序排列
     */
    private String[] format(String jtf1, String jtf2) {
        String[] arr = new String[2];
        if (jtf1.contains(".") || jtf2.contains(".")) {
            if(jtf1.endsWith(".") || jtf2.endsWith(".")){//当输入了小数点，但并没有继续输入小数部分的数字时，将小数点删除
                arr[0] = jtf1.substring(0, jtf1.indexOf("."));
                arr[1] = jtf1.substring(0, jtf1.indexOf("."));
                return arr;
            }
            int decimalPart1 = Integer.parseInt(jtf1.substring(jtf1.indexOf(".") + 1));
            int decimalPart2 = Integer.parseInt(jtf2.substring(jtf2.indexOf(".") + 1));
            if (jtf1.contains(".") && jtf2.contains(".")) {
                if(decimalPart1 == 0 && decimalPart2 == 0){//当输入了小数点且两个数的小数部分都没有意义，将数字强制转换成整数
                    arr[0] = String.valueOf((int) Double.parseDouble(jtf1));
                    arr[1] = String.valueOf((int) Double.parseDouble(jtf2));
                }else{
                    arr[0] = jtf1;
                    arr[1] = jtf2;
                }
                return arr;
            }
            if (jtf1.contains(".")) {//当操作数1有小数点，判断其小数部分有没有意义，有意义直接返回，否则强制转换成整数
                arr[1] = jtf2;
                if (decimalPart1 == 0) {
                    arr[0] = String.valueOf((int) Double.parseDouble(jtf1));
                } else {
                    arr[0] = jtf1;
                }
            }

            if (jtf2.contains(".")) {//同上
                arr[0] = jtf1;
                if (decimalPart2 == 0) {
                    arr[1] = String.valueOf((int) Double.parseDouble(jtf2));
                } else {
                    arr[1] = jtf2;
                }
            }
        }else{//如果都不包含小数点，直接返回
            arr[0] = jtf1;
            arr[1] = jtf2;
        }
        return arr;
    }

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
    }
}

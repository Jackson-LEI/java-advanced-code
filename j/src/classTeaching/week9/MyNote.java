package classTeaching.week9;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 记事本应用程序类 {@code MyNote}
 * @author Kim Jackson (JinLei)
 */
@SuppressWarnings("all")
public class MyNote extends JFrame implements ActionListener {
    JTextArea txt;//主窗口文本域
    JMenuItem newFile, openFile, saveFile, saveOtherFile, exitMenu, drawBack, cut, copy, paste, delete,
            find, replace, allSelect, date, font, bigger, smaller, resDefault, help, about;//所有菜单项
    JCheckBoxMenuItem wrapLine, siuBar;//自动换行和状态栏
    JMenu magnify;//带有二级菜单
    JScrollPane sp;//实现滚动
    JLabel sitbarLable;//状态栏
    boolean isSaved = true;//判断文件是否处于保存状态
    boolean openIsSeleced = false;//判断文件选择窗口是否已经打开了已经保存的文件
    JFileChooser open;//打开文件窗口
    JFileChooser save = new JFileChooser();//保存文件窗口
    UndoManager um;//撤销管理器
    JDialog findDialog = new JDialog(this, "查找", false);//“查找”窗口
    JDialog replaceDialog = new JDialog(this, "替换", false);//“替换”窗口
    JDialog fontSettingDialog;//字体设置窗口
    JTextField findString1, findString2, replaceString;//“查找”和“替换”窗口中的文本框
    JButton findNext1, findNext2, replaceNext, replaceAll, fontChange, fontCancel, cancel1, cancel2;//“查找”和“替换”窗口中的按钮
    JComboBox<String> fontName, fontStyle;//字体名称和字体样式选择框
    JComboBox<Integer> fontSize;//字体大小选择框

    public MyNote() {//初始化窗口、菜单、JTextArea对象，添加并注册窗口和JTextField的监听器
        JMenuBar mb = new JMenuBar();
        makeMenu(mb);
        this.setJMenuBar(mb);
        sitbarLable = new JLabel("准备就绪");
        sitbarLable.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        sitbarLable.setHorizontalAlignment(SwingConstants.RIGHT);
        txt = new JTextArea();
        txt.setFont(new Font("宋体", Font.PLAIN, 22));
        txt.setWrapStyleWord(true);
        txt.getDocument().addDocumentListener(new CheckChanged());
        txt.addFocusListener(new CheckMenuAvalible());
        um = new UndoManager();
        txt.getDocument().addUndoableEditListener(new Drawback());
        sp = new JScrollPane(txt);
        this.addWindowListener(new WindowAdapter() {//如果编辑框中有内容，防止其直接关闭
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        this.setIconImage(new ImageIcon(MyNote.class.getResource("icon.png")).getImage());
        this.setLayout(new BorderLayout(5, 5));
        this.add(sp, BorderLayout.CENTER);
        this.add(sitbarLable, BorderLayout.SOUTH);
        this.setTitle("记事本");
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void makeMenu(JMenuBar mb) {//构建菜单与菜单项，并为其注册监听器
        JMenu fileMenu = new JMenu("文件(F)");
        JMenu editMenu = new JMenu("编辑(E)");
        JMenu formatMenu = new JMenu("格式(F)");
        JMenu viewMenu = new JMenu("查看(V)");
        JMenu helpMenu = new JMenu("帮助(H)");
        newFile = new JMenuItem("新建(N)", 'N');
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newFile.addActionListener(this);
        openFile = new JMenuItem("打开(O)", 'O');
        openFile.addActionListener(this);
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveFile = new JMenuItem("保存(S)", 'S');
        saveFile.addActionListener(this);
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveOtherFile = new JMenuItem("另存为(A)", 'A');
        saveOtherFile.addActionListener(this);
        saveOtherFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
        exitMenu = new JMenuItem("退出(X)", 'X');
        exitMenu.addActionListener(this);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveOtherFile);
        fileMenu.addSeparator();
        fileMenu.add(exitMenu);

        drawBack = new JMenuItem("撤销(U)", 'U');
        drawBack.addActionListener(this);
        drawBack.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        cut = new JMenuItem("剪切(T)", 'T');
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copy = new JMenuItem("复制(C)", 'C');
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste = new JMenuItem("粘贴(P)", 'P');
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        delete = new JMenuItem("删除(D)", 'D');
        delete.addActionListener(this);
        delete.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_DELETE));//这里设置了快捷键Delete，但是在菜单中不显示
        find = new JMenuItem("查找(F)", 'F');
        find.addActionListener(this);
        find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        replace = new JMenuItem("替换(R)", 'R');
        replace.addActionListener(this);
        replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        allSelect = new JMenuItem("全选(A)", 'A');
        allSelect.addActionListener(this);
        allSelect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        date = new JMenuItem("日期/时间(D)", 'D');
        date.setAccelerator(KeyStroke.getKeyStroke("F5"));
        date.addActionListener(this);
        editMenu.add(drawBack);
        editMenu.addSeparator();
        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(delete);
        editMenu.addSeparator();
        editMenu.add(find);
        editMenu.add(replace);
        editMenu.addSeparator();
        editMenu.add(allSelect);
        editMenu.add(date);

        wrapLine = new JCheckBoxMenuItem("自动换行(W)", false);
        wrapLine.addItemListener(new CheckState());
        font = new JMenuItem("字体(F)", 'F');
        font.addActionListener(this);
        formatMenu.add(wrapLine);
        formatMenu.add(font);

        magnify = new JMenu("缩放(Z)");
        bigger = new JMenuItem("放大(I)", 'I');
        bigger.addActionListener(this);
        smaller = new JMenuItem("缩小(O)", 'O');
        smaller.addActionListener(this);
        resDefault = new JMenuItem("恢复默认缩放");
        resDefault.addActionListener(this);
        magnify.add(bigger);
        magnify.add(smaller);
        magnify.add(resDefault);

        siuBar = new JCheckBoxMenuItem("状态栏(S)", true);
        siuBar.addItemListener(new CheckState());
        viewMenu.add(magnify);
        viewMenu.add(siuBar);

        help = new JMenuItem("查看帮助(H)", 'H');
        help.addActionListener(this);
        about = new JMenuItem("关于记事本(A)", 'A');
        about.addActionListener(this);
        helpMenu.add(help);
        helpMenu.addSeparator();
        helpMenu.add(about);

        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(formatMenu);
        mb.add(viewMenu);
        mb.add(helpMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//监听主窗口所有菜单项与“查找”、“替换”、“字体”窗口中的按钮
        if (e.getSource() == newFile) {//新建
            if (!isSaved) {
                boolean flag = true;
                int operate = showSaveConfirmDialog();//打开保存确认窗口
                if (operate == JOptionPane.YES_OPTION) {//如果点击了是，就打开保存文件选择窗口
                    save.setDialogTitle("保存");
                    saveFile();
                    flag = checkSave();
                    if (flag) {//如果捕获到异常，说明没有选择文件，也不清空现有内容
                        txt.setText("");
                        MyNote.this.setTitle("记事本");
                        sitbarLable.setText("已新建文件。");
                    }
                }else{
                    txt.setText("");
                    isSaved = true;//每次新建都判断已经保存
                    MyNote.this.setTitle("记事本");
                    sitbarLable.setText("已新建文件。");
                }
            } else {
                txt.setText("");
                isSaved = true;
                MyNote.this.setTitle("记事本");
                sitbarLable.setText("已新建文件。");
            }
        } else if (e.getSource() == openFile) {//打开
            boolean flag = true;
            if (!isSaved) {
                int operate = showSaveConfirmDialog();//打开保存确认窗口
                if (operate == JOptionPane.YES_OPTION) {//如果点击了是，先保存文件再打开文件
                    save.setDialogTitle("保存");
                    saveFile();
                    flag = checkSave();
                    if (flag) {//如果在文件选择窗口点击了取消，则不会继续打开文件
                        openFile();
                        flag = checkOpen();
                    }
                } else {//如果点击了否，直接打开文件
                    openFile();
                    flag = checkOpen();
                }
            } else {
                openFile();
                flag = checkOpen();
            }
            if (flag) {
                sitbarLable.setText("已打开文件:" + open.getSelectedFile().getAbsolutePath());
            }
        } else if (e.getSource() == saveFile) {//保存
            if(!isSaved){
                boolean flag = true;
                save.setDialogTitle("保存");
                saveFile();
                flag = checkSave();
                if (flag) {
                    isSaved = true;
                    sitbarLable.setText(save.getSelectedFile().getName() + ".txt已保存到这台电脑。");
                    MyNote.this.setTitle(save.getSelectedFile().getName() + ".txt - 记事本");
                }
            }
        } else if (e.getSource() == exitMenu) {//退出
            exit();
        } else if (e.getSource() == saveOtherFile) {//另存为
            boolean flag = true;
            save.setDialogTitle("另存为");
            saveFile();
            flag = checkSave();
            if (flag) {
                isSaved = true;
                sitbarLable.setText(save.getSelectedFile().getName() + ".txt已保存到这台电脑。");
                MyNote.this.setTitle(save.getSelectedFile().getName() + ".txt - 记事本");
            }
        } else if (e.getSource() == drawBack) {//撤销
            if (um.canUndo()) {
                um.undo();
            }
        } else if (e.getSource() == cut) {//剪切
            txt.cut();
            sitbarLable.setText("已将选中内容移动到剪贴板。");
        } else if (e.getSource() == copy) {//复制
            txt.copy();
            sitbarLable.setText("已将选中内容复制到剪贴板。");
        } else if (e.getSource() == paste) {//粘贴
            txt.paste();
            sitbarLable.setText("已将剪贴板中的内容粘贴到当前位置。");
        } else if (e.getSource() == find) {//查找
            showFindDialog();
        } else if (e.getSource() == delete) {//删除
            txt.replaceSelection("");
            sitbarLable.setText("已删除选中内容。");
        } else if (e.getSource() == findNext1) {//“查找”窗口中的“查找下一个”按钮
            findNextMethod();
        } else if (e.getSource() == cancel1) {//“查找”窗口中的“取消”按钮
            findDialog.dispose();
        } else if (e.getSource() == cancel2) {//“替换”窗口中的“取消”按钮
            replaceDialog.dispose();
        } else if (e.getSource() == replace) {//替换
            showReplaceDialog();
        } else if (e.getSource() == findNext2) {//“替换”窗口中的“查找下一个”按钮
            findMethodInReplace();
        } else if (e.getSource() == replaceNext) {//“替换”窗口中的“替换”按钮
            replaceMethod();
        } else if (e.getSource() == replaceAll) {//“替换”窗口中的“全部替换”按钮
            replaceAllMethod();
        } else if (e.getSource() == allSelect) {//全选
            txt.selectAll();
            sitbarLable.setText("已选中所有内容。");
        } else if (e.getSource() == date) {//日期/时间
            txt.insert(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), txt.getSelectionEnd());
            sitbarLable.setText("已将系统时间插入到当前位置。");
        } else if (e.getSource() == font) {//字体
            showFontDialog();
        } else if (e.getSource() == fontCancel) {//“字体”窗口的“取消”按钮
            fontSettingDialog.dispose();
        } else if (e.getSource() == fontChange) {//“字体”窗口的“确定”按钮
            fontChangeMethod();
        } else if (e.getSource() == bigger) {//缩放→放大
            txt.setFont(new Font(txt.getFont().getFontName(), txt.getFont().getStyle(), txt.getFont().getSize() + 5));
            sitbarLable.setText("放大。当前字体大小："+txt.getFont().getSize());
        } else if (e.getSource() == smaller) {//缩放→缩小
            txt.setFont(new Font(txt.getFont().getFontName(), txt.getFont().getStyle(), txt.getFont().getSize() - 5));
            sitbarLable.setText("缩小。当前字体大小："+txt.getFont().getSize());
        } else if (e.getSource() == resDefault) {//缩放→恢复默认缩放
            txt.setFont(new Font(txt.getFont().getFontName(), txt.getFont().getStyle(), 22));
            sitbarLable.setText("已恢复默认字体大小：22");
        } else if (e.getSource() == help) {//查看帮助
            JOptionPane.showMessageDialog(this, "输入文字，调整字体并将.txt文本文档保存到这台电脑上。", "帮助", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == about) {//关于
            showAboutDialog();
        }
    }

    public void saveFile() {//保存文件
        save.setFileSelectionMode(JFileChooser.FILES_ONLY);//设置只能选择文件
        save.setFileFilter(new FileNameExtensionFilter("txt文件", "txt"));//设置文件扩展名过滤器
        save.showSaveDialog(this);//显示保存窗口
        File f = save.getSelectedFile();
        String s;
        FileWriter fw;
        try {
            s = f.getAbsolutePath() + ".txt";
            fw = new FileWriter(s);
            fw.write(txt.getText());
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (NullPointerException ignored) {
        }
    }

    public void openFile() {//打开文件
        openIsSeleced = true;
        open = new JFileChooser();
        open.setFileFilter(new FileNameExtensionFilter("txt文件", "txt"));
        open.setFileSelectionMode(JFileChooser.FILES_ONLY);
        open.showOpenDialog(this);//显示打开窗口
        File f = open.getSelectedFile();
        BufferedReader br;
        try {
            open.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException ex) {
            openIsSeleced = false;
        }
        if (openIsSeleced) {
            txt.setText("");
            try {
                StringBuffer sb = new StringBuffer();
                this.setTitle(open.getSelectedFile().getName() + " - 记事本");
                br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
                char[] data = new char[1024];
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                txt.setText(String.valueOf(sb));
                br.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            isSaved = true;
            titleDelStar();
        }
    }

    public int showSaveConfirmDialog() {//保存确认窗口
        return JOptionPane.showConfirmDialog(this, "是否保存现有文件？", "保存",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    class CheckChanged implements DocumentListener {//检查文本框内容是否改变的成员内部类

        @Override
        public void insertUpdate(DocumentEvent e) {
            change();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            change();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            change();
        }

        public void change() {
            if (isSaved) {//如果文件已保存
                isSaved = false;//文字改变，保存失效
                openIsSeleced = false;//打开外部文件后编辑了文件，就已经不是从外部打开的文件
            }
            if (openIsSeleced) {//如果文件从外部打开，就默认处于保存状态
                isSaved = true;
            }
            if (!isSaved) {//如果处于未保存状态
                titleAddStar();
            } else {//如果处于保存状态
                titleDelStar();
            }
        }
    }

    class Drawback implements UndoableEditListener {//实现撤销功能的成员内部类

        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            um.addEdit(e.getEdit());
        }
    }

    class CheckMenuAvalible extends FocusAdapter {//检查菜单项是否可用的成员内部类

        @Override
        public void focusLost(FocusEvent e) {
            if (txt.getSelectedText() == null) {//如果没选中文本域中的任何内容，“剪切”，“粘贴”，“复制菜单项不可用
                cut.setEnabled(false);
                copy.setEnabled(false);
                delete.setEnabled(false);
            } else {
                cut.setEnabled(true);
                copy.setEnabled(true);
                delete.setEnabled(true);
            }

            if (txt.getText().isEmpty()) {//如果文本域为空，“查找”，“替换”菜单项不可用
                find.setEnabled(false);
                replace.setEnabled(false);
            } else {
                find.setEnabled(true);
                replace.setEnabled(true);
            }

            //如果可以不能撤销，“撤销”菜单项不可用
            drawBack.setEnabled(um.canUndo());
            //下面这两个if语句防止查找和替换窗口被打开多次，如果其中一个被打开，另一个菜单项就会不可用
            if (findDialog.isShowing()) {
                find.setEnabled(false);
            }

            if (replaceDialog.isShowing()) {
                replace.setEnabled(false);
            }
        }
    }

    public void showFindDialog() {//查找窗口
        if (replaceDialog.isShowing()) {//查找窗口已经打开，如果替换窗口再次被打开，直接关闭
            replaceDialog.dispose();
        }
        findDialog = new JDialog(this, "查找", false);
        findDialog.setLayout(null);

        JLabel jl = new JLabel("查找内容(N):");
        jl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        jl.setBounds(10, 10, 100, 50);
        findDialog.add(jl);

        findString1 = new JTextField(35);
        findString1.setBounds(90, 25, 200, 25);
        findString1.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        findDialog.add(findString1);

        findNext1 = new JButton("查找下一个(F)");
        findNext1.setEnabled(false);
        findNext1.setPreferredSize(new Dimension(115, 30));
        findNext1.setBounds(300, 23, 110, 30);
        findNext1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        findNext1.addActionListener(this);
        findDialog.add(findNext1);

        cancel1 = new JButton("取消");
        cancel1.setBounds(300, 60, 110, 30);
        cancel1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        cancel1.setPreferredSize(new Dimension(115, 30));
        cancel1.addActionListener(this);
        findDialog.add(cancel1);

        findDialog.setSize(445, 155);
        findDialog.setVisible(true);
        findDialog.setResizable(false);
        findDialog.setLocationRelativeTo(this);
        findDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void showReplaceDialog() {//显示替换窗口
        if (findDialog.isShowing()) {//替换窗口已经打开，如果查找窗口再次被打开，直接关闭
            findDialog.dispose();
        }
        replaceDialog = new JDialog(this, "替换", false);
        replaceDialog.setLayout(null);
        JLabel jl = new JLabel("查找内容(N):");
        jl.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        jl.setBounds(10, 10, 100, 50);
        replaceDialog.add(jl);

        findString2 = new JTextField(35);
        findString2.setBounds(90, 25, 200, 25);
        findString2.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        replaceDialog.add(findString2);

        findNext2 = new JButton("查找下一个(F)");
        findNext2.setPreferredSize(new Dimension(115, 30));
        findNext2.setBounds(300, 23, 110, 30);
        findNext2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        findNext2.setEnabled(false);
        findNext2.addActionListener(this);
        replaceDialog.add(findNext2);

        JLabel j2 = new JLabel("替换为(P):");
        j2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        j2.setBounds(10, 46, 100, 50);
        replaceDialog.add(j2);
        replaceString = new JTextField(35);
        replaceString.setBounds(90, 61, 200, 25);
        replaceString.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        replaceDialog.add(replaceString);

        replaceNext = new JButton("替换(R)");
        replaceNext.setPreferredSize(new Dimension(115, 30));
        replaceNext.setEnabled(false);
        replaceNext.setBounds(300, 57, 110, 30);
        replaceNext.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        replaceNext.addActionListener(this);
        replaceDialog.add(replaceNext);

        replaceAll = new JButton("全部替换(A)");
        replaceAll.setPreferredSize(new Dimension(115, 30));
        replaceAll.setEnabled(false);
        replaceAll.setBounds(300, 91, 110, 30);
        replaceAll.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        replaceAll.addActionListener(this);
        replaceDialog.add(replaceAll);

        cancel2 = new JButton("取消");
        cancel2.setBounds(300, 125, 110, 30);
        cancel2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        cancel2.setPreferredSize(new Dimension(115, 30));
        cancel2.addActionListener(this);
        replaceDialog.add(cancel2);

        replaceDialog.setSize(445, 215);
        replaceDialog.setVisible(true);
        replaceDialog.setResizable(false);
        replaceDialog.setLocationRelativeTo(this);
        replaceDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void findNextMethod() {//实现“查找”窗口的“查找下一个”按钮
        String temp = txt.getText();
        if (txt.getSelectionEnd() == txt.getText().length()) {//如果文本域中被选中文字的结尾已经是文本域中所有文字的结尾，将光标移动到开头
            txt.setCaretPosition(0);
        }
        if (temp.contains(findString1.getText())) {//如果文本域中包含查找的文本
            for (int i = txt.getSelectionEnd(); i <= temp.length() - findString1.getText().length(); i++) {//枚举与查找文本的长度相同的所有子串，范围是被选中的文字的结尾到所有文字的结尾。
                if (findString1.getText().equals(temp.substring(i, i + findString1.getText().length()))) {//如果子串与查找文本匹配
                    txt.select(i, i + findString1.getText().length());//选中匹配的区域
                    break;//每次按顺序查找一个匹配项
                }
                if (temp.lastIndexOf(findString1.getText()) == txt.getSelectionStart() || //如果已经查找到最后一个可匹配到的文本
                        !txt.getText().substring(txt.getSelectionEnd()).contains(findString1.getText())) {//或者从最后一个匹配到的文本到文本域结尾不包含匹配文本时，(不写这个有时不会自动跳转到开头)
                    txt.setCaretPosition(temp.indexOf(findString1.getText()));//将光标移动到第一个能匹配到的文本，实现循环
                }
            }
        } else {//如果找不到，弹出提示
            JOptionPane.showMessageDialog(find, "找不到“" + findString2.getText() + "”", "记事本", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void findMethodInReplace() {//实现“替换”窗口的“查找”按钮
        String temp = txt.getText();//与上面的查找功能相同
        if (txt.getSelectionEnd() == txt.getText().length()) {
            txt.setCaretPosition(0);
        }
        if (temp.contains(findString2.getText())) {
            for (int i = txt.getSelectionEnd(); i <= temp.length() - findString2.getText().length(); i++) {
                if (findString2.getText().equals(temp.substring(i, i + findString2.getText().length()))) {
                    txt.select(i, i + findString2.getText().length());
                    break;
                }
                if (temp.lastIndexOf(findString2.getText()) == txt.getSelectionStart() ||
                        !txt.getText().substring(txt.getSelectionEnd()).contains(findString2.getText())) {
                    txt.setCaretPosition(temp.indexOf(findString2.getText()));
                }
            }
        } else {
            JOptionPane.showMessageDialog(find, "找不到" + "“" + findString2.getText() + "”", "记事本", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void replaceMethod() {//实现“替换”窗口的“替换”按钮
        String s = replaceString.getText();
        findMethodInReplace();//准备替换通过查找而被选中文本
        if (txt.getSelectedText() != null) {//只要被选中文本非空就将其替换
            txt.replaceSelection(s);
        }
    }

    class CheckState implements ItemListener {//检查带有复选功能的菜单项状态的成员内部类

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (siuBar.getState()) {//检查“状态栏”菜单是否被选中
                MyNote.this.add(sitbarLable, BorderLayout.PAGE_END);
            } else {
                MyNote.this.remove(sitbarLable);
            }
            MyNote.this.txt.setLineWrap(wrapLine.getState());//检查“自动换行”菜单是否被选中
            MyNote.this.validate();//每次改变窗口各组件布局，可以通过这个方法刷新窗口，使其生效
        }
    }

    class CheckFindAndReplaceString implements DocumentListener {//检查“查找”和“替换”窗口中按钮的可用性的成员内部类

        @Override
        public void insertUpdate(DocumentEvent e) {
            change();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            change();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            change();
        }

        public void change() {//在“查找”和“替换”窗口中文本框非空状态下，窗口中的按钮才可用
            if (findString1 != null) {
                findNext1.setEnabled(!findString1.getText().equals(""));
            }

            if (findString2 != null) {
                if (findString2.getText().equals("")) {
                    findNext2.setEnabled(false);
                    replaceNext.setEnabled(false);
                    replaceAll.setEnabled(false);
                } else {
                    findNext2.setEnabled(true);
                    replaceNext.setEnabled(true);
                    replaceAll.setEnabled(true);
                }
            }
        }
    }

    public void replaceAllMethod() {//“替换”窗口中的“全部替换”按钮
        if (txt.getText().contains(findString2.getText())) {//如果文本域包含要替换的文本
            txt.setText(txt.getText().replace(findString2.getText(), replaceString.getText()));//将文本域中的文本设置成替换后的文本
        } else {
            JOptionPane.showMessageDialog(replaceDialog, "找不到“" + findString2.getText() + "”", "记事本", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void showFontDialog() {//字体窗口
        //这里解决了使用JDialog的有参构造方法而无法设置会话框居中的问题，可能是应该先设定窗口位置，再设置其可见性
        fontSettingDialog = new JDialog(this, "字体", true);
        JPanel whole = new JPanel();
        JPanel jp = new JPanel(new GridLayout());

        JPanel fontNamejp = new JPanel();
        JLabel fontlabel1 = new JLabel("字体(F):");
        fontlabel1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        Font f = txt.getFont();
        fontName = new JComboBox<>();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//返回本地图形环境对象
        String[] fontNames = ge.getAvailableFontFamilyNames();//获取本地字体库
        fontName.setModel(new DefaultComboBoxModel(fontNames));
        fontName.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        fontName.setPreferredSize(new Dimension(180, 25));
        fontName.setSelectedItem(f.getFontName());//打开窗口时直接获取文本域的字体名
        fontNamejp.add(fontlabel1);
        fontNamejp.add(fontName);
        jp.add(fontNamejp);
        jp.add(fontNamejp);

        JPanel fontStylejp = new JPanel();
        JLabel fontlabel2 = new JLabel("字形(Y):");
        fontlabel2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        fontStyle = new JComboBox<>();
        String[] fontStyles = {"常规", "粗体", "斜体", "粗斜体"};
        fontStyle.setModel(new DefaultComboBoxModel(fontStyles));
        fontStyle.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        fontStyle.setPreferredSize(new Dimension(180, 25));
        fontStyle.setSelectedIndex(f.getStyle());//打开窗口时直接获取文本域的字形
        fontStylejp.add(fontlabel2);
        fontStylejp.add(fontStyle);
        jp.add(fontStylejp);

        JPanel fontSizejp = new JPanel();
        JLabel fontlabel3 = new JLabel("大小(S):");
        fontlabel3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        fontSize = new JComboBox<>();
        String[] fontSizes = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
        fontSize.setModel(new DefaultComboBoxModel(fontSizes));
        fontSize.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        fontSize.setPreferredSize(new Dimension(180, 25));
        fontSize.setEditable(true);//如果不设置JCombox对象可编辑，下一行代码不起作用
        fontSize.setSelectedItem(f.getSize());//打开窗口时直接获取文本域的字体大小
        fontSizejp.add(fontlabel3);
        fontSizejp.add(fontSize);
        jp.add(fontSizejp);
        whole.add(jp, BorderLayout.NORTH);

        JPanel button = new JPanel();
        fontChange = new JButton("确定");
        fontChange.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        fontChange.setPreferredSize(new Dimension(80, 30));
        fontChange.addActionListener(this);
        fontCancel = new JButton("取消");
        fontCancel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        fontCancel.setPreferredSize(new Dimension(80, 30));
        fontCancel.addActionListener(this);
        button.add(new JLabel("                                                                                   "));
        button.add(fontChange);
        button.add(fontCancel);
        whole.add(button, BorderLayout.LINE_END);

        fontSettingDialog.add(whole);
        fontSettingDialog.setSize(750, 135);
        fontSettingDialog.setResizable(false);
        fontSettingDialog.setLocationRelativeTo(this);//先设置窗口位置居中
        fontSettingDialog.setVisible(true);//再设置窗口可见性，可以使JDialog窗口居中
        fontSettingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void fontChangeMethod() {//“字体”窗口的“确认”按钮
        int style = 0;//存储字体样式
        if (fontStyle.getSelectedItem().equals("常规")) {
            style = Font.PLAIN;
        } else if (fontStyle.getSelectedItem().equals("斜体")) {
            style = Font.ITALIC;
        } else if (fontStyle.getSelectedItem().equals("粗体")) {
            style = Font.BOLD;
        } else if (fontStyle.getSelectedItem().equals("粗斜体")) {
            style = Font.BOLD + Font.ITALIC;
        }
        try{
            Long.parseLong(String.valueOf(fontSize.getSelectedItem()));
        }catch(NumberFormatException e){
//            StackTraceElement[] s = e.getStackTrace();
//            s.
        }
        if (Long.parseLong(String.valueOf(fontSize.getSelectedItem())) > 0) {
            if (String.valueOf(fontSize.getSelectedItem()).length() <= 6) {
                txt.setFont(new Font(String.valueOf(fontName.getSelectedItem()), style,
                        Integer.parseInt(String.valueOf(fontSize.getSelectedItem()))));
                fontSettingDialog.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "字体大小不得大于999999。", "记事本", JOptionPane.ERROR_MESSAGE);
                fontSize.setSelectedItem(999999);
            }
        } else {
            JOptionPane.showMessageDialog(this, "字体大小不得小于0。", "记事本", JOptionPane.ERROR_MESSAGE);
            fontSize.setSelectedItem(1);
        }
    }

    public void showAboutDialog() {//显示关于窗口
        JDialog aboutDialog = new JDialog(this, "关于记事本", true);
        aboutDialog.setLayout(null);//需要自定义窗口各个组件布局，所以不使用任何布局管理器
        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon(MyNote.class.getResource("headPics.png")));
        pic.setBounds(20, 20, 128, 128);
        JLabel author = new JLabel();
        author.setIcon(new ImageIcon(MyNote.class.getResource("name.png")));
        author.setBounds(220, 20, 144, 93);
        aboutDialog.add(author);
        aboutDialog.add(pic);
        JTextArea data = new JTextArea("""
                记事本 版本1.0
                发布：2022年5月3日
                更新请联系作者(Kim Jackson(JinLei))
                Copyright 2001-2022
                JiangXi University of Technology""");
        data.setEditable(false);
        data.setBackground(new Color(240, 240, 240));
        data.setBounds(200, 120, 300, 100);
        data.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        aboutDialog.add(data);
        aboutDialog.setSize(450, 270);
        aboutDialog.setResizable(false);//这句话必须写在setSize()方法之后
        aboutDialog.setLocationRelativeTo(this);
        aboutDialog.setVisible(true);
        aboutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public boolean checkSave() {//检查是否出现在保存窗口中点击了“取消”的情况
        try {
            save.getSelectedFile().getAbsolutePath();//如果不能取到选中文件的路径，抛出NullPointerException
        } catch (NullPointerException ex) {//捕获到异常说明“取消”按钮被点击
            return false;
        }
        return true;
    }

    public boolean checkOpen() {//检查是否出现在打开窗口中点击了“取消”的情况，与checkSave()方法相同
        try {
            open.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException ex) {
            return false;
        }
        return true;
    }

    public void titleAddStar(){//为标题开头加上*
        if (!MyNote.this.getTitle().startsWith("*")) {
            MyNote.this.setTitle("*" + MyNote.this.getTitle());
        }
    }

    public void titleDelStar(){//删除标题开头的*
        if (MyNote.this.getTitle().startsWith("*")) {
            MyNote.this.setTitle(MyNote.this.getTitle().substring(1));
        }
    }

    public void exit(){//控制退出过程
        boolean flag = true;
        boolean cancel = false;
        if (!isSaved) {
            int operate = showSaveConfirmDialog();
            if (operate == 0) {
                saveFile();
                flag = checkSave();
            } else if(operate == 1) {
                System.exit(0);
            } else{
                cancel = true;
            }
        } else {
            System.exit(0);
        }
        if (flag) {
            if(!cancel){
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//设置系统外观
        MyNote win = new MyNote();
    }
}
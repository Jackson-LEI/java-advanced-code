package classTeaching.week9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;

/* loaded from: MyNote.class */
public class MyNote extends JFrame implements ActionListener {
    JMenuItem newFile;
    JMenuItem openFile;
    JMenuItem saveFile;
    JMenuItem saveOtherFile;
    JMenuItem exitMenu;
    JMenuItem drawBack;
    JMenuItem cut;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem delete;
    JMenuItem find;
    JMenuItem replace;
    JMenuItem allSelect;
    JMenuItem date;
    JMenuItem font;
    JMenuItem bigger;
    JMenuItem smaller;
    JMenuItem resDefault;
    JMenuItem help;
    JMenuItem about;
    JCheckBoxMenuItem wrapLine;
    JCheckBoxMenuItem siuBar;
    JMenu magnify;
    JFileChooser open;
    JDialog fontSettingDialog;
    JTextField findString1;
    JTextField findString2;
    JTextField replaceString;
    JButton findNext1;
    JButton findNext2;
    JButton replaceNext;
    JButton replaceAll;
    JButton fontChange;
    JButton fontCancel;
    JButton cancel1;
    JButton cancel2;
    JComboBox<String> fontName;
    JComboBox<String> fontStyle;
    JComboBox<Integer> fontSize;
    boolean isSaved = true;
    boolean openIsSeleced = false;
    JFileChooser save = new JFileChooser();
    JDialog findDialog = new JDialog(this, "查找", false);
    JDialog replaceDialog = new JDialog(this, "替换", false);
    JLabel sitbarLable = new JLabel("准备就绪");
    JTextArea txt = new JTextArea();
    UndoManager um = new UndoManager();
    JScrollPane sp = new JScrollPane(this.txt);

    public MyNote() {
        JMenuBar mb = new JMenuBar();
        makeMenu(mb);
        setJMenuBar(mb);
        this.sitbarLable.setFont(new Font("微软雅黑", 0, 12));
        this.sitbarLable.setHorizontalAlignment(4);
        this.txt.setFont(new Font("宋体", 0, 22));
        this.txt.setWrapStyleWord(true);
        this.txt.getDocument().addDocumentListener(new CheckChanged());
        this.txt.addFocusListener(new CheckMenuAvalible());
        this.txt.getDocument().addUndoableEditListener(new Drawback());
        addWindowListener(new WindowAdapter() { // from class: classTeaching.week9.MyNote.1
            public void windowClosing(WindowEvent e) {
                MyNote.this.exit();
            }
        });
        setIconImage(new ImageIcon(MyNote.class.getResource("icon.png")).getImage());
        setLayout(new BorderLayout(5, 5));
        add(this.sp, "Center");
        add(this.sitbarLable, "South");
        setTitle("记事本");
        setSize(1000, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(0);
    }

    public void makeMenu(JMenuBar mb) {
        JMenu fileMenu = new JMenu("文件(F)");
        JMenu editMenu = new JMenu("编辑(E)");
        JMenu formatMenu = new JMenu("格式(F)");
        JMenu viewMenu = new JMenu("查看(V)");
        JMenu helpMenu = new JMenu("帮助(H)");
        this.newFile = new JMenuItem("新建(N)", 78);
        this.newFile.setAccelerator(KeyStroke.getKeyStroke(78, 2));
        this.newFile.addActionListener(this);
        this.openFile = new JMenuItem("打开(O)", 79);
        this.openFile.addActionListener(this);
        this.openFile.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        this.saveFile = new JMenuItem("保存(S)", 83);
        this.saveFile.addActionListener(this);
        this.saveFile.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        this.saveOtherFile = new JMenuItem("另存为(A)", 65);
        this.saveOtherFile.addActionListener(this);
        this.saveOtherFile.setAccelerator(KeyStroke.getKeyStroke(83, 3));
        this.exitMenu = new JMenuItem("退出(X)", 88);
        this.exitMenu.addActionListener(this);
        fileMenu.add(this.newFile);
        fileMenu.add(this.openFile);
        fileMenu.add(this.saveFile);
        fileMenu.add(this.saveOtherFile);
        fileMenu.addSeparator();
        fileMenu.add(this.exitMenu);
        this.drawBack = new JMenuItem("撤销(U)", 85);
        this.drawBack.addActionListener(this);
        this.drawBack.setAccelerator(KeyStroke.getKeyStroke(90, 2));
        this.cut = new JMenuItem("剪切(T)", 84);
        this.cut.addActionListener(this);
        this.cut.setAccelerator(KeyStroke.getKeyStroke(88, 2));
        this.copy = new JMenuItem("复制(C)", 67);
        this.copy.addActionListener(this);
        this.copy.setAccelerator(KeyStroke.getKeyStroke(67, 2));
        this.paste = new JMenuItem("粘贴(P)", 80);
        this.paste.addActionListener(this);
        this.paste.setAccelerator(KeyStroke.getKeyStroke(86, 2));
        this.delete = new JMenuItem("删除(D)", 68);
        this.delete.addActionListener(this);
        this.delete.setAccelerator(KeyStroke.getKeyStroke((char) 127));
        this.find = new JMenuItem("查找(F)", 70);
        this.find.addActionListener(this);
        this.find.setAccelerator(KeyStroke.getKeyStroke(70, 2));
        this.replace = new JMenuItem("替换(R)", 82);
        this.replace.addActionListener(this);
        this.replace.setAccelerator(KeyStroke.getKeyStroke(72, 2));
        this.allSelect = new JMenuItem("全选(A)", 65);
        this.allSelect.addActionListener(this);
        this.allSelect.setAccelerator(KeyStroke.getKeyStroke(65, 2));
        this.date = new JMenuItem("日期/时间(D)", 68);
        this.date.setAccelerator(KeyStroke.getKeyStroke("F5"));
        this.date.addActionListener(this);
        editMenu.add(this.drawBack);
        editMenu.addSeparator();
        editMenu.add(this.cut);
        editMenu.add(this.copy);
        editMenu.add(this.paste);
        editMenu.add(this.delete);
        editMenu.addSeparator();
        editMenu.add(this.find);
        editMenu.add(this.replace);
        editMenu.addSeparator();
        editMenu.add(this.allSelect);
        editMenu.add(this.date);
        this.wrapLine = new JCheckBoxMenuItem("自动换行(W)", false);
        this.wrapLine.addItemListener(new CheckState());
        this.font = new JMenuItem("字体(F)", 70);
        this.font.addActionListener(this);
        formatMenu.add(this.wrapLine);
        formatMenu.add(this.font);
        this.magnify = new JMenu("缩放(Z)");
        this.bigger = new JMenuItem("放大(I)", 73);
        this.bigger.addActionListener(this);
        this.smaller = new JMenuItem("缩小(O)", 79);
        this.smaller.addActionListener(this);
        this.resDefault = new JMenuItem("恢复默认缩放");
        this.resDefault.addActionListener(this);
        this.magnify.add(this.bigger);
        this.magnify.add(this.smaller);
        this.magnify.add(this.resDefault);
        this.siuBar = new JCheckBoxMenuItem("状态栏(S)", true);
        this.siuBar.addItemListener(new CheckState());
        viewMenu.add(this.magnify);
        viewMenu.add(this.siuBar);
        this.help = new JMenuItem("查看帮助(H)", 72);
        this.help.addActionListener(this);
        this.about = new JMenuItem("关于记事本(A)", 65);
        this.about.addActionListener(this);
        helpMenu.add(this.help);
        helpMenu.addSeparator();
        helpMenu.add(this.about);
        mb.add(fileMenu);
        mb.add(editMenu);
        mb.add(formatMenu);
        mb.add(viewMenu);
        mb.add(helpMenu);
    }

    public void actionPerformed(ActionEvent e) {
        boolean flag;
        if (e.getSource() == this.newFile) {
            if (!this.isSaved) {
                int operate = showSaveConfirmDialog();
                if (operate == 0) {
                    this.save.setDialogTitle("保存");
                    saveFile();
                    boolean flag2 = checkSave();
                    if (flag2) {
                        this.txt.setText("");
                        setTitle("记事本");
                        this.sitbarLable.setText("已新建文件。");
                        return;
                    }
                    return;
                }
                this.txt.setText("");
                this.isSaved = true;
                setTitle("记事本");
                this.sitbarLable.setText("已新建文件。");
                return;
            }
            this.txt.setText("");
            this.isSaved = true;
            setTitle("记事本");
            this.sitbarLable.setText("已新建文件。");
        } else if (e.getSource() == this.openFile) {
            if (!this.isSaved) {
                int operate2 = showSaveConfirmDialog();
                if (operate2 == 0) {
                    this.save.setDialogTitle("保存");
                    saveFile();
                    flag = checkSave();
                    if (flag) {
                        openFile();
                        flag = checkOpen();
                    }
                } else {
                    openFile();
                    flag = checkOpen();
                }
            } else {
                openFile();
                flag = checkOpen();
            }
            if (flag) {
                this.sitbarLable.setText("已打开文件:" + this.open.getSelectedFile().getAbsolutePath());
            }
        } else if (e.getSource() == this.saveFile) {
            if (!this.isSaved) {
                this.save.setDialogTitle("保存");
                saveFile();
                boolean flag3 = checkSave();
                if (flag3) {
                    this.isSaved = true;
                    this.sitbarLable.setText(this.save.getSelectedFile().getName() + ".txt已保存到这台电脑。");
                    setTitle(this.save.getSelectedFile().getName() + ".txt - 记事本");
                }
            }
        } else if (e.getSource() == this.exitMenu) {
            exit();
        } else if (e.getSource() == this.saveOtherFile) {
            this.save.setDialogTitle("另存为");
            saveFile();
            boolean flag4 = checkSave();
            if (flag4) {
                this.isSaved = true;
                this.sitbarLable.setText(this.save.getSelectedFile().getName() + ".txt已保存到这台电脑。");
                setTitle(this.save.getSelectedFile().getName() + ".txt - 记事本");
            }
        } else if (e.getSource() == this.drawBack) {
            if (this.um.canUndo()) {
                this.um.undo();
            }
        } else if (e.getSource() == this.cut) {
            this.txt.cut();
            this.sitbarLable.setText("已将选中内容移动到剪贴板。");
        } else if (e.getSource() == this.copy) {
            this.txt.copy();
            this.sitbarLable.setText("已将选中内容复制到剪贴板。");
        } else if (e.getSource() == this.paste) {
            this.txt.paste();
            this.sitbarLable.setText("已将剪贴板中的内容粘贴到当前位置。");
        } else if (e.getSource() == this.find) {
            showFindDialog();
        } else if (e.getSource() == this.delete) {
            this.txt.replaceSelection("");
            this.sitbarLable.setText("已删除选中内容。");
        } else if (e.getSource() == this.findNext1) {
            findNextMethod();
        } else if (e.getSource() == this.cancel1) {
            this.findDialog.dispose();
        } else if (e.getSource() == this.cancel2) {
            this.replaceDialog.dispose();
        } else if (e.getSource() == this.replace) {
            showReplaceDialog();
        } else if (e.getSource() == this.findNext2) {
            findMethodInReplace();
        } else if (e.getSource() == this.replaceNext) {
            replaceMethod();
        } else if (e.getSource() == this.replaceAll) {
            replaceAllMethod();
        } else if (e.getSource() == this.allSelect) {
            this.txt.selectAll();
            this.sitbarLable.setText("已选中所有内容。");
        } else if (e.getSource() == this.date) {
            this.txt.insert(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), this.txt.getSelectionEnd());
            this.sitbarLable.setText("已将系统时间插入到当前位置。");
        } else if (e.getSource() == this.font) {
            showFontDialog();
        } else if (e.getSource() == this.fontCancel) {
            this.fontSettingDialog.dispose();
        } else if (e.getSource() == this.fontChange) {
            fontChangeMethod();
        } else if (e.getSource() == this.bigger) {
            this.txt.setFont(new Font(this.txt.getFont().getFontName(), this.txt.getFont().getStyle(), this.txt.getFont().getSize() + 5));
            this.sitbarLable.setText("放大。当前字体大小：" + this.txt.getFont().getSize());
        } else if (e.getSource() == this.smaller) {
            this.txt.setFont(new Font(this.txt.getFont().getFontName(), this.txt.getFont().getStyle(), this.txt.getFont().getSize() - 5));
            this.sitbarLable.setText("缩小。当前字体大小：" + this.txt.getFont().getSize());
        } else if (e.getSource() == this.resDefault) {
            this.txt.setFont(new Font(this.txt.getFont().getFontName(), this.txt.getFont().getStyle(), 22));
            this.sitbarLable.setText("已恢复默认字体大小：22");
        } else if (e.getSource() == this.help) {
            JOptionPane.showMessageDialog(this, "输入文字，调整字体并将.txt文本文档保存到这台电脑上。", "帮助", 1);
        } else if (e.getSource() == this.about) {
            showAboutDialog();
        }
    }

    public void saveFile() {
        this.save.setFileSelectionMode(0);
        this.save.setFileFilter(new FileNameExtensionFilter("txt文件", new String[]{"txt"}));
        this.save.showSaveDialog(this);
        File f = this.save.getSelectedFile();
        try {
            String s = f.getAbsolutePath() + ".txt";
            FileWriter fw = new FileWriter(s);
            fw.write(this.txt.getText());
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (NullPointerException e) {
        }
    }

    public void openFile() {
        this.openIsSeleced = true;
        this.open = new JFileChooser();
        this.open.setFileFilter(new FileNameExtensionFilter("txt文件", new String[]{"txt"}));
        this.open.setFileSelectionMode(0);
        this.open.showOpenDialog(this);
        File f = this.open.getSelectedFile();
        try {
            this.open.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException e) {
            this.openIsSeleced = false;
        }
        if (this.openIsSeleced) {
            this.txt.setText("");
            try {
                StringBuffer sb = new StringBuffer();
                setTitle(this.open.getSelectedFile().getName() + " - 记事本");
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8));
                char[] cArr = new char[1024];
                while (true) {
                    String line = br.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append("\n");
                    } else {
                        this.txt.setText(String.valueOf(sb));
                        br.close();
                        this.isSaved = true;
                        titleDelStar();
                        return;
                    }
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public int showSaveConfirmDialog() {
        return JOptionPane.showConfirmDialog(this, "是否保存现有文件？", "保存", 1, 3);
    }

    /* loaded from: MyNote$CheckChanged.class */
    class CheckChanged implements DocumentListener {
        CheckChanged() {
        }

        public void insertUpdate(DocumentEvent e) {
            change();
        }

        public void removeUpdate(DocumentEvent e) {
            change();
        }

        public void changedUpdate(DocumentEvent e) {
            change();
        }

        public void change() {
            if (MyNote.this.isSaved) {
                MyNote.this.isSaved = false;
                MyNote.this.openIsSeleced = false;
            }
            if (MyNote.this.openIsSeleced) {
                MyNote.this.isSaved = true;
            }
            if (!MyNote.this.isSaved) {
                MyNote.this.titleAddStar();
            } else {
                MyNote.this.titleDelStar();
            }
        }
    }

    /* loaded from: MyNote$Drawback.class */
    class Drawback implements UndoableEditListener {
        Drawback() {
        }

        public void undoableEditHappened(UndoableEditEvent e) {
            MyNote.this.um.addEdit(e.getEdit());
        }
    }

    /* loaded from: MyNote$CheckMenuAvalible.class */
    class CheckMenuAvalible extends FocusAdapter {
        CheckMenuAvalible() {
        }

        public void focusLost(FocusEvent e) {
            if (MyNote.this.txt.getSelectedText() == null) {
                MyNote.this.cut.setEnabled(false);
                MyNote.this.copy.setEnabled(false);
                MyNote.this.delete.setEnabled(false);
            } else {
                MyNote.this.cut.setEnabled(true);
                MyNote.this.copy.setEnabled(true);
                MyNote.this.delete.setEnabled(true);
            }
            if (MyNote.this.txt.getText().isEmpty()) {
                MyNote.this.find.setEnabled(false);
                MyNote.this.replace.setEnabled(false);
            } else {
                MyNote.this.find.setEnabled(true);
                MyNote.this.replace.setEnabled(true);
            }
            MyNote.this.drawBack.setEnabled(MyNote.this.um.canUndo());
            if (MyNote.this.findDialog.isShowing()) {
                MyNote.this.find.setEnabled(false);
            }
            if (MyNote.this.replaceDialog.isShowing()) {
                MyNote.this.replace.setEnabled(false);
            }
        }
    }

    public void showFindDialog() {
        if (this.replaceDialog.isShowing()) {
            this.replaceDialog.dispose();
        }
        this.findDialog = new JDialog(this, "查找", false);
        this.findDialog.setLayout((LayoutManager) null);
        JLabel jl = new JLabel("查找内容(N):");
        jl.setFont(new Font("微软雅黑", 0, 12));
        jl.setBounds(10, 10, 100, 50);
        this.findDialog.add(jl);
        this.findString1 = new JTextField(35);
        this.findString1.setBounds(90, 25, 200, 25);
        this.findString1.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        this.findDialog.add(this.findString1);
        this.findNext1 = new JButton("查找下一个(F)");
        this.findNext1.setEnabled(false);
        this.findNext1.setPreferredSize(new Dimension(115, 30));
        this.findNext1.setBounds(300, 23, 110, 30);
        this.findNext1.setFont(new Font("微软雅黑", 0, 12));
        this.findNext1.addActionListener(this);
        this.findDialog.add(this.findNext1);
        this.cancel1 = new JButton("取消");
        this.cancel1.setBounds(300, 60, 110, 30);
        this.cancel1.setFont(new Font("微软雅黑", 0, 12));
        this.cancel1.setPreferredSize(new Dimension(115, 30));
        this.cancel1.addActionListener(this);
        this.findDialog.add(this.cancel1);
        this.findDialog.setSize(445, 155);
        this.findDialog.setVisible(true);
        this.findDialog.setResizable(false);
        this.findDialog.setLocationRelativeTo(this);
        this.findDialog.setDefaultCloseOperation(2);
    }

    public void showReplaceDialog() {
        if (this.findDialog.isShowing()) {
            this.findDialog.dispose();
        }
        this.replaceDialog = new JDialog(this, "替换", false);
        this.replaceDialog.setLayout((LayoutManager) null);
        JLabel jl = new JLabel("查找内容(N):");
        jl.setFont(new Font("微软雅黑", 0, 12));
        jl.setBounds(10, 10, 100, 50);
        this.replaceDialog.add(jl);
        this.findString2 = new JTextField(35);
        this.findString2.setBounds(90, 25, 200, 25);
        this.findString2.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        this.replaceDialog.add(this.findString2);
        this.findNext2 = new JButton("查找下一个(F)");
        this.findNext2.setPreferredSize(new Dimension(115, 30));
        this.findNext2.setBounds(300, 23, 110, 30);
        this.findNext2.setFont(new Font("微软雅黑", 0, 12));
        this.findNext2.setEnabled(false);
        this.findNext2.addActionListener(this);
        this.replaceDialog.add(this.findNext2);
        JLabel j2 = new JLabel("替换为(P):");
        j2.setFont(new Font("微软雅黑", 0, 12));
        j2.setBounds(10, 46, 100, 50);
        this.replaceDialog.add(j2);
        this.replaceString = new JTextField(35);
        this.replaceString.setBounds(90, 61, 200, 25);
        this.replaceString.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        this.replaceDialog.add(this.replaceString);
        this.replaceNext = new JButton("替换(R)");
        this.replaceNext.setPreferredSize(new Dimension(115, 30));
        this.replaceNext.setEnabled(false);
        this.replaceNext.setBounds(300, 57, 110, 30);
        this.replaceNext.setFont(new Font("微软雅黑", 0, 12));
        this.replaceNext.addActionListener(this);
        this.replaceDialog.add(this.replaceNext);
        this.replaceAll = new JButton("全部替换(A)");
        this.replaceAll.setPreferredSize(new Dimension(115, 30));
        this.replaceAll.setEnabled(false);
        this.replaceAll.setBounds(300, 91, 110, 30);
        this.replaceAll.setFont(new Font("微软雅黑", 0, 12));
        this.replaceAll.addActionListener(this);
        this.replaceDialog.add(this.replaceAll);
        this.cancel2 = new JButton("取消");
        this.cancel2.setBounds(300, 125, 110, 30);
        this.cancel2.setFont(new Font("微软雅黑", 0, 12));
        this.cancel2.setPreferredSize(new Dimension(115, 30));
        this.cancel2.addActionListener(this);
        this.replaceDialog.add(this.cancel2);
        this.replaceDialog.setSize(445, 215);
        this.replaceDialog.setVisible(true);
        this.replaceDialog.setResizable(false);
        this.replaceDialog.setLocationRelativeTo(this);
        this.replaceDialog.setDefaultCloseOperation(2);
    }

    public void findNextMethod() {
        String temp = this.txt.getText();
        if (this.txt.getSelectionEnd() == this.txt.getText().length()) {
            this.txt.setCaretPosition(0);
        }
        if (temp.contains(this.findString1.getText())) {
            for (int i = this.txt.getSelectionEnd(); i <= temp.length() - this.findString1.getText().length(); i++) {
                if (this.findString1.getText().equals(temp.substring(i, i + this.findString1.getText().length()))) {
                    this.txt.select(i, i + this.findString1.getText().length());
                    return;
                }
                if (temp.lastIndexOf(this.findString1.getText()) == this.txt.getSelectionStart() || !this.txt.getText().substring(this.txt.getSelectionEnd()).contains(this.findString1.getText())) {
                    this.txt.setCaretPosition(temp.indexOf(this.findString1.getText()));
                }
            }
            return;
        }
        JOptionPane.showMessageDialog(this.find, "找不到“" + this.findString2.getText() + "”", "记事本", 1);
    }

    public void findMethodInReplace() {
        String temp = this.txt.getText();
        if (this.txt.getSelectionEnd() == this.txt.getText().length()) {
            this.txt.setCaretPosition(0);
        }
        if (temp.contains(this.findString2.getText())) {
            for (int i = this.txt.getSelectionEnd(); i <= temp.length() - this.findString2.getText().length(); i++) {
                if (this.findString2.getText().equals(temp.substring(i, i + this.findString2.getText().length()))) {
                    this.txt.select(i, i + this.findString2.getText().length());
                    return;
                }
                if (temp.lastIndexOf(this.findString2.getText()) == this.txt.getSelectionStart() || !this.txt.getText().substring(this.txt.getSelectionEnd()).contains(this.findString2.getText())) {
                    this.txt.setCaretPosition(temp.indexOf(this.findString2.getText()));
                }
            }
            return;
        }
        JOptionPane.showMessageDialog(this.find, "找不到“" + this.findString2.getText() + "”", "记事本", 1);
    }

    public void replaceMethod() {
        String s = this.replaceString.getText();
        findMethodInReplace();
        if (this.txt.getSelectedText() != null) {
            this.txt.replaceSelection(s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: MyNote$CheckState.class */
    public class CheckState implements ItemListener {
        CheckState() {
        }

        public void itemStateChanged(ItemEvent e) {
            if (MyNote.this.siuBar.getState()) {
                MyNote.this.add(MyNote.this.sitbarLable, "Last");
            } else {
                MyNote.this.remove(MyNote.this.sitbarLable);
            }
            MyNote.this.txt.setLineWrap(MyNote.this.wrapLine.getState());
            MyNote.this.validate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: MyNote$CheckFindAndReplaceString.class */
    public class CheckFindAndReplaceString implements DocumentListener {
        CheckFindAndReplaceString() {
        }

        public void insertUpdate(DocumentEvent e) {
            change();
        }

        public void removeUpdate(DocumentEvent e) {
            change();
        }

        public void changedUpdate(DocumentEvent e) {
            change();
        }

        public void change() {
            if (MyNote.this.findString1 != null) {
                MyNote.this.findNext1.setEnabled(!MyNote.this.findString1.getText().equals(""));
            }
            if (MyNote.this.findString2 != null) {
                if (MyNote.this.findString2.getText().equals("")) {
                    MyNote.this.findNext2.setEnabled(false);
                    MyNote.this.replaceNext.setEnabled(false);
                    MyNote.this.replaceAll.setEnabled(false);
                    return;
                }
                MyNote.this.findNext2.setEnabled(true);
                MyNote.this.replaceNext.setEnabled(true);
                MyNote.this.replaceAll.setEnabled(true);
            }
        }
    }

    public void replaceAllMethod() {
        if (this.txt.getText().contains(this.findString2.getText())) {
            this.txt.setText(this.txt.getText().replace(this.findString2.getText(), this.replaceString.getText()));
        } else {
            JOptionPane.showMessageDialog(this.replaceDialog, "找不到“" + this.findString2.getText() + "”", "记事本", 1);
        }
    }

    public void showFontDialog() {
        this.fontSettingDialog = new JDialog(this, "字体", true);
        JPanel whole = new JPanel();
        JPanel jp = new JPanel(new GridLayout());
        JPanel fontNamejp = new JPanel();
        JLabel fontlabel1 = new JLabel("字体(F):");
        fontlabel1.setFont(new Font("微软雅黑", 0, 12));
        Font f = this.txt.getFont();
        this.fontName = new JComboBox<>();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        this.fontName.setModel(new DefaultComboBoxModel(fontNames));
        this.fontName.setFont(new Font("微软雅黑", 0, 12));
        this.fontName.setPreferredSize(new Dimension(180, 25));
        this.fontName.setSelectedItem(f.getFontName());
        fontNamejp.add(fontlabel1);
        fontNamejp.add(this.fontName);
        jp.add(fontNamejp);
        jp.add(fontNamejp);
        JPanel fontStylejp = new JPanel();
        JLabel fontlabel2 = new JLabel("字形(Y):");
        fontlabel2.setFont(new Font("微软雅黑", 0, 12));
        this.fontStyle = new JComboBox<>();
        String[] fontStyles = {"常规", "粗体", "斜体", "粗斜体"};
        this.fontStyle.setModel(new DefaultComboBoxModel(fontStyles));
        this.fontStyle.setFont(new Font("微软雅黑", 0, 12));
        this.fontStyle.setPreferredSize(new Dimension(180, 25));
        this.fontStyle.setSelectedIndex(f.getStyle());
        fontStylejp.add(fontlabel2);
        fontStylejp.add(this.fontStyle);
        jp.add(fontStylejp);
        JPanel fontSizejp = new JPanel();
        JLabel fontlabel3 = new JLabel("大小(S):");
        fontlabel3.setFont(new Font("微软雅黑", 0, 12));
        this.fontSize = new JComboBox<>();
        String[] fontSizes = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
        this.fontSize.setModel(new DefaultComboBoxModel(fontSizes));
        this.fontSize.setFont(new Font("微软雅黑", 0, 12));
        this.fontSize.setPreferredSize(new Dimension(180, 25));
        this.fontSize.setEditable(true);
        this.fontSize.setSelectedItem(Integer.valueOf(f.getSize()));
        fontSizejp.add(fontlabel3);
        fontSizejp.add(this.fontSize);
        jp.add(fontSizejp);
        whole.add(jp, "North");
        JPanel button = new JPanel();
        this.fontChange = new JButton("确定");
        this.fontChange.setFont(new Font("微软雅黑", 0, 12));
        this.fontChange.setPreferredSize(new Dimension(80, 30));
        this.fontChange.addActionListener(this);
        this.fontCancel = new JButton("取消");
        this.fontCancel.setFont(new Font("微软雅黑", 0, 12));
        this.fontCancel.setPreferredSize(new Dimension(80, 30));
        this.fontCancel.addActionListener(this);
        button.add(new JLabel("                                                                                   "));
        button.add(this.fontChange);
        button.add(this.fontCancel);
        whole.add(button, "After");
        this.fontSettingDialog.add(whole);
        this.fontSettingDialog.setSize(750, 135);
        this.fontSettingDialog.setResizable(false);
        this.fontSettingDialog.setLocationRelativeTo(this);
        this.fontSettingDialog.setVisible(true);
        this.fontSettingDialog.setDefaultCloseOperation(2);
    }

    public void fontChangeMethod() {
        int style = 0;
        if (this.fontStyle.getSelectedItem().equals("常规")) {
            style = 0;
        } else if (this.fontStyle.getSelectedItem().equals("斜体")) {
            style = 2;
        } else if (this.fontStyle.getSelectedItem().equals("粗体")) {
            style = 1;
        } else if (this.fontStyle.getSelectedItem().equals("粗斜体")) {
            style = 3;
        }
        if (Long.parseLong(String.valueOf(this.fontSize.getSelectedItem())) > 0) {
            if (String.valueOf(this.fontSize.getSelectedItem()).length() <= 6) {
                this.txt.setFont(new Font(String.valueOf(this.fontName.getSelectedItem()), style, Integer.parseInt(String.valueOf(this.fontSize.getSelectedItem()))));
                this.fontSettingDialog.dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "字体大小不得大于999999。", "记事本", 0);
            this.fontSize.setSelectedItem(999999);
            return;
        }
        JOptionPane.showMessageDialog(this, "字体大小不得小于0。", "记事本", 0);
        this.fontSize.setSelectedItem(1);
    }

    public void showAboutDialog() {
        JDialog aboutDialog = new JDialog(this, "关于记事本", true);
        aboutDialog.setLayout((LayoutManager) null);
        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon(MyNote.class.getResource("headPics.png")));
        pic.setBounds(20, 20, 128, 128);
        JLabel author = new JLabel();
        author.setIcon(new ImageIcon(MyNote.class.getResource("name.png")));
        author.setBounds(220, 20, 144, 93);
        aboutDialog.add(author);
        aboutDialog.add(pic);
        JTextArea data = new JTextArea("记事本 版本1.0\n发布：2022年5月3日\n更新请联系作者(Kim Jackson(JinLei))\nCopyright 2001-2022\nJiangXi University of Technology");
        data.setEditable(false);
        data.setBackground(new Color(240, 240, 240));
        data.setBounds(200, 120, 300, 100);
        data.setFont(new Font("微软雅黑", 0, 12));
        aboutDialog.add(data);
        aboutDialog.setSize(450, 270);
        aboutDialog.setResizable(false);
        aboutDialog.setLocationRelativeTo(this);
        aboutDialog.setVisible(true);
        aboutDialog.setDefaultCloseOperation(2);
    }

    public boolean checkSave() {
        try {
            this.save.getSelectedFile().getAbsolutePath();
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean checkOpen() {
        try {
            this.open.getSelectedFile().getAbsolutePath();
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void titleAddStar() {
        if (!getTitle().startsWith("*")) {
            setTitle("*" + getTitle());
        }
    }

    public void titleDelStar() {
        if (getTitle().startsWith("*")) {
            setTitle(getTitle().substring(1));
        }
    }

    public void exit() {
        boolean flag = true;
        boolean cancel = false;
        if (!this.isSaved) {
            int operate = showSaveConfirmDialog();
            if (operate == 0) {
                saveFile();
                flag = checkSave();
            } else if (operate == 1) {
                System.exit(0);
            } else {
                cancel = true;
            }
        } else {
            System.exit(0);
        }
        if (flag && !cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new MyNote();
    }
}
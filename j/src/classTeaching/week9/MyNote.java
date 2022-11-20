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
 * ���±�Ӧ�ó����� {@code MyNote}
 * @author Kim Jackson (JinLei)
 */
@SuppressWarnings("all")
public class MyNote extends JFrame implements ActionListener {
    JTextArea txt;//�������ı���
    JMenuItem newFile, openFile, saveFile, saveOtherFile, exitMenu, drawBack, cut, copy, paste, delete,
            find, replace, allSelect, date, font, bigger, smaller, resDefault, help, about;//���в˵���
    JCheckBoxMenuItem wrapLine, siuBar;//�Զ����к�״̬��
    JMenu magnify;//���ж����˵�
    JScrollPane sp;//ʵ�ֹ���
    JLabel sitbarLable;//״̬��
    boolean isSaved = true;//�ж��ļ��Ƿ��ڱ���״̬
    boolean openIsSeleced = false;//�ж��ļ�ѡ�񴰿��Ƿ��Ѿ������Ѿ�������ļ�
    JFileChooser open;//���ļ�����
    JFileChooser save = new JFileChooser();//�����ļ�����
    UndoManager um;//����������
    JDialog findDialog = new JDialog(this, "����", false);//�����ҡ�����
    JDialog replaceDialog = new JDialog(this, "�滻", false);//���滻������
    JDialog fontSettingDialog;//�������ô���
    JTextField findString1, findString2, replaceString;//�����ҡ��͡��滻�������е��ı���
    JButton findNext1, findNext2, replaceNext, replaceAll, fontChange, fontCancel, cancel1, cancel2;//�����ҡ��͡��滻�������еİ�ť
    JComboBox<String> fontName, fontStyle;//�������ƺ�������ʽѡ���
    JComboBox<Integer> fontSize;//�����Сѡ���

    public MyNote() {//��ʼ�����ڡ��˵���JTextArea������Ӳ�ע�ᴰ�ں�JTextField�ļ�����
        JMenuBar mb = new JMenuBar();
        makeMenu(mb);
        this.setJMenuBar(mb);
        sitbarLable = new JLabel("׼������");
        sitbarLable.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        sitbarLable.setHorizontalAlignment(SwingConstants.RIGHT);
        txt = new JTextArea();
        txt.setFont(new Font("����", Font.PLAIN, 22));
        txt.setWrapStyleWord(true);
        txt.getDocument().addDocumentListener(new CheckChanged());
        txt.addFocusListener(new CheckMenuAvalible());
        um = new UndoManager();
        txt.getDocument().addUndoableEditListener(new Drawback());
        sp = new JScrollPane(txt);
        this.addWindowListener(new WindowAdapter() {//����༭���������ݣ���ֹ��ֱ�ӹر�
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
        this.setIconImage(new ImageIcon(MyNote.class.getResource("icon.png")).getImage());
        this.setLayout(new BorderLayout(5, 5));
        this.add(sp, BorderLayout.CENTER);
        this.add(sitbarLable, BorderLayout.SOUTH);
        this.setTitle("���±�");
        this.setSize(1000, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void makeMenu(JMenuBar mb) {//�����˵���˵����Ϊ��ע�������
        JMenu fileMenu = new JMenu("�ļ�(F)");
        JMenu editMenu = new JMenu("�༭(E)");
        JMenu formatMenu = new JMenu("��ʽ(F)");
        JMenu viewMenu = new JMenu("�鿴(V)");
        JMenu helpMenu = new JMenu("����(H)");
        newFile = new JMenuItem("�½�(N)", 'N');
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newFile.addActionListener(this);
        openFile = new JMenuItem("��(O)", 'O');
        openFile.addActionListener(this);
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveFile = new JMenuItem("����(S)", 'S');
        saveFile.addActionListener(this);
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveOtherFile = new JMenuItem("���Ϊ(A)", 'A');
        saveOtherFile.addActionListener(this);
        saveOtherFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK | ActionEvent.CTRL_MASK));
        exitMenu = new JMenuItem("�˳�(X)", 'X');
        exitMenu.addActionListener(this);
        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(saveOtherFile);
        fileMenu.addSeparator();
        fileMenu.add(exitMenu);

        drawBack = new JMenuItem("����(U)", 'U');
        drawBack.addActionListener(this);
        drawBack.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        cut = new JMenuItem("����(T)", 'T');
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        copy = new JMenuItem("����(C)", 'C');
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        paste = new JMenuItem("ճ��(P)", 'P');
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        delete = new JMenuItem("ɾ��(D)", 'D');
        delete.addActionListener(this);
        delete.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_DELETE));//���������˿�ݼ�Delete�������ڲ˵��в���ʾ
        find = new JMenuItem("����(F)", 'F');
        find.addActionListener(this);
        find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        replace = new JMenuItem("�滻(R)", 'R');
        replace.addActionListener(this);
        replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        allSelect = new JMenuItem("ȫѡ(A)", 'A');
        allSelect.addActionListener(this);
        allSelect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        date = new JMenuItem("����/ʱ��(D)", 'D');
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

        wrapLine = new JCheckBoxMenuItem("�Զ�����(W)", false);
        wrapLine.addItemListener(new CheckState());
        font = new JMenuItem("����(F)", 'F');
        font.addActionListener(this);
        formatMenu.add(wrapLine);
        formatMenu.add(font);

        magnify = new JMenu("����(Z)");
        bigger = new JMenuItem("�Ŵ�(I)", 'I');
        bigger.addActionListener(this);
        smaller = new JMenuItem("��С(O)", 'O');
        smaller.addActionListener(this);
        resDefault = new JMenuItem("�ָ�Ĭ������");
        resDefault.addActionListener(this);
        magnify.add(bigger);
        magnify.add(smaller);
        magnify.add(resDefault);

        siuBar = new JCheckBoxMenuItem("״̬��(S)", true);
        siuBar.addItemListener(new CheckState());
        viewMenu.add(magnify);
        viewMenu.add(siuBar);

        help = new JMenuItem("�鿴����(H)", 'H');
        help.addActionListener(this);
        about = new JMenuItem("���ڼ��±�(A)", 'A');
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
    public void actionPerformed(ActionEvent e) {//�������������в˵����롰���ҡ������滻���������塱�����еİ�ť
        if (e.getSource() == newFile) {//�½�
            if (!isSaved) {
                boolean flag = true;
                int operate = showSaveConfirmDialog();//�򿪱���ȷ�ϴ���
                if (operate == JOptionPane.YES_OPTION) {//���������ǣ��ʹ򿪱����ļ�ѡ�񴰿�
                    save.setDialogTitle("����");
                    saveFile();
                    flag = checkSave();
                    if (flag) {//��������쳣��˵��û��ѡ���ļ���Ҳ�������������
                        txt.setText("");
                        MyNote.this.setTitle("���±�");
                        sitbarLable.setText("���½��ļ���");
                    }
                }else{
                    txt.setText("");
                    isSaved = true;//ÿ���½����ж��Ѿ�����
                    MyNote.this.setTitle("���±�");
                    sitbarLable.setText("���½��ļ���");
                }
            } else {
                txt.setText("");
                isSaved = true;
                MyNote.this.setTitle("���±�");
                sitbarLable.setText("���½��ļ���");
            }
        } else if (e.getSource() == openFile) {//��
            boolean flag = true;
            if (!isSaved) {
                int operate = showSaveConfirmDialog();//�򿪱���ȷ�ϴ���
                if (operate == JOptionPane.YES_OPTION) {//���������ǣ��ȱ����ļ��ٴ��ļ�
                    save.setDialogTitle("����");
                    saveFile();
                    flag = checkSave();
                    if (flag) {//������ļ�ѡ�񴰿ڵ����ȡ�����򲻻�������ļ�
                        openFile();
                        flag = checkOpen();
                    }
                } else {//�������˷�ֱ�Ӵ��ļ�
                    openFile();
                    flag = checkOpen();
                }
            } else {
                openFile();
                flag = checkOpen();
            }
            if (flag) {
                sitbarLable.setText("�Ѵ��ļ�:" + open.getSelectedFile().getAbsolutePath());
            }
        } else if (e.getSource() == saveFile) {//����
            if(!isSaved){
                boolean flag = true;
                save.setDialogTitle("����");
                saveFile();
                flag = checkSave();
                if (flag) {
                    isSaved = true;
                    sitbarLable.setText(save.getSelectedFile().getName() + ".txt�ѱ��浽��̨���ԡ�");
                    MyNote.this.setTitle(save.getSelectedFile().getName() + ".txt - ���±�");
                }
            }
        } else if (e.getSource() == exitMenu) {//�˳�
            exit();
        } else if (e.getSource() == saveOtherFile) {//���Ϊ
            boolean flag = true;
            save.setDialogTitle("���Ϊ");
            saveFile();
            flag = checkSave();
            if (flag) {
                isSaved = true;
                sitbarLable.setText(save.getSelectedFile().getName() + ".txt�ѱ��浽��̨���ԡ�");
                MyNote.this.setTitle(save.getSelectedFile().getName() + ".txt - ���±�");
            }
        } else if (e.getSource() == drawBack) {//����
            if (um.canUndo()) {
                um.undo();
            }
        } else if (e.getSource() == cut) {//����
            txt.cut();
            sitbarLable.setText("�ѽ�ѡ�������ƶ��������塣");
        } else if (e.getSource() == copy) {//����
            txt.copy();
            sitbarLable.setText("�ѽ�ѡ�����ݸ��Ƶ������塣");
        } else if (e.getSource() == paste) {//ճ��
            txt.paste();
            sitbarLable.setText("�ѽ��������е�����ճ������ǰλ�á�");
        } else if (e.getSource() == find) {//����
            showFindDialog();
        } else if (e.getSource() == delete) {//ɾ��
            txt.replaceSelection("");
            sitbarLable.setText("��ɾ��ѡ�����ݡ�");
        } else if (e.getSource() == findNext1) {//�����ҡ������еġ�������һ������ť
            findNextMethod();
        } else if (e.getSource() == cancel1) {//�����ҡ������еġ�ȡ������ť
            findDialog.dispose();
        } else if (e.getSource() == cancel2) {//���滻�������еġ�ȡ������ť
            replaceDialog.dispose();
        } else if (e.getSource() == replace) {//�滻
            showReplaceDialog();
        } else if (e.getSource() == findNext2) {//���滻�������еġ�������һ������ť
            findMethodInReplace();
        } else if (e.getSource() == replaceNext) {//���滻�������еġ��滻����ť
            replaceMethod();
        } else if (e.getSource() == replaceAll) {//���滻�������еġ�ȫ���滻����ť
            replaceAllMethod();
        } else if (e.getSource() == allSelect) {//ȫѡ
            txt.selectAll();
            sitbarLable.setText("��ѡ���������ݡ�");
        } else if (e.getSource() == date) {//����/ʱ��
            txt.insert(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()), txt.getSelectionEnd());
            sitbarLable.setText("�ѽ�ϵͳʱ����뵽��ǰλ�á�");
        } else if (e.getSource() == font) {//����
            showFontDialog();
        } else if (e.getSource() == fontCancel) {//�����塱���ڵġ�ȡ������ť
            fontSettingDialog.dispose();
        } else if (e.getSource() == fontChange) {//�����塱���ڵġ�ȷ������ť
            fontChangeMethod();
        } else if (e.getSource() == bigger) {//���š��Ŵ�
            txt.setFont(new Font(txt.getFont().getFontName(), txt.getFont().getStyle(), txt.getFont().getSize() + 5));
            sitbarLable.setText("�Ŵ󡣵�ǰ�����С��"+txt.getFont().getSize());
        } else if (e.getSource() == smaller) {//���š���С
            txt.setFont(new Font(txt.getFont().getFontName(), txt.getFont().getStyle(), txt.getFont().getSize() - 5));
            sitbarLable.setText("��С����ǰ�����С��"+txt.getFont().getSize());
        } else if (e.getSource() == resDefault) {//���š��ָ�Ĭ������
            txt.setFont(new Font(txt.getFont().getFontName(), txt.getFont().getStyle(), 22));
            sitbarLable.setText("�ѻָ�Ĭ�������С��22");
        } else if (e.getSource() == help) {//�鿴����
            JOptionPane.showMessageDialog(this, "�������֣��������岢��.txt�ı��ĵ����浽��̨�����ϡ�", "����", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == about) {//����
            showAboutDialog();
        }
    }

    public void saveFile() {//�����ļ�
        save.setFileSelectionMode(JFileChooser.FILES_ONLY);//����ֻ��ѡ���ļ�
        save.setFileFilter(new FileNameExtensionFilter("txt�ļ�", "txt"));//�����ļ���չ��������
        save.showSaveDialog(this);//��ʾ���洰��
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

    public void openFile() {//���ļ�
        openIsSeleced = true;
        open = new JFileChooser();
        open.setFileFilter(new FileNameExtensionFilter("txt�ļ�", "txt"));
        open.setFileSelectionMode(JFileChooser.FILES_ONLY);
        open.showOpenDialog(this);//��ʾ�򿪴���
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
                this.setTitle(open.getSelectedFile().getName() + " - ���±�");
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

    public int showSaveConfirmDialog() {//����ȷ�ϴ���
        return JOptionPane.showConfirmDialog(this, "�Ƿ񱣴������ļ���", "����",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    class CheckChanged implements DocumentListener {//����ı��������Ƿ�ı�ĳ�Ա�ڲ���

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
            if (isSaved) {//����ļ��ѱ���
                isSaved = false;//���ָı䣬����ʧЧ
                openIsSeleced = false;//���ⲿ�ļ���༭���ļ������Ѿ����Ǵ��ⲿ�򿪵��ļ�
            }
            if (openIsSeleced) {//����ļ����ⲿ�򿪣���Ĭ�ϴ��ڱ���״̬
                isSaved = true;
            }
            if (!isSaved) {//�������δ����״̬
                titleAddStar();
            } else {//������ڱ���״̬
                titleDelStar();
            }
        }
    }

    class Drawback implements UndoableEditListener {//ʵ�ֳ������ܵĳ�Ա�ڲ���

        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            um.addEdit(e.getEdit());
        }
    }

    class CheckMenuAvalible extends FocusAdapter {//���˵����Ƿ���õĳ�Ա�ڲ���

        @Override
        public void focusLost(FocusEvent e) {
            if (txt.getSelectedText() == null) {//���ûѡ���ı����е��κ����ݣ������С�����ճ�����������Ʋ˵������
                cut.setEnabled(false);
                copy.setEnabled(false);
                delete.setEnabled(false);
            } else {
                cut.setEnabled(true);
                copy.setEnabled(true);
                delete.setEnabled(true);
            }

            if (txt.getText().isEmpty()) {//����ı���Ϊ�գ������ҡ������滻���˵������
                find.setEnabled(false);
                replace.setEnabled(false);
            } else {
                find.setEnabled(true);
                replace.setEnabled(true);
            }

            //������Բ��ܳ��������������˵������
            drawBack.setEnabled(um.canUndo());
            //����������if����ֹ���Һ��滻���ڱ��򿪶�Σ��������һ�����򿪣���һ���˵���ͻ᲻����
            if (findDialog.isShowing()) {
                find.setEnabled(false);
            }

            if (replaceDialog.isShowing()) {
                replace.setEnabled(false);
            }
        }
    }

    public void showFindDialog() {//���Ҵ���
        if (replaceDialog.isShowing()) {//���Ҵ����Ѿ��򿪣�����滻�����ٴα��򿪣�ֱ�ӹر�
            replaceDialog.dispose();
        }
        findDialog = new JDialog(this, "����", false);
        findDialog.setLayout(null);

        JLabel jl = new JLabel("��������(N):");
        jl.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        jl.setBounds(10, 10, 100, 50);
        findDialog.add(jl);

        findString1 = new JTextField(35);
        findString1.setBounds(90, 25, 200, 25);
        findString1.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        findDialog.add(findString1);

        findNext1 = new JButton("������һ��(F)");
        findNext1.setEnabled(false);
        findNext1.setPreferredSize(new Dimension(115, 30));
        findNext1.setBounds(300, 23, 110, 30);
        findNext1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        findNext1.addActionListener(this);
        findDialog.add(findNext1);

        cancel1 = new JButton("ȡ��");
        cancel1.setBounds(300, 60, 110, 30);
        cancel1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        cancel1.setPreferredSize(new Dimension(115, 30));
        cancel1.addActionListener(this);
        findDialog.add(cancel1);

        findDialog.setSize(445, 155);
        findDialog.setVisible(true);
        findDialog.setResizable(false);
        findDialog.setLocationRelativeTo(this);
        findDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void showReplaceDialog() {//��ʾ�滻����
        if (findDialog.isShowing()) {//�滻�����Ѿ��򿪣�������Ҵ����ٴα��򿪣�ֱ�ӹر�
            findDialog.dispose();
        }
        replaceDialog = new JDialog(this, "�滻", false);
        replaceDialog.setLayout(null);
        JLabel jl = new JLabel("��������(N):");
        jl.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        jl.setBounds(10, 10, 100, 50);
        replaceDialog.add(jl);

        findString2 = new JTextField(35);
        findString2.setBounds(90, 25, 200, 25);
        findString2.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        replaceDialog.add(findString2);

        findNext2 = new JButton("������һ��(F)");
        findNext2.setPreferredSize(new Dimension(115, 30));
        findNext2.setBounds(300, 23, 110, 30);
        findNext2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        findNext2.setEnabled(false);
        findNext2.addActionListener(this);
        replaceDialog.add(findNext2);

        JLabel j2 = new JLabel("�滻Ϊ(P):");
        j2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        j2.setBounds(10, 46, 100, 50);
        replaceDialog.add(j2);
        replaceString = new JTextField(35);
        replaceString.setBounds(90, 61, 200, 25);
        replaceString.getDocument().addDocumentListener(new CheckFindAndReplaceString());
        replaceDialog.add(replaceString);

        replaceNext = new JButton("�滻(R)");
        replaceNext.setPreferredSize(new Dimension(115, 30));
        replaceNext.setEnabled(false);
        replaceNext.setBounds(300, 57, 110, 30);
        replaceNext.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        replaceNext.addActionListener(this);
        replaceDialog.add(replaceNext);

        replaceAll = new JButton("ȫ���滻(A)");
        replaceAll.setPreferredSize(new Dimension(115, 30));
        replaceAll.setEnabled(false);
        replaceAll.setBounds(300, 91, 110, 30);
        replaceAll.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        replaceAll.addActionListener(this);
        replaceDialog.add(replaceAll);

        cancel2 = new JButton("ȡ��");
        cancel2.setBounds(300, 125, 110, 30);
        cancel2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        cancel2.setPreferredSize(new Dimension(115, 30));
        cancel2.addActionListener(this);
        replaceDialog.add(cancel2);

        replaceDialog.setSize(445, 215);
        replaceDialog.setVisible(true);
        replaceDialog.setResizable(false);
        replaceDialog.setLocationRelativeTo(this);
        replaceDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void findNextMethod() {//ʵ�֡����ҡ����ڵġ�������һ������ť
        String temp = txt.getText();
        if (txt.getSelectionEnd() == txt.getText().length()) {//����ı����б�ѡ�����ֵĽ�β�Ѿ����ı������������ֵĽ�β��������ƶ�����ͷ
            txt.setCaretPosition(0);
        }
        if (temp.contains(findString1.getText())) {//����ı����а������ҵ��ı�
            for (int i = txt.getSelectionEnd(); i <= temp.length() - findString1.getText().length(); i++) {//ö��������ı��ĳ�����ͬ�������Ӵ�����Χ�Ǳ�ѡ�е����ֵĽ�β���������ֵĽ�β��
                if (findString1.getText().equals(temp.substring(i, i + findString1.getText().length()))) {//����Ӵ�������ı�ƥ��
                    txt.select(i, i + findString1.getText().length());//ѡ��ƥ�������
                    break;//ÿ�ΰ�˳�����һ��ƥ����
                }
                if (temp.lastIndexOf(findString1.getText()) == txt.getSelectionStart() || //����Ѿ����ҵ����һ����ƥ�䵽���ı�
                        !txt.getText().substring(txt.getSelectionEnd()).contains(findString1.getText())) {//���ߴ����һ��ƥ�䵽���ı����ı����β������ƥ���ı�ʱ��(��д�����ʱ�����Զ���ת����ͷ)
                    txt.setCaretPosition(temp.indexOf(findString1.getText()));//������ƶ�����һ����ƥ�䵽���ı���ʵ��ѭ��
                }
            }
        } else {//����Ҳ�����������ʾ
            JOptionPane.showMessageDialog(find, "�Ҳ�����" + findString2.getText() + "��", "���±�", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void findMethodInReplace() {//ʵ�֡��滻�����ڵġ����ҡ���ť
        String temp = txt.getText();//������Ĳ��ҹ�����ͬ
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
            JOptionPane.showMessageDialog(find, "�Ҳ���" + "��" + findString2.getText() + "��", "���±�", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void replaceMethod() {//ʵ�֡��滻�����ڵġ��滻����ť
        String s = replaceString.getText();
        findMethodInReplace();//׼���滻ͨ�����Ҷ���ѡ���ı�
        if (txt.getSelectedText() != null) {//ֻҪ��ѡ���ı��ǿվͽ����滻
            txt.replaceSelection(s);
        }
    }

    class CheckState implements ItemListener {//�����и�ѡ���ܵĲ˵���״̬�ĳ�Ա�ڲ���

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (siuBar.getState()) {//��顰״̬�����˵��Ƿ�ѡ��
                MyNote.this.add(sitbarLable, BorderLayout.PAGE_END);
            } else {
                MyNote.this.remove(sitbarLable);
            }
            MyNote.this.txt.setLineWrap(wrapLine.getState());//��顰�Զ����С��˵��Ƿ�ѡ��
            MyNote.this.validate();//ÿ�θı䴰�ڸ�������֣�����ͨ���������ˢ�´��ڣ�ʹ����Ч
        }
    }

    class CheckFindAndReplaceString implements DocumentListener {//��顰���ҡ��͡��滻�������а�ť�Ŀ����Եĳ�Ա�ڲ���

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

        public void change() {//�ڡ����ҡ��͡��滻���������ı���ǿ�״̬�£������еİ�ť�ſ���
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

    public void replaceAllMethod() {//���滻�������еġ�ȫ���滻����ť
        if (txt.getText().contains(findString2.getText())) {//����ı������Ҫ�滻���ı�
            txt.setText(txt.getText().replace(findString2.getText(), replaceString.getText()));//���ı����е��ı����ó��滻����ı�
        } else {
            JOptionPane.showMessageDialog(replaceDialog, "�Ҳ�����" + findString2.getText() + "��", "���±�", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void showFontDialog() {//���崰��
        //��������ʹ��JDialog���вι��췽�����޷����ûỰ����е����⣬������Ӧ�����趨����λ�ã���������ɼ���
        fontSettingDialog = new JDialog(this, "����", true);
        JPanel whole = new JPanel();
        JPanel jp = new JPanel(new GridLayout());

        JPanel fontNamejp = new JPanel();
        JLabel fontlabel1 = new JLabel("����(F):");
        fontlabel1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        Font f = txt.getFont();
        fontName = new JComboBox<>();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//���ر���ͼ�λ�������
        String[] fontNames = ge.getAvailableFontFamilyNames();//��ȡ���������
        fontName.setModel(new DefaultComboBoxModel(fontNames));
        fontName.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        fontName.setPreferredSize(new Dimension(180, 25));
        fontName.setSelectedItem(f.getFontName());//�򿪴���ʱֱ�ӻ�ȡ�ı����������
        fontNamejp.add(fontlabel1);
        fontNamejp.add(fontName);
        jp.add(fontNamejp);
        jp.add(fontNamejp);

        JPanel fontStylejp = new JPanel();
        JLabel fontlabel2 = new JLabel("����(Y):");
        fontlabel2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        fontStyle = new JComboBox<>();
        String[] fontStyles = {"����", "����", "б��", "��б��"};
        fontStyle.setModel(new DefaultComboBoxModel(fontStyles));
        fontStyle.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        fontStyle.setPreferredSize(new Dimension(180, 25));
        fontStyle.setSelectedIndex(f.getStyle());//�򿪴���ʱֱ�ӻ�ȡ�ı��������
        fontStylejp.add(fontlabel2);
        fontStylejp.add(fontStyle);
        jp.add(fontStylejp);

        JPanel fontSizejp = new JPanel();
        JLabel fontlabel3 = new JLabel("��С(S):");
        fontlabel3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        fontSize = new JComboBox<>();
        String[] fontSizes = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
        fontSize.setModel(new DefaultComboBoxModel(fontSizes));
        fontSize.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        fontSize.setPreferredSize(new Dimension(180, 25));
        fontSize.setEditable(true);//���������JCombox����ɱ༭����һ�д��벻������
        fontSize.setSelectedItem(f.getSize());//�򿪴���ʱֱ�ӻ�ȡ�ı���������С
        fontSizejp.add(fontlabel3);
        fontSizejp.add(fontSize);
        jp.add(fontSizejp);
        whole.add(jp, BorderLayout.NORTH);

        JPanel button = new JPanel();
        fontChange = new JButton("ȷ��");
        fontChange.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        fontChange.setPreferredSize(new Dimension(80, 30));
        fontChange.addActionListener(this);
        fontCancel = new JButton("ȡ��");
        fontCancel.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        fontCancel.setPreferredSize(new Dimension(80, 30));
        fontCancel.addActionListener(this);
        button.add(new JLabel("                                                                                   "));
        button.add(fontChange);
        button.add(fontCancel);
        whole.add(button, BorderLayout.LINE_END);

        fontSettingDialog.add(whole);
        fontSettingDialog.setSize(750, 135);
        fontSettingDialog.setResizable(false);
        fontSettingDialog.setLocationRelativeTo(this);//�����ô���λ�þ���
        fontSettingDialog.setVisible(true);//�����ô��ڿɼ��ԣ�����ʹJDialog���ھ���
        fontSettingDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void fontChangeMethod() {//�����塱���ڵġ�ȷ�ϡ���ť
        int style = 0;//�洢������ʽ
        if (fontStyle.getSelectedItem().equals("����")) {
            style = Font.PLAIN;
        } else if (fontStyle.getSelectedItem().equals("б��")) {
            style = Font.ITALIC;
        } else if (fontStyle.getSelectedItem().equals("����")) {
            style = Font.BOLD;
        } else if (fontStyle.getSelectedItem().equals("��б��")) {
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
                JOptionPane.showMessageDialog(this, "�����С���ô���999999��", "���±�", JOptionPane.ERROR_MESSAGE);
                fontSize.setSelectedItem(999999);
            }
        } else {
            JOptionPane.showMessageDialog(this, "�����С����С��0��", "���±�", JOptionPane.ERROR_MESSAGE);
            fontSize.setSelectedItem(1);
        }
    }

    public void showAboutDialog() {//��ʾ���ڴ���
        JDialog aboutDialog = new JDialog(this, "���ڼ��±�", true);
        aboutDialog.setLayout(null);//��Ҫ�Զ��崰�ڸ���������֣����Բ�ʹ���κβ��ֹ�����
        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon(MyNote.class.getResource("headPics.png")));
        pic.setBounds(20, 20, 128, 128);
        JLabel author = new JLabel();
        author.setIcon(new ImageIcon(MyNote.class.getResource("name.png")));
        author.setBounds(220, 20, 144, 93);
        aboutDialog.add(author);
        aboutDialog.add(pic);
        JTextArea data = new JTextArea("""
                ���±� �汾1.0
                ������2022��5��3��
                ��������ϵ����(Kim Jackson(JinLei))
                Copyright 2001-2022
                JiangXi University of Technology""");
        data.setEditable(false);
        data.setBackground(new Color(240, 240, 240));
        data.setBounds(200, 120, 300, 100);
        data.setFont(new Font("΢���ź�", Font.PLAIN, 12));
        aboutDialog.add(data);
        aboutDialog.setSize(450, 270);
        aboutDialog.setResizable(false);//��仰����д��setSize()����֮��
        aboutDialog.setLocationRelativeTo(this);
        aboutDialog.setVisible(true);
        aboutDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public boolean checkSave() {//����Ƿ�����ڱ��洰���е���ˡ�ȡ���������
        try {
            save.getSelectedFile().getAbsolutePath();//�������ȡ��ѡ���ļ���·�����׳�NullPointerException
        } catch (NullPointerException ex) {//�����쳣˵����ȡ������ť�����
            return false;
        }
        return true;
    }

    public boolean checkOpen() {//����Ƿ�����ڴ򿪴����е���ˡ�ȡ�������������checkSave()������ͬ
        try {
            open.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException ex) {
            return false;
        }
        return true;
    }

    public void titleAddStar(){//Ϊ���⿪ͷ����*
        if (!MyNote.this.getTitle().startsWith("*")) {
            MyNote.this.setTitle("*" + MyNote.this.getTitle());
        }
    }

    public void titleDelStar(){//ɾ�����⿪ͷ��*
        if (MyNote.this.getTitle().startsWith("*")) {
            MyNote.this.setTitle(MyNote.this.getTitle().substring(1));
        }
    }

    public void exit(){//�����˳�����
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
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//����ϵͳ���
        MyNote win = new MyNote();
    }
}
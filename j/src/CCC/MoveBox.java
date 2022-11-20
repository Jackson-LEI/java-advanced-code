package CCC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class MoveBox extends JFrame{
    //�˵���
    JMenuBar jmb;
    //�˵�
    JMenu[] jm;
    //�˵���
    JMenuItem[] jmi;
    //����
    JLabel[] jl;
    Color Road;
    //�ˡ����ӡ�Ŀ������
    int[] people,box,des;
    //����ĳ���
    int row,col;
    //�ˡ����ӡ�Ŀ����ʽ
    Icon People, Box, Wall, Des;
    //ǽ��λ�ü���
    Set<Integer> wallLocal = new HashSet<>();
    //ͼƬ
    String peoPath, boxPath,wallPath,desPath;

    //���췽��
    public MoveBox(int row, int col){
        this.row = row;
        this.col = col;
        //���ò���
        this.setLayout(new GridLayout(row,col,5,5));
        this.setBackground(Color.black);
        //�����˵�
        createMenu();
        //�������壬��ɫ
        createItem();
        //��Ӽ��̼���
        keyListen();
        //����ҳ��
        createInf();
        //���ô��ڸ�ʽ
        this.setVisible(true);
        this.setIconImage(new ImageIcon("img//icon.jpg").getImage());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //�����˵�
    private void createMenu() {
        //�˵�����
        //�˵���
        jmb = new JMenuBar();
        //�˵�
        String[] menuName = {"��Ϸ","����"};
        jm = new JMenu[menuName.length];
        for(int i=0;i<menuName.length;i++){
            jm[i] = new JMenu(menuName[i]);
        }
        //�˵���
        String[] itemName = {"���¿�ʼ","�˳�","��Ϸ�淨","����"};
        //���˵�����ӵ���Ӧ�˵���
        jmi = new JMenuItem[itemName.length];
        for(int i=0;i<itemName.length;i++){
            jmi[i] = new JMenuItem(itemName[i]);
            if(i<2){
                jm[0].add(jmi[i]);
            }else{
                jm[1].add(jmi[i]);
            }
        }

        //��ӿ�ݼ�
        jmi[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        //���˵����뵽�˵���
        for(int i=0;i<2;i++){
            jmb.add(jm[i]);
        }
        //�����˵���ļ���
        restart();
        exit();
        this.setJMenuBar(jmb);
    }
    //���¿�ʼ
    private void restart() {
        jmi[0].addActionListener(e-> createInf());
    }
    //�˳�
    private void exit(){
        jmi[1].addActionListener(e->System.exit(0));
    }
    //�������ǽ
    public void randomWall(int cnt){
        Set<Integer> set = new HashSet<>();
        while(set.size()<cnt){
            int ran = (int) (Math.random()*row*col);
            set.add(ran);
        }
        wallLocal.addAll(set);
        people = new int[3];
        box = new int[2];
        des = new int[2];
    }
    //��������ˡ����ӡ�Ŀ�ĵ�
    public void randomItem(int[] a,Set<Integer> set){
        int len = set.size();
        while(set.size()<len+1){
            int ran = (int) (Math.random()*row*col);
            //x*col+y==ran
            int x = ran/col;
            int y = ran-x*col;
            if(x>0&&y>0&&x<row-1&&y<col-1&&set.add(ran)){
                a[0] = x;
                a[1] = y;
            }
        }
    }
    //�������
    private void createItem() {
        peoPath = "img//people.png";
        boxPath = "img//box.jpg";
        wallPath = "img//wall.gif";
        desPath = "img//des.png";

        Wall = new ImageIcon(wallPath);
        People = new ImageIcon(peoPath);
        Box = new ImageIcon(boxPath);
        Des = new ImageIcon(desPath);
        Road = Color.white;
    }

    //��������
    private void createInf() {
        //�����ͼ
        try {
            for (JLabel e : jl) {
                this.remove(e);
            }
            wallLocal.clear();
        }catch (NullPointerException ignored){}
        randomWall(row*col/4);
        //��ʼ����ǩ
        jl = new JLabel[row*col];
        for(int i=0;i<jl.length;i++){
            jl[i] = new JLabel("");
            jl[i].setName(i+"");
            jl[i].setOpaque(true);
            jl[i].setBackground(Road);
            this.add(jl[i]);
        }
        //���ǽ���ˡ����ӡ�Ŀ�ĵ�
        createWall();
        setPeople(people);
        setBox(box);
        setDes();
    }
    //�ƶ�
    public void moved(int x, int y){
        if(!in(people[0]+x, people[1]+y)){
            return;
        }

        if(people[0]+x==box[0]&&people[1]+y==box[1]){
            if(!in(box[0]+x,box[1]+y)){
                return;
            }
            setRoad(people);
            people[0] += x;
            people[1] += y;
            setPeople(people);
            box[0] += x;
            box[1] += y;
            setBox(box);
            if(box[0]==des[0]&&box[1]==des[1]){
                int flag = JOptionPane.showConfirmDialog(null,"�Ƿ����¿�ʼ��","��Ӯ�ˣ�",JOptionPane.YES_NO_OPTION);
                if(flag==0){
                    createInf();
                }
            }
        }else {
            setRoad(people);
            people[0] += x;
            people[1] += y;
            setPeople(people);
        }
    }
    //����(a[0],a[1])λ��Ϊ��
    public void setPeople(int[] a){
//        jl[a[0]*col+a[1]].setBackground(People);
        jl[a[0]*col+a[1]].setIcon(People);
    }
    //����(a[0],a[1])λ��Ϊ·
    public void setRoad(int[] a){
        if(a[0]==des[0]&&a[1]==des[1]){
            jl[a[0]*col+a[1]].setIcon(Des);
        }else {
            jl[a[0]*col+a[1]].setBackground(Road);
            jl[a[0]*col+a[1]].setIcon(null);
        }
    }
    //����(a[0],a[1])λ��Ϊ����
    public void setBox(int[] a){
//        jl[a[0]*col+a[1]].setBackground(Box);
        jl[a[0]*col+a[1]].setIcon(Box);
    }
    //����ǽ
    private void createWall() {
        for(int e:wallLocal){
            jl[e].setIcon(Wall);
        }
    }
    //����Ŀ�ĵ�
    private void setDes(){
        jl[des[0]*col+des[1]].setIcon(Des);
    }
    //�ж��Ƿ�ײǽ
    public boolean in(int x,int y){
        return x >= 0 && y >= 0 && x < row && y < col && !wallLocal.contains(x * col + y);
    }
    //���̼�����
    private void keyListen() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                switch (ch){
                    case 'W':
                    case 'w':
                        moved(-1,0);
                        break;
                    case 'A':
                    case 'a':
                        moved(0,-1);
                        break;
                    case 'S':
                    case 's':
                        moved(1,0);
                        break;
                    case 'D':
                    case 'd':
                        moved(0,1);
                        break;
                }
            }
        });
    }

    //������
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new MoveBox(8,8);
    }
}

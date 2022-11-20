package CCC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

public class MoveBox extends JFrame{
    //菜单条
    JMenuBar jmb;
    //菜单
    JMenu[] jm;
    //菜单项
    JMenuItem[] jmi;
    //格子
    JLabel[] jl;
    Color Road;
    //人、箱子、目的坐标
    int[] people,box,des;
    //界面的长宽
    int row,col;
    //人、箱子、目的样式
    Icon People, Box, Wall, Des;
    //墙的位置集合
    Set<Integer> wallLocal = new HashSet<>();
    //图片
    String peoPath, boxPath,wallPath,desPath;

    //构造方法
    public MoveBox(int row, int col){
        this.row = row;
        this.col = col;
        //设置布局
        this.setLayout(new GridLayout(row,col,5,5));
        this.setBackground(Color.black);
        //创建菜单
        createMenu();
        //设置字体，颜色
        createItem();
        //添加键盘监听
        keyListen();
        //创建页面
        createInf();
        //设置窗口格式
        this.setVisible(true);
        this.setIconImage(new ImageIcon("img//icon.jpg").getImage());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //创建菜单
    private void createMenu() {
        //菜单字体
        //菜单条
        jmb = new JMenuBar();
        //菜单
        String[] menuName = {"游戏","帮助"};
        jm = new JMenu[menuName.length];
        for(int i=0;i<menuName.length;i++){
            jm[i] = new JMenu(menuName[i]);
        }
        //菜单项
        String[] itemName = {"重新开始","退出","游戏玩法","关于"};
        //将菜单项添加到对应菜单中
        jmi = new JMenuItem[itemName.length];
        for(int i=0;i<itemName.length;i++){
            jmi[i] = new JMenuItem(itemName[i]);
            if(i<2){
                jm[0].add(jmi[i]);
            }else{
                jm[1].add(jmi[i]);
            }
        }

        //添加快捷键
        jmi[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        //将菜单加入到菜单条
        for(int i=0;i<2;i++){
            jmb.add(jm[i]);
        }
        //创建菜单项的监听
        restart();
        exit();
        this.setJMenuBar(jmb);
    }
    //重新开始
    private void restart() {
        jmi[0].addActionListener(e-> createInf());
    }
    //退出
    private void exit(){
        jmi[1].addActionListener(e->System.exit(0));
    }
    //产生随机墙
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
    //产生随机人、箱子、目的地
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
    //创建零件
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

    //创建界面
    private void createInf() {
        //随机地图
        try {
            for (JLabel e : jl) {
                this.remove(e);
            }
            wallLocal.clear();
        }catch (NullPointerException ignored){}
        randomWall(row*col/4);
        //初始化标签
        jl = new JLabel[row*col];
        for(int i=0;i<jl.length;i++){
            jl[i] = new JLabel("");
            jl[i].setName(i+"");
            jl[i].setOpaque(true);
            jl[i].setBackground(Road);
            this.add(jl[i]);
        }
        //添加墙、人、箱子、目的地
        createWall();
        setPeople(people);
        setBox(box);
        setDes();
    }
    //移动
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
                int flag = JOptionPane.showConfirmDialog(null,"是否重新开始？","你赢了！",JOptionPane.YES_NO_OPTION);
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
    //设置(a[0],a[1])位置为人
    public void setPeople(int[] a){
//        jl[a[0]*col+a[1]].setBackground(People);
        jl[a[0]*col+a[1]].setIcon(People);
    }
    //设置(a[0],a[1])位置为路
    public void setRoad(int[] a){
        if(a[0]==des[0]&&a[1]==des[1]){
            jl[a[0]*col+a[1]].setIcon(Des);
        }else {
            jl[a[0]*col+a[1]].setBackground(Road);
            jl[a[0]*col+a[1]].setIcon(null);
        }
    }
    //设置(a[0],a[1])位置为箱子
    public void setBox(int[] a){
//        jl[a[0]*col+a[1]].setBackground(Box);
        jl[a[0]*col+a[1]].setIcon(Box);
    }
    //创建墙
    private void createWall() {
        for(int e:wallLocal){
            jl[e].setIcon(Wall);
        }
    }
    //创建目的地
    private void setDes(){
        jl[des[0]*col+des[1]].setIcon(Des);
    }
    //判断是否撞墙
    public boolean in(int x,int y){
        return x >= 0 && y >= 0 && x < row && y < col && !wallLocal.contains(x * col + y);
    }
    //键盘监听器
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

    //主函数
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new MoveBox(8,8);
    }
}

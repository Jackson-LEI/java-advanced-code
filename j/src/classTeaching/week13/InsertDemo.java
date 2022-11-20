package classTeaching.week13;

public class InsertDemo {
    public static void main(String[] args) {
        //        try {
        //            Class.forName("com.mysql.cj.jdbc.Driver");
        //            Connection c = DriverManager.getConnection(
        //                    "jdbc:mysql://127.0.0.1:3306/mydb2021?user=root&password=jinlei20011218");
        //            Statement s = c.createStatement();
        String insert = "insert into member values('雷','102030','男','2001-12','学Java','啦啦啦','JXUT');";
        MyDB db = new MyDB();
        db.doUpdate(insert);
        db.close();
        //            int n = s.executeUpdate(insert);//影响行数
        //            if(n>0){
        //                JOptionPane.showMessageDialog(null,"插入数据成功！");
        //            }
        //            s.close();
        //            c.close();
        //            System.exit(0);
        //        } catch (ClassNotFoundException | SQLException e) {
        //            throw new RuntimeException(e);
        //        }

    }
}
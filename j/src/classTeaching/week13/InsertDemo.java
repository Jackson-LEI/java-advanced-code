package classTeaching.week13;

public class InsertDemo {
    public static void main(String[] args) {
        //        try {
        //            Class.forName("com.mysql.cj.jdbc.Driver");
        //            Connection c = DriverManager.getConnection(
        //                    "jdbc:mysql://127.0.0.1:3306/mydb2021?user=root&password=jinlei20011218");
        //            Statement s = c.createStatement();
        String insert = "insert into member values('��','102030','��','2001-12','ѧJava','������','JXUT');";
        MyDB db = new MyDB();
        db.doUpdate(insert);
        db.close();
        //            int n = s.executeUpdate(insert);//Ӱ������
        //            if(n>0){
        //                JOptionPane.showMessageDialog(null,"�������ݳɹ���");
        //            }
        //            s.close();
        //            c.close();
        //            System.exit(0);
        //        } catch (ClassNotFoundException | SQLException e) {
        //            throw new RuntimeException(e);
        //        }

    }
}